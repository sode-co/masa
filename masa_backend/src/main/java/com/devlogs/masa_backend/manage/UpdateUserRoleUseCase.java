package com.devlogs.masa_backend.manage;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class UpdateUserRoleUseCase {
    public static class Result {
        public static class Success extends Result {
        }

        public static class ConnectionError extends Result {

        }

        public static class UserDoesNotExist extends Result {

        }
        public static class NotRoleAllowError extends Result {

        }
    }

    private UserRepository userRepository;

    @Inject
    public UpdateUserRoleUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result executes (String userID ) {
        UserRole role = null;

        try {
            UserEntity userEntity = userRepository.getUserById(userID);
            if (userEntity == null) {
                return new Result.UserDoesNotExist();
            }

            if (userEntity.getRole().getType() == UserRole.TYPE.MEMBER) {
                role = new  UserRole(UserRole.TYPE.MENTOR);
            } else if (userEntity.getRole().getType() == UserRole.TYPE.MENTOR) {
                role = new  UserRole(UserRole.TYPE.MEMBER);
            } else return new Result.NotRoleAllowError();

            userRepository.updateUserRole(userID, role);
            return new Result.Success();
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }


}
