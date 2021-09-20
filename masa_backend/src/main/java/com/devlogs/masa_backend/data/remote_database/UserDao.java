package com.devlogs.masa_backend.data.remote_database;

import com.devlogs.masa_backend.data.common.DbHelper;
import com.devlogs.masa_backend.domain.errors.AlreadyExistException;
import com.devlogs.masa_backend.domain.errors.ConnectionException;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserDao {

    private DbHelper dbHelper;

    @Inject
    public UserDao(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public UserDao() {

    }

    public static void main(String[] args) {
        UserDao dao = new UserDao();
    }


    public UserDto getUserById(String Id)
            throws SQLException, ConnectionException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm= null;
        ResultSet rs= null;
        try {
            //1. connect database
            con = dbHelper.connect();

            //2. create sql statement String
            if (con != null) {
                String sql = "Select id, fullName, email, avatar_url, role_id, status_id "
                        + "From Users "
                        + "WHERE id = ?";

                //3. Create statement to set sql
                stm = con.prepareStatement(sql);
                stm.setString(1, Id);

                //4. execute query
                rs = stm.executeQuery();
                //5. process
                if( rs.next()){
                    String id = rs.getString(1);
                    String fullName = rs.getString(2);
                    String email = rs.getString(3);
                    String avatar_url = rs.getString(4);
                    int role_id = rs.getInt(5);
                    int status_id = rs.getInt(6);

                    return  new UserDto(id, fullName, email,avatar_url, role_id, status_id);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;

    }

    public UserDto getUserByEmail(String email)  throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm= null;
        ResultSet rs= null;

        try {
            //1. connect database
            con = dbHelper.connect();

            //2. create sql statement String
            if (con != null) {
                String sql = "Select id, fullName, email, avatar_url, role_id, status_id "
                        + "From Users "
                        + "WHERE Users.email = ?";

                //3. Create statement to set sql
                stm = con.prepareStatement(sql);
                stm.setString(1, email);

                //4. execute query
                rs = stm.executeQuery();
                //5. process
                if( rs.next()) {
                    String id = rs.getString(1);
                    String fullName = rs.getString(2);
                    String email1 = rs.getString(3);
                    String avatar_url = rs.getString(4);
                    int role_id = rs.getInt(5);
                    int status_id = rs.getInt(6);

                    return  new UserDto(id, fullName, email1, avatar_url, role_id, status_id);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }


    public UserDto addUser (String email, String fullName, String avatar_url, int role_id, int status_id)
            throws SQLException, ConnectionException, AlreadyExistException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm= null;

        try {
            //1. connect database
            con = dbHelper.connect();

            //2. create sql statement String
            if (con != null) {
                String id = UUID.randomUUID().toString().substring(0,8);
                System.out.println("ID la  "+ id);
                String sql = "INSERT INTO Users(id, fullName, email, avatar_url, role_id, status_id) "
                        + "VALUES(?, ?, ?, ?, ?, ?)";

                //3. Create statement to set sql
                stm = con.prepareStatement(sql);

                stm.setString(1, id);
                stm.setString(2, fullName);
                stm.setString(3, email);
                stm.setString(4, avatar_url);
                stm.setInt(5, role_id);
                stm.setInt(6, status_id);

                //4. execute query
                stm.execute();
                //5. process
//                if( rows > 0){
//
                    return  new UserDto(id, fullName, email,avatar_url, role_id, status_id);
//                }

            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;

    }

}
