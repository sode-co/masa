package com.devlogs.masa_backend.repository.user;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.AlreadyExistException;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.UserRepository;

public class UserRepositoryImp implements UserRepository {
    @Override
    public UserEntity getUserByEmail(String email) throws ConnectionException {
        return null;
    }

    @Override
    public UserEntity getUserById(String id) throws ConnectionException {
        return null;
    }

    @Override
    public UserEntity addUser(String email, String fullName, String avatar, UserRole role, UserStatus userStatus) throws ConnectionException, AlreadyExistException {
        return null;
    }

}
