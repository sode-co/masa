package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.AlreadyExistException;
import com.devlogs.masa_backend.domain.errors.ConnectionException;

import java.util.List;

public interface UserRepository {
    /*
     * Quy tắc tạo ports cho usecase ở đây là repository interface:
     * 1. Chỉ tạo đúng những thứ mình thật sự cần.
     * 2. Return luôn luôn là Entity
     * 3. Exception không thuộc module cấp thấp, tức là phải tự tạo exception trong domain.errors
     * 4. Chỉ khai báo những exception mà mình dự đoán được sẽ xảy ra, nhưng không tránh được.
     * Mọi người có thể vào https://stackoverflow.com/questions/27578/when-to-choose-checked-and-unchecked-exceptions để biết thêm
     * */
    UserEntity getUserByEmail (String email) throws ConnectionException;

    List<UserEntity> getUserByRole (int roleId) throws ConnectionException;

    UserEntity getUserById(String id) throws ConnectionException;

    UserEntity addUser (String email, String fullName, String avatar, UserRole role, UserStatus userStatus) throws ConnectionException, AlreadyExistException;

}
