package com.devlogs.masa_backend.login;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.google_api.GoogleGetUserEndpoint;
import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
import com.devlogs.masa_backend.domain.ports.testonly.UserRepository;
import com.devlogs.masa_backend.login.LoginWithGoogleUseCase.Result;
import com.devlogs.masa_backend.login.LoginWithGoogleUseCase.Result.*;
import com.devlogs.masa_backend.login_convention.EmailValidator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class LoginWithGoogleUseCaseTest {
    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final String EMAIL = "EMAIL";
    private static final String ID = "ID";
    private static final String FULL_NAME;
    private static final String GIVEN_NAME = "GIVEN_NAME";
    private static final String FAMILY_NAME = "FAMILY_NAME";
    private static final String NAME = "NAME";
    private static final UserStatus ACTIVE_STATUS = new UserStatus(UserStatus.STATUS.ACTIVE);
    private static final UserRole NOT_ADMIN_ROLE = new UserRole(UserRole.TYPE.STUDENT);
    private static final UserRole ADMIN_ROLE = new UserRole(UserRole.TYPE.ADMIN);
    private static final UserEntity NON_INITIALIZE_USER = new UserEntity("", "", "", null, null);
    private static final UserEntity NOT_ADMIN_USER;
    private static final UserEntity ADMIN_USER;
    private static final GooglePojo GOOGLE_POJO;

    static {
        FULL_NAME = FAMILY_NAME+GIVEN_NAME;
        NOT_ADMIN_USER = new UserEntity(ID,EMAIL, FULL_NAME, NOT_ADMIN_ROLE, ACTIVE_STATUS);
        ADMIN_USER = new UserEntity(ID,EMAIL, FULL_NAME, ADMIN_ROLE, ACTIVE_STATUS);
        GOOGLE_POJO = new GooglePojo(ID,EMAIL, true,NAME,GIVEN_NAME, FAMILY_NAME, "","");
    }

    private LoginWithGoogleUseCase SUT;
    private GoogleGetUserEndpointTdImp googleGetUserEndpointTd;
    private UserRepositoryTdImp userRepository;
    private EmailValidatorTdImp emailValidator;

    @Before
    public void setup () {
        googleGetUserEndpointTd = new GoogleGetUserEndpointTdImp();
        userRepository = new UserRepositoryTdImp();
        emailValidator = new EmailValidatorTdImp();
        SUT = new LoginWithGoogleUseCase(googleGetUserEndpointTd, userRepository,emailValidator);
    }

    /*
    1. Điền đúng access token của admin, trả về success với role admin
    2. Điền đúng access token, trả về success
    3. Điền access token có tồn tại trong db, có gọi get user ( có sự tương tác với userRepository.Get)
    4. Access token có truyền được tới endpoint
    5. Endpoint general error, trả về general error
    6. Endpoint auth error, trả về auth error
    7. Access token có email không thuộc về fpt cũng không phải admin, trả về not allow
    8. Access token có email không thuộc về fpt nhưng đã đăng ký là admin, trả về Success
    9. Nếu user email là của fpt nhưng không tồn tại trong db, có gọi tạo user mới (có tương tác với userRepository.Add)
    10. Access token có email không thuộc về fpt cũng không phải admin, không lưu vào db (không có sự tương tác với userRepository.Add)
    11. Thông tin của user lấy từ db với user trả về trong success phải giống nhau
     */

    @Test
    public void loginWithGoogle_correctAccessToken_successReturned () {
        Result result = SUT.executes(ACCESS_TOKEN);
        assertThat(result, instanceOf(Success.class));
    }

    @Test
    public void loginWithGoogle_accessTokenPassedToEndPoint () {
        SUT.executes(ACCESS_TOKEN);
        assertThat(googleGetUserEndpointTd.accessToken, is(ACCESS_TOKEN));
    }

    @Test
    public void loginWithGoogle_endPointGeneralError_GeneralErrorReturned () {
        googleGetUserEndpointTd.isGeneralError = true;
        Result result = SUT.executes(ACCESS_TOKEN);
        assertThat(result, instanceOf(GeneralError.class));
    }

    @Test
    public void loginWithGoogle_endPointAuthError_AuthErrorReturned () {
        googleGetUserEndpointTd.isAuthError = true;
        Result result = SUT.executes(ACCESS_TOKEN);
        assertThat(result, instanceOf(AuthError.class));
    }

    @Test
    public void loginWithGoogle_endPointConnectionExceptionOccurs_GeneralErrorReturned () {
        googleGetUserEndpointTd.isConnectionError = true;
        Result result = SUT.executes(ACCESS_TOKEN);
        assertThat(result, instanceOf(GeneralError.class));
    }

    @Test
    public void loginWithGoogle_accessTokenNotFptAndNotAdmin_NotAllowReturned () {
        userRepository.isUserNotfound = true;
        emailValidator.isFptEmail = false;
        Result result = SUT.executes(ACCESS_TOKEN);
        assertThat(result, instanceOf(NotAllowed.class));
    }

    @Test
    public void loginWithGoogle_accessTokenNotFptButAdmin_successReturned () {
        userRepository.isAdmin = true;
        emailValidator.isFptEmail = false;
        Result result = SUT.executes(ACCESS_TOKEN);
        assertThat(result, instanceOf(Success.class));
    }

    @Test
    public void loginWithGoogle_accessTokenIsFptButNotInDb_hasInteractionWithUserRepositoryAddMethod () {
        emailValidator.isFptEmail = true;
        userRepository.isUserNotfound = true;
        userRepository.isAdmin = false;
        SUT.executes(ACCESS_TOKEN);
        assertThat(userRepository.user, equalTo(NOT_ADMIN_USER ));
    }

    @Test
    public void loginWithGoogle_accessTokenIsNotFptAndNotInDb_noInteractionWithUserRepositoryAddMethod () {
        emailValidator.isFptEmail = false;
        userRepository.isUserNotfound = true;
        userRepository.isAdmin = false;
        SUT.executes(ACCESS_TOKEN);
        assertThat(userRepository.user, is(NON_INITIALIZE_USER));
    }

    @Test
    public void loginWithGoogle_googlePojoIsPassedCorrectlyToRepository () {
        userRepository.isUserNotfound = true;
        emailValidator.isFptEmail = true;
        SUT.executes(ACCESS_TOKEN);
        assertThat(userRepository.user.getFullName(), equalTo(GOOGLE_POJO.getFullName()));
        assertThat(userRepository.user.getEmail(), equalTo(GOOGLE_POJO.getEmail()));
    }

    @Test
    public void loginWithGoogle_successReturned_successUserMatchWithRepositoryUserData () {
        Result result = SUT.executes(ACCESS_TOKEN);
        assertThat(result, instanceOf(Success.class));
        assertThat(((Success)result).user, equalTo(NOT_ADMIN_USER));
    }

    private static class GoogleGetUserEndpointTdImp implements GoogleGetUserEndpoint {
        public String accessToken;
        public boolean isGeneralError;
        public boolean isAuthError;
        public boolean isConnectionError;

        @Override
        public Result getUser(String accessToken) throws ConnectionException {
            if (isGeneralError) {
                return new Result.GeneralError();
            }
            if (isAuthError) {
                return new Result.AuthError();
            }
            if (isConnectionError) {
                throw new ConnectionException("");
            }
            this.accessToken = accessToken;
            return new Result.Success(GOOGLE_POJO);
        }
    }

    private static class UserRepositoryTdImp implements UserRepository {
        public boolean isConnectionExceptionOccurs = false;
        public boolean isUserNotfound = false;
        public boolean isAdmin = false;
        public UserEntity user = NON_INITIALIZE_USER;

        @Override
        public UserEntity getUserByEmail(String email) throws ConnectionException {
            if (isConnectionExceptionOccurs) {
                throw new ConnectionException("");
            }

            if (isUserNotfound) {
                return null;
            }

            if (isAdmin) {
                return ADMIN_USER;
            }

            return NOT_ADMIN_USER;
        }

        @Override
        public UserEntity addUser(String email, String fullName, String avatar, UserRole role, UserStatus userStatus) throws ConnectionException {
            if (isConnectionExceptionOccurs) {
                throw new ConnectionException("");
            }
                this.user = new UserEntity(ID, email, fullName, role, userStatus);
                return this.user;
            }
        }

    private static class EmailValidatorTdImp implements EmailValidator {
        public boolean isFptEmail = false;

        @Override
        public Result check(String email) {
            if (isFptEmail) {
                return new Result(NOT_ADMIN_ROLE, true);
            } else {
                return new Result(null, false);
            }
        }
    }
}