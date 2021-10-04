package com.devlogs.masa_backend.repository.user;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.remote_database.UserDao;
import com.devlogs.masa_backend.data.remote_database.UserDto;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserStatus;
import com.devlogs.masa_backend.domain.errors.AlreadyExistException;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.domain.ports.google_api.GooglePojo;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.devlogs.masa_backend.common.Masa.GOOGLE_LINK_GET_USER_INFO;

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

    public UserEntity getUserByGGAccessToken (String accessToken) throws ConnectionException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = null;
        try {
            response = Request.Get(link).execute().returnContent().asString();
            MasaLog.normalLog("Json: " + response);
            GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
            return getUserByEmail(googlePojo.getEmail());
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public List<UserEntity> getAllAdmin() throws ConnectionException {
        try {
            List<UserDto> queryResult = dao.getUserByRole(1);
            return queryResult.stream().map((item) -> convertDto(item)).collect(Collectors.toList());
        }catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch(ClassNotFoundException ex) {
            throw new ConnectionException(ex.getMessage());
        }
    }

    @Override
    public void updateUserRole(String userId, UserRole newRole) throws ConnectionException {
        int roleId = 0;
        switch (newRole.getType()) {
            case MENTOR: {
                roleId = 4;
                break;
            }
            case GUEST: {
                roleId = 3;
                break;
            }
            case ADMIN: {
                roleId = 1;
                break;
            }
            case STUDENT:{
                roleId = 2;
                break;
            }
            default: {
                throw new RuntimeException(String.format("UserRole {%s} is not yet supported by userRepository", newRole.getType().name()));
            }
        }

        try {
           dao.updateUserRole(userId, roleId);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override
    public UserEntity getUserById(String id) throws ConnectionException {
        try {
            dto = dao.getUserById(id);
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

    @Override
    public List<UserEntity> getAllUser() throws ConnectionException {
        List<UserEntity> result = new ArrayList<>();
        try {
            List<UserDto> list = dao.getAllUsers();
            if (list.size() != 0) {
                for (UserDto dto : list) {
                        result.add(convertDto(dto));

                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }

    @Override
    public UserEntity blockUser(String userID, UserStatus status) throws ConnectionException, NotFoundException {
        UserEntity result = null;
        try {
            int statusID = 0;
            if (status.getStatus().toString().equals("BLOCKED")) {
                statusID = 1;
            }
            if (statusID == 1) {
                UserDto dto = dao.blockUser(userID, statusID);
                if (dto != null) {
                    result = convertDto(dto);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }



}
