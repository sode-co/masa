package com.devlogs.masa_backend.login;

import com.devlogs.masa_backend.api.google.GoogleGetUserInfoEndpointImp;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.google_api.GoogleGetUserEndpoint;
import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
import com.devlogs.masa_backend.domain.ports.testonly.UserRepository;
import com.devlogs.masa_backend.login.LoginWithGoogleUseCase.Result;
import com.devlogs.masa_backend.login_convention.EmailValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.devlogs.masa_backend.login.LoginWithGoogleUseCase.Result.*;
import static com.devlogs.masa_backend.login.common.TestConfig.GROUP.HAS_INTERACTION_WITH_USER_REPOSITORY;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginWithGoogleUseCaseTestt {
    //region INITIALIZE
    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    private static final String EMAIL = "EMAIL";
    private static final String ID = "ID";
    private static final String FULL_NAME;
    private static final String GIVEN_NAME = "GIVEN_NAME";
    private static final String FAMILY_NAME = "FAMILY_NAME";
    private static final String NAME = "NAME";
    private static final UserStatus ACTIVE_STATUS = new UserStatus(UserStatus.STATUS.ACTIVE);
    private static final UserRole NOT_ADMIN_ROLE = new UserRole(UserRole.TYPE.STUDENT);
    private static final UserEntity NON_INITIALIZE_USER = null;
    private static final UserEntity USER;
    private static final GooglePojo GOOGLE_POJO;

    static {
        GOOGLE_POJO = new GooglePojo(ID,EMAIL, true,NAME,GIVEN_NAME, FAMILY_NAME, "","");
        FULL_NAME = FAMILY_NAME + " " + GIVEN_NAME;
        USER = new UserEntity(ID,EMAIL, FULL_NAME, NOT_ADMIN_ROLE, ACTIVE_STATUS);
    }
    //endregion

    private LoginWithGoogleUseCase SUT;
    private UserRepositoryTdImp userRepository;
    private EmailValidatorTdImp emailValidator;
    private GoogleGetUserEndpointTdImp googleGetUserEndpoint;

    @BeforeMethod(alwaysRun = true)
    public void setup () {
        userRepository = new UserRepositoryTdImp();
        emailValidator = new EmailValidatorTdImp();
        googleGetUserEndpoint = new GoogleGetUserEndpointTdImp();
        SUT = new LoginWithGoogleUseCase(googleGetUserEndpoint, userRepository, emailValidator);
    }

    // dump class
    private static class GoogleGetUserEndpointTdImp implements GoogleGetUserEndpoint {
        public boolean isGeneralErrorOccurs = false;
        public boolean isAuthErrorOccurs = false;
        public boolean isConnectionExceptionOccurs = false;
        public String accessToken;

        @Override
        public Result getUser(String accessToken) throws ConnectionException {
            if (isGeneralErrorOccurs) {
                return new Result.GeneralError();
            }
            if (isAuthErrorOccurs) {
                return new Result.AuthError();
            }

            if (isConnectionExceptionOccurs) {
                throw new ConnectionException("");
            }
            this.accessToken = accessToken;
            return new Result.Success(GOOGLE_POJO);
        }
    }

    private static class UserRepositoryTdImp implements UserRepository {
        public boolean isConnectionExceptionOccurs = false;
        public boolean isUserNotFound = false;
        public UserEntity user;
        @Override
        public UserEntity getUserByEmail(String email) throws ConnectionException {
            if (isConnectionExceptionOccurs) {
                throw new ConnectionException("");
            }

            if (isUserNotFound) {
                return null;
            }

            return USER;
        }

        @Override
        public UserEntity addUser(String email, String fullName, String avatar, UserRole role, UserStatus userStatus) throws ConnectionException {
            if (isConnectionExceptionOccurs) {
                throw new ConnectionException("");
            }
            this.user = new UserEntity(ID, email, fullName, NOT_ADMIN_ROLE, ACTIVE_STATUS);

            return this.user;
        }
    }

    private static class EmailValidatorTdImp implements EmailValidator {
            public boolean isFptEmail = false;
            @Override
            public Result check(String email) {
                if (isFptEmail) {
                    return new Result(NOT_ADMIN_ROLE, true);
                }
                return new Result(null, false);
            }
        }


    // 1. ACCESS TOKEN IS PASSED TO GOOGLE ENDPOINT
        @Test
        public void loginWithGoogle_accessTokenIsPassedToEndpoint () throws ConnectionException {
            SUT.executes(ACCESS_TOKEN);
            this.googleGetUserEndpoint.getUser(ACCESS_TOKEN);
            assertEquals(googleGetUserEndpoint.accessToken, ACCESS_TOKEN);
        }
    // 2. GOOGLE POJO IS PASSED CORRECTLY TO REPOSITORY
        @Test
        public void loginWithGoogle_googlePojoIsPassedCorrectlyToUserRepository () throws ConnectionException {
            userRepository.isUserNotFound = true; // chưa đăng nhập vào ứng dụng lần nào, đăng nhập lần đầu
            emailValidator.isFptEmail = true; // phải email của fpt
            SUT.executes(ACCESS_TOKEN);
            assertEquals(userRepository.user.getFullName(), GOOGLE_POJO.getFullName());
            assertEquals(userRepository.user.getEmail(), GOOGLE_POJO.getEmail());
        }
    // 3. IF ACCESS TOKEN IS CORRECT THEN SUCCESS RESULT RETURNED
    // 4. ACCESS TOKEN NOT FPT AND NOT IN DB, THEN NOT ALLOWED RETURNED
        @Test
        public void loginWithGoogle_accessTokenNotFptAndNotInDb_notAllowedReturned () {
            userRepository.isUserNotFound = true;
            emailValidator.isFptEmail = false;
            Result result = SUT.executes(ACCESS_TOKEN);
            assertTrue(result instanceof NotAllowed);
        }
    // 5. ACCESS TOKEN NOT FPT BUT IN DB, THEN SUCCESS RETURNED
        @Test
        public void loginWithGoogle_accessTokenNotFptAndButInDb_successReturned () {
            userRepository.isUserNotFound = false;
            emailValidator.isFptEmail = false;
            Result result = SUT.executes(ACCESS_TOKEN);
            assertTrue(result instanceof Success);
        }
    // 6. ACCESS TOKEN IS NOT FPT AND NOT IN DB, THEN THERE IS NO INTERACTION WITH USER REPOSITORY ADD METHOD
    // **7. ACCESS TOKEN IS FPT BUT NOT IN DB, THEN HAS INTERACTION WITH USER REPOSITORY ADD METHOD
        @Test
        public void loginWithGoogle_accessTokenIsFptButNotInDb_hasInteractionWithUserRepositoryAddMethod () {
            userRepository.isUserNotFound = true;
            emailValidator.isFptEmail = true;
            SUT.executes(ACCESS_TOKEN);
            assertEquals(userRepository.user, USER);
        }
    // 8. ENDPOINT RETURN GENERAL ERROR THEN GENERAL ERROR RETURNED
        @Test
        public void loginWithGoogle_endPointReturnGeneralError_generalReturned () {
            googleGetUserEndpoint.isGeneralErrorOccurs = true;
            Result result = SUT.executes(ACCESS_TOKEN);
            assertTrue(result instanceof GeneralError);
        }
    // 9. ENDPOINT RETURN AUTH ERROR THEN AUTH ERROR RETURNED
    // 10.ENDPOINT RETURN GENERAL ERROR, THEN THERE IS NO INTERACTION WITH REPOSITORY
    // 11. END POINT RETURN AUTHENTICATION ERROR, THEN THERE IS NO INTERACTION WITH USER REPOSITORY ADD METHOD
        @Test
        public void loginWithGoogle_endPointReturnAuthError_authErrorReturned () {
            googleGetUserEndpoint.isAuthErrorOccurs = true;
            SUT.executes(ACCESS_TOKEN);
            assertEquals(userRepository.user, NON_INITIALIZE_USER);
        }
    // 12. ENDPOINT THROW CONNECTION EXCEPTION, THEN THERE IS NO INTERACTION WITH REPOSITORY
    // 13. ENDPOINT THROWS CONNECTION EXCEPTION THEN GENERAL ERROR RETURNED
    // 14. USER REPOSITORY CONNECTION EXCEPTION OCCURS THEN GENERAL ERROR RETURNED
    // 15. SUCCESS RESULT RETURN THE SAME USER THAT GET FORM REPOSITORY

}