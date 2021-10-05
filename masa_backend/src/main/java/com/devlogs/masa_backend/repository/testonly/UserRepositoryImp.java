package com.devlogs.masa_backend.repository.testonly;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.remote_database.UserDao;
import com.devlogs.masa_backend.data.remote_database.UserDto;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.testonly.UserRepository;

import javax.inject.Inject;
import java.sql.SQLException;

public class UserRepositoryImp implements UserRepository {

    private UserEntity userEntity;
    private UserDao dao;// chỉ có dao ở đây
    private UserDto dto;

    @Inject
    public UserRepositoryImp(UserDao dao) {
        this.dao = dao;
    }

    public UserRole convertRole(int role_id) {
        UserRole.TYPE type = null;
        for (UserRole.TYPE value : UserRole.TYPE.values()) {
            type = UserRole.TYPE.values()[role_id - 1];
        }
        return new UserRole(type);
    }

    public UserStatus convertStatus(int status_id) {
        UserStatus.STATUS status;
        if (status_id == 1) {
            status = UserStatus.STATUS.BLOCKED;
        } else status = UserStatus.STATUS.ACTIVE;

        return new UserStatus(status);
    }

    public UserEntity convertDto(UserDto dto) {

        UserEntity entity = new UserEntity(dto.getId(), dto.getEmail(), dto.getFullName(),
                convertRole(dto.getRole_ID()), convertStatus(dto.getStatus_id()));
        return entity;
    }


    @Override
    public UserEntity getUserByEmail(String email) throws ConnectionException {

        try {
            dto = dao.getUserByEmail(email);
            if (dto != null) {
                userEntity = convertDto(dto);
            } else return null;

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return userEntity;
    }
    @Override
    public UserEntity addUser(String email, String fullName, String avatar, UserRole role, UserStatus userStatus)
            throws ConnectionException {

        int role_id;
        int status_id;
        try {
//            MasaLog.normalLog("role type:  " + role.getType() );
//            MasaLog.normalLog("trung voi student khong " + (role.getType()).toString().equals("STUDENT") );
            if ((role.getType()).toString().equals("ADMIN")) {
                role_id = 1;
                MasaLog.normalLog("admin 1 ");
            } else if ((role.getType()).toString().equals("STUDENT")) {
                role_id = 2;
                MasaLog.normalLog("student");
            } else if ((role.getType()).toString().equals("GUEST")) {
                role_id = 3;
                MasaLog.normalLog("admin 3 ");
            } else if ((role.getType()).toString().equals("MENTOR")) {
                role_id = 4;
                MasaLog.normalLog("admin 4 ");
            } else return null;


            if ((userStatus.getStatus()).toString().equals("BLOCKED")) {
                status_id = 1;
            } else if ((userStatus.getStatus()).toString().equals("ACTIVE")) {
                status_id = 2;
            } else return null;

            dto = dao.addUser(email, fullName, avatar, role_id, status_id);
            //MasaLog.normalLog("dto la: "+ dto.toString());

            if (dto != null) {
                userEntity = convertDto(dto);
            } else return null;

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return userEntity;
    }


}
