package com.devlogs.masa_backend.manage;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class UpdateUserRoleUseCase {
    public static class Result {
        public static class Success extends Result {
            public UserEntity userEntity;

            public Success(UserEntity userEntity) {
                this.userEntity = userEntity;
            }
        }

        public static class ConnectionError extends Result {

        }

        public static class UserDoesNotExist extends Result {

        }
    }

    private UserRepository userRepository;
    @Inject
    public UpdateUserRoleUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result executes (String userID , UserRole.TYPE role) {
        try {
            UserEntity userEntity = userRepository.getUserById(userID);
            if (userEntity == null) {
                return new Result.UserDoesNotExist();
            }
            UserEntity userUpdated = userRepository.updateUserRole(userID,role);
            return new Result.Success(userUpdated);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        } catch (NotFoundException e) {
            return new Result.UserDoesNotExist();
        }
    }
}
