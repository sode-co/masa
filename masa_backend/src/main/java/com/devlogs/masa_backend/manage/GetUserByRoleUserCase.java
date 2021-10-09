package com.devlogs.masa_backend.manage;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import javax.inject.Inject;
import java.util.List;

public class GetUserByRoleUserCase {
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
        public static class NotRoleAllowError extends Result {

        }
    }

    private UserRepository userRepository;

    @Inject
    public GetUserByRoleUserCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result executes(String roleName ) {
        UserRole role;
        if (roleName.equalsIgnoreCase("MENTOR")){
            role = new UserRole(UserRole.TYPE.MENTOR);
        } else if (roleName.equalsIgnoreCase("MEMBER")) {
            role = new UserRole(UserRole.TYPE.MEMBER);
        } else if  (roleName.equalsIgnoreCase("ADMIN")) {
            role = new UserRole(UserRole.TYPE.ADMIN);
        } else if  (roleName.equalsIgnoreCase("STUDENT")) {
            role = new UserRole(UserRole.TYPE.STUDENT);
        } else return new Result.NotRoleAllowError();

        try {
            List<UserEntity> users = userRepository.getUserByRole(role);
            if ( users.size() != 0) {
                return new Result.Success(users);
            } else
                return new Result.NoUserExist();

        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
