package com.devlogs.masa_backend.login;

import com.devlogs.masa_backend.domain.ports.google_api.GoogleGetUserEndpoint;
import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.login_convention.EmailValidator;

import static com.devlogs.masa_backend.login.LoginWithGoogleUseCase.Result.*;

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

        public static class AuthError extends Result {
        }

        public static class GeneralError extends Result {
        }
    }

    private final GoogleGetUserEndpoint loginApi;
    private final UserRepository userRepository;
    private final EmailValidator emailValidator;

    @Inject
    public LoginWithGoogleUseCase(GoogleGetUserEndpoint loginApi, UserRepository userRepository, EmailValidator emailValidator) {
        this.loginApi = loginApi;
        this.userRepository = userRepository;
        this.emailValidator = emailValidator;
    }

    public Result executes(String googleAccessToken) {
        try {
            GoogleGetUserEndpoint.Result getUserResult = loginApi.getUser(googleAccessToken);

            if (getUserResult instanceof GoogleGetUserEndpoint.Result.AuthError) {
                return new AuthError();
            }

            if (getUserResult instanceof GoogleGetUserEndpoint.Result.GeneralError) {
                return new GeneralError();
            }
            GooglePojo pojo = ((GoogleGetUserEndpoint.Result.Success) getUserResult).googlePojo;
            String fullName = pojo.getFullName();
            String email = pojo.getEmail();

            UserEntity user = userRepository.getUserByEmail(pojo.getEmail());
            if (user != null) {
                return new Success(user);
            }

            EmailValidator.Result validatorResult = emailValidator.check(email);
            if (!validatorResult.isValid) {
                return new NotAllowed();
            }
            user = userRepository.addUser(email, fullName, pojo.getPicture(), validatorResult.role, new UserStatus(UserStatus.STATUS.ACTIVE));
            return new Result.Success(user);
        } catch (ConnectionException ex) {
            return new Result.GeneralError();
        }
    }
}
