package com.devlogs.masa_backend.domain.ports.testonly;


import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.ConnectionException;


public interface UserRepository {
    UserEntity getUserByEmail (String email) throws ConnectionException;

    UserEntity addUser (String email, String fullName, String avatar, UserRole role, UserStatus userStatus) throws ConnectionException;
}

