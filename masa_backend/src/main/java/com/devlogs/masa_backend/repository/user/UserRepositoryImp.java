package com.devlogs.masa_backend.repository.user;

import com.devlogs.masa_backend.data.remote_database.UserDao;
import com.devlogs.masa_backend.data.remote_database.UserDto;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.AlreadyExistException;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import java.sql.SQLException;

public class UserRepositoryImp implements UserRepository {

    private UserEntity userEntity;
    private UserDao dao;
    private UserDto dto;

    public UserRole convertRole(int role_id) {
        UserRole.TYPE type = null;
        for (UserRole.TYPE value : UserRole.TYPE.values()) {
                type = UserRole.TYPE.values()[role_id-1];
        }
        return new UserRole(type);
    }

    public UserStatus convertStatus(int status_id) {
        UserStatus.STATUS status;
        if (status_id == 1){
            status = UserStatus.STATUS.BLOCKED;
        }
        else status = UserStatus.STATUS.ACTIVE;

        return new UserStatus(status);
    }

    public UserEntity convertDto(UserDto dto ){

        UserEntity entity = new UserEntity(dto.getId(), dto.getEmail(), dto.getFullName(),
                                           convertRole(dto.getRole_ID()), convertStatus(dto.getStatus_id()));
         return entity;
    }


    @Override
    public UserEntity getUserByEmail(String email) throws ConnectionException {

       try {
           dto = dao.getUserByEmail(email);
            userEntity = convertDto(dto);

        }catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch(ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return userEntity;
    }

    @Override
    public UserEntity getUserById(String id) throws ConnectionException {
        try {
            dto = dao.getUserById(id);
            System.out.println("@@@@@skjfkl");
            userEntity = convertDto(dto);
        }catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch(ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return userEntity;
    }

    @Override
    public UserEntity addUser(String email, String fullName, String avatar, UserRole role, UserStatus userStatus)
                    throws ConnectionException, AlreadyExistException {
        try {
            int role_id ;
            if (role.toString().equals("ADMIN")){
                role_id =1;
            } else if (role.toString().equals("STUDENT")){
                role_id =2;
            } else if (role.toString().equals("GUEST")){
                role_id =3;
            } else role_id = 4 ;

            int status_id = 0;
            if (userStatus.toString().equals("BLOCKED")){
                status_id = 1;
            } else status_id = 2;
            dto = dao.addUser(email, fullName, avatar,role_id, status_id);
            userEntity = convertDto(dto);

        }catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch(ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return userEntity;
    }

}
