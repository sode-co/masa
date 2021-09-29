package com.devlogs.masa_backend.data.remote_database;

import com.devlogs.masa_backend.data.common.DbHelper;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    private DbHelper dbHelper;

    @Inject
    public AppointmentDAO(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public AppointmentDTO createAppointment(String userId, String meetingId) throws SQLException, ClassNotFoundException {
        AppointmentDTO appointmentDTO = null;
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ptm = con.prepareStatement("INSERT INTO Appointments(meeting_id, user_id) VALUES (?,?);");
            ptm.setString(1, meetingId);
            ptm.setString(2, userId);
            int result = ptm.executeUpdate();
            if (result > 0) {
                appointmentDTO = new AppointmentDTO(userId, meetingId);
            }
        }
        return appointmentDTO;
    }

    public List<AppointmentDTO> getUserAppointments(String userId) throws SQLException, ClassNotFoundException {
        List<AppointmentDTO> result = null;
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ptm = con.prepareStatement("SELECT meeting_id FROM Appointments WHERE user_id =?;");
            ptm.setString(1, userId);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                String meetingId = rs.getString(1);
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new AppointmentDTO(userId, meetingId));
            }
        }
        return result;
    }

    public List<AppointmentDTO> getMeetingAppointments(String meetingId) throws SQLException, ClassNotFoundException {
        List<AppointmentDTO> result = null;
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ptm = con.prepareStatement("SELECT user_id FROM Appointments WHERE meeting_id =?;");
            ptm.setString(1, meetingId);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                String userId = rs.getString(1);
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(new AppointmentDTO(userId, meetingId));
            }
        }
        return result;
    }

    public AppointmentDTO getAppointment(String userId, String meetingId) throws SQLException, ClassNotFoundException {
        AppointmentDTO result = null;
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ptm = con.prepareStatement("SELECT meeting_id FROM Appointments WHERE user_id =? AND MEETING_ID = ?");
            ptm.setString(1, userId);
            ptm.setString(2, meetingId);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                result = new AppointmentDTO(userId, meetingId);
            }
        }
        return result;
    }

    public void deleteAppointment (String userId, String meetingId) throws SQLException, ClassNotFoundException {
        try (Connection connection = dbHelper.connect()) {
            PreparedStatement deleteStatement = connection.prepareStatement("DELETE APPOINTMENTS WHERE USER_ID = ? AND MEETING_ID = ?");
            deleteStatement.setString(1, userId);
            deleteStatement.setString(2, meetingId);

            int effectedRow = deleteStatement.executeUpdate();

            if (effectedRow != 1) {
                throw  new RuntimeException("SQL execution unexcepted exception happen the effected row is: " + effectedRow);
            }
        }
    }
}
