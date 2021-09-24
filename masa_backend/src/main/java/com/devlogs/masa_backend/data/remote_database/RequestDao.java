package com.devlogs.masa_backend.data.remote_database;

import com.devlogs.masa_backend.data.common.DbHelper;
import com.devlogs.masa_backend.domain.entities.RequestEntity;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDao {
    private DbHelper dbHelper;

    @Inject
    public RequestDao(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<RequestDto> getAll () throws SQLException, ClassNotFoundException {
        ArrayList<RequestDto> result;
        try (Connection con = dbHelper.connect()) {
            Statement queryStatement = con.createStatement();
            ResultSet dbResults = queryStatement.executeQuery("select ID,DESCRIPTION, TYPE_ID, STATUS_ID, USER_ID from REQUESTS");
            result = new ArrayList();
            RequestDto cached;
            while (dbResults.next()) {
                int typeId = dbResults.getInt("TYPE_ID");
                int statusId = dbResults.getInt("STATUS_ID");
                String id= dbResults.getString("ID");
                String userId = dbResults.getString("USER_ID");
                String description = dbResults.getString("DESCRIPTION");
                cached = new RequestDto(id, description, userId, statusId, typeId);
                result.add(cached);
            }
        }
        return result;
    }

    public List<RequestDto> getByUserId (String userId) throws SQLException, ClassNotFoundException {
        ArrayList<RequestDto> result = new ArrayList();
        try (Connection con = dbHelper.connect()) {
            PreparedStatement queryStatement = con.prepareStatement("SELECT ID, DESCRIPTION, TYPE_ID, STATUS_ID FROM REQUESTS WHERE USER_ID = ?");
            queryStatement.setString(1, userId);
            ResultSet dbResults = queryStatement.executeQuery();
            RequestDto cached;
            while (dbResults.next()) {
                int typeId = dbResults.getInt("TYPE_ID");
                int statusId = dbResults.getInt("STATUS_ID");
                String id= dbResults.getString("ID");
                String description = dbResults.getString("DESCRIPTION");
                cached = new RequestDto(id, description, userId, statusId, typeId);
                result.add(cached);
            }
        }
        return result;
    }

    public List<RequestDto> getByUserEmail (String userEmail) throws SQLException, ClassNotFoundException {
        ArrayList<RequestDto> result = new ArrayList();
        try (Connection con = dbHelper.connect()) {
            PreparedStatement queryStatement = con.prepareStatement("SELECT ID, DESCRIPTION, TYPE_ID, STATUS_ID, USER_ID FROM REQUESTS WHERE USER_ID = (SELECT ID FROM USERS WHERE EMAIL = ?)");
            queryStatement.setString(1, userEmail);
            ResultSet dbResults = queryStatement.executeQuery();
            RequestDto cached;
            while (dbResults.next()) {
                int typeId = dbResults.getInt("TYPE_ID");
                int statusId = dbResults.getInt("STATUS_ID");
                String id= dbResults.getString("ID");
                String userId= dbResults.getString("USER_ID");
                String description = dbResults.getString("DESCRIPTION");
                cached = new RequestDto(id, description, userId, statusId, typeId);
                result.add(cached);
            }
        }
        return result;
    }

    public RequestDto addRequest (String id, String userId, String description, int typeId, int statusId) throws SQLException, ClassNotFoundException {
        int effectedRow = 0;
        try (Connection con = dbHelper.connect()) {
            PreparedStatement insertStatement = con.prepareStatement(
                    "INSERT INTO REQUESTS (ID, USER_ID, DESCRIPTION, TYPE_ID, STATUS_ID) VALUES (?,?,?,?,?)"
            );
            insertStatement.setString(1, id);
            insertStatement.setString(2, userId);
            insertStatement.setString(3, description);
            insertStatement.setInt(4, typeId);
            insertStatement.setInt(5, statusId);
            effectedRow = insertStatement.executeUpdate();

            if (effectedRow == 1) {
                return new RequestDto(id, description, userId, statusId, typeId);
            }
        }
        throw new RuntimeException("Unknown exception");
    }

    public RequestDto getById(String id) throws SQLException, ClassNotFoundException {
        RequestDto result = null;
        try (Connection con = dbHelper.connect()) {
            PreparedStatement queryStatement = con.prepareStatement("SELECT ID, USER_ID, DESCRIPTION, TYPE_ID, STATUS_ID FROM REQUESTS WHERE ID = ?");
            queryStatement.setString(1, id);
            ResultSet dbResults = queryStatement.executeQuery();
            if (dbResults.next()) {
                int typeId = dbResults.getInt("TYPE_ID");
                int statusId = dbResults.getInt("STATUS_ID");
                String userId = dbResults.getString("USER_ID");
                String description = dbResults.getString("DESCRIPTION");
                result = new RequestDto(id, description, userId, statusId, typeId);
            }
            return result;
        }
    }


    public void updateRequestStatus(String requestId, int statusId) throws SQLException, ClassNotFoundException {
        int effectedRow = 0;
        try (Connection con = dbHelper.connect()) {
            PreparedStatement queryStatement = con.prepareStatement("UPDATE REQUESTS SET STATUS_ID = ? WHERE ID = ?");
            queryStatement.setInt(1, statusId);
            queryStatement.setString(2, requestId);
            effectedRow = queryStatement.executeUpdate();
            if (effectedRow == 0) {
                throw new RuntimeException("An expected exception has occur while update the requests status");
            }
        }
    }
}
