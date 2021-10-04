package com.devlogs.masa_backend.manage;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.repository.user.UserRepositoryImp;

import javax.inject.Inject;
import java.util.List;

public class GetAllUserUserCase {
    public static class Result {
        public static class Success extends Result {
            public List<UserEntity> users;

            public Success(List<UserEntity> users) {
                this.users = users;
            }
        }
        public static class ConnectionError extends Result {

        }
    }

    private UserRepository userRepository;

    @Inject
    public GetAllUserUserCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result executes() {
        try {
            List<UserEntity> users = userRepository.getAllUser();
            return new Result.Success(users);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }

//    private UserRepositoryImp userRepositoryImp;
//
//    @Inject
//    public GetAllUserUserCase(UserRepositoryImp userRepositoryImp) {
//        this.userRepositoryImp = userRepositoryImp;
//    }
//
//    public Result executes() {
//        try {
//            List<UserEntity> users = userRepositoryImp.getAllUser();
//            return new Result.Success(users);
//        } catch (ConnectionException e) {
//            return new Result.ConnectionError();
//        }
//    }
}
