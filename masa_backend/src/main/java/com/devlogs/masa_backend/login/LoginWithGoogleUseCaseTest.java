//package com.devlogs.masa_backend.login;
//
//import com.devlogs.masa_backend.domain.entities.UserEntity;
//import com.devlogs.masa_backend.domain.entities.UserRole;
//import com.devlogs.masa_backend.domain.entities.UserStatus;
//import com.devlogs.masa_backend.domain.errors.ConnectionException;
//import com.devlogs.masa_backend.domain.errors.NotFoundException;
//import com.devlogs.masa_backend.domain.ports.UserRepository;
//import com.devlogs.masa_backend.domain.ports.google_api.GoogleGetUserEndpoint;
//import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
//import org.junit.Before;
//import java.util.List;
//
//class LoginWithGoogleUseCaseTest {
//    public static final String ACCESS_TOKEN = "access_token";
//    public static final String NO_ACCESS_TOKEN = "no_access_token";
//    public static final GooglePojo LOGIN_SUCCESS_GOOGLE_POJO = new GooglePojo();
//    LoginWithGoogleUseCase SUT;
//    GoogleGetUserEndPointTdImp googleUserTdImp;
//
//    @Before
//    public void setup () {
////        getGoogleUserTdImp = new GetGoogleUserTdImp();
////        SUT = new LoginWithGoogleUseCase(googleUserTdImp,  null, emailLoginRule);
//    }
//
//    private static class UserRepositoryTdImp implements UserRepository {
//
//        @Override
//        public UserEntity getUserByEmail(String email) throws ConnectionException {
//            return null;
//        }
//
//        @Override
//        public List<UserEntity> getAllAdmin() throws ConnectionException {
//            return null;
//        }
//
//        @Override
//        public void updateUserRole(String userId, UserRole newRole) throws ConnectionException {
//
//        }
//
//        @Override
//        public UserEntity getUserById(String id) throws ConnectionException {
//            return null;
//        }
//
//        @Override
//        public UserEntity addUser(String email, String fullName, String avatar, UserRole role, UserStatus userStatus) throws ConnectionException {
//            return null;
//        }
//
//        @Override
//        public List<UserEntity> getAllUser() throws ConnectionException {
//            return null;
//        }
//
//        @Override
//        public UserEntity blockUser(String userID, UserStatus status) throws ConnectionException, NotFoundException {
//            return null;
//        }
//    }
//
//    private static class GoogleGetUserEndPointTdImp implements GoogleGetUserEndpoint {
//        public String currentAccessToken = NO_ACCESS_TOKEN;
//        public boolean isConnectionExceptionOccurs = false;
//
//        @Override
//        public GoogleGetUserEndpoint.Result getUser(String accessToken) throws ConnectionException {
//            if (isConnectionExceptionOccurs) {
//                throw new ConnectionException("");
//            }
//            this.currentAccessToken = accessToken;
//
////            return LOGIN_SUCCESS_GOOGLE_POJO;
////        }
//    }
//
//}