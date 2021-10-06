package com.devlogs.masa_backend.manage;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class UpdateUserStatusUseCase {
    public static class Result {
        public static class Success extends UpdateUserStatusUseCase.Result {
        }

        public static class ConnectionError extends UpdateUserStatusUseCase.Result {

        }

        public static class UserDoesNotExist extends UpdateUserStatusUseCase.Result {

        }
        public static class NotAllowToUpdate extends UpdateUserStatusUseCase.Result {

        }
    }

    private UserRepository userRepository;

    @Inject
    public UpdateUserStatusUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result executes (String userID ) {
        UserStatus status = null;

        try {
            UserEntity userEntity = userRepository.getUserById(userID);
            if (userEntity == null) {
                return new UpdateUserStatusUseCase.Result.UserDoesNotExist();
            }

            if (userEntity.getRole().getType() == UserRole.TYPE.ADMIN) {
                return new UpdateUserStatusUseCase.Result.NotAllowToUpdate();
            }

            if (userEntity.getStatus().getStatus() == UserStatus.STATUS.ACTIVE) {
                status = new  UserStatus(UserStatus.STATUS.BLOCKED);
            } else if (userEntity.getStatus().getStatus() == UserStatus.STATUS.BLOCKED) {
                status = new  UserStatus(UserStatus.STATUS.ACTIVE);
            }
//            else return new UpdateUserStatusUseCase.Result.NotAllowToUpdateAdmin();

            userRepository.updateUserStatus(userID, status);
            return new UpdateUserStatusUseCase.Result.Success();
        } catch (ConnectionException e) {
            return new UpdateUserStatusUseCase.Result.ConnectionError();
        }
    }
}
