package com.devlogs.masa_backend.login;

import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.AlreadyExistException;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.domain.ports.google_api.LoginWithGoogleApi;

import javax.inject.Inject;

public class LoginWithGoogleUseCase {
    public static class Result {
        public static class Success extends Result {
            public UserEntity user;
            public Success(UserEntity user) {
                this.user = user;
            }
        }

        public static class NotAllowed extends Result {
        }

        public static class GeneralError extends Result {
            public String message;
            public GeneralError(String message) {
                this.message = message;
            }
        }
    }
    private LoginWithGoogleApi loginApi;
    private UserRepository userRepository;
    private EmailLoginRule emailLoginRule;

    @Inject
    public LoginWithGoogleUseCase(LoginWithGoogleApi loginApi, UserRepository userRepository, EmailLoginRule emailLoginRule) {
        this.loginApi = loginApi;
        this.emailLoginRule = emailLoginRule;
        this.userRepository = userRepository;
    }

    public Result executes (String googleAccessToken) {
        GooglePojo pojo = null;
        try {
            pojo = loginApi.login(googleAccessToken);
        } catch (ConnectionException e) {
            return new Result.GeneralError(e.getMessage());
        }
        String fullName = pojo.getFamily_name() + " " + pojo.getGiven_name();
        String email = pojo.getEmail();
        int numOfDigit = email.replaceAll("\\D+","").length();
        try {
            UserEntity user = userRepository.getUserByEmail(pojo.getEmail());
            if (user == null ) {
                if (!emailLoginRule.valid(email)) {
                    // check if they're admin
                        return new Result.NotAllowed();
                }
                UserRole userRole = null;
                // Student
                if (numOfDigit >= 4) {
                    userRole = new UserRole(UserRole.TYPE.STUDENT);
                    // Staff or Lecturer
                } else {
                    userRole = new UserRole(UserRole.TYPE.GUEST);
                }
                user = userRepository.addUser(email,fullName, pojo.getPicture(), userRole, new UserStatus(UserStatus.STATUS.ACTIVE));
            }

            return new Result.Success(user);
        } catch (ConnectionException | AlreadyExistException ex) {
            return new Result.GeneralError(ex.getMessage());
        }
    }
}
