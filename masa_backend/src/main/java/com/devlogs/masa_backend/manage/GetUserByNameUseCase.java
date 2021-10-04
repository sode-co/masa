package com.devlogs.masa_backend.manage;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;
import java.util.List;



public class GetUserByNameUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<UserEntity> users;

            public Success(List<UserEntity> users) {
                this.users = users;
            }
        }
        public static class ConnectionError extends Result {

        }
        public static class NoUserExist extends Result {

        }
    }

    private UserRepository userRepository;

    @Inject
    public GetUserByNameUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result executes() {
//        try {
//            List<UserEntity> users = userRepository.getuser(role);
//            if ( users.size() != 0) {
//                return new Result.Success(users);
//            } else
//                return new Result.NoUserExist();
//        } catch (ConnectionException e) {
//            return new Result.ConnectionError();
//        }
    }

}