package com.devlogs.masa_backend.data.remote_database;

import com.devlogs.masa_backend.data.common.DbHelper;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAO {
    private DbHelper dbHelper;

    @Inject
    public MeetingDAO(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<MeetingDTO> getAllMeetings() throws SQLException, ClassNotFoundException {
        Connection con = null;
        CallableStatement ctm = null;
        ResultSet rs = null;
        List<MeetingDTO> listMeeting = null;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareCall("EXEC getAllMeetings;");
                rs = ctm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String title = rs.getString(2);
                    long startTime = rs.getLong(3);
                    long endTime = rs.getLong(4);
                    String host_id = rs.getString(5);
                    int platform_id = rs.getInt(6);
                    int status_id = rs.getInt(7);
                    String description = rs.getString(8);
                    if (listMeeting == null) {
                        listMeeting = new ArrayList<>();
                    }
                    listMeeting.add(new MeetingDTO(id, title, platform_id, host_id, status_id, startTime, endTime, description));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ctm != null) {
                ctm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listMeeting;
    }

    public List<MeetingDTO> getMeetingsByHost(String hostId) throws SQLException, ClassNotFoundException {
        Connection con = null;
        CallableStatement ctm = null;
        ResultSet rs = null;
        List<MeetingDTO> listMeetingByHostID = null;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareCall("EXEC getMeetingsByHost ?;");
                ctm.setString(1, hostId);
                rs = ctm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String title = rs.getString(2);
                    long startTime = rs.getLong(3);
                    long endTime = rs.getLong(4);
                    String host_id = rs.getString(5);
                    int platform_id = rs.getInt(6);
                    int status_id = rs.getInt(7);
                    String description = rs.getString(8);
                    if (listMeetingByHostID == null) {
                        listMeetingByHostID = new ArrayList<>();
                    }
                    listMeetingByHostID.add(new MeetingDTO(id, title, platform_id, host_id, status_id, startTime, endTime, description));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ctm != null) {
                ctm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listMeetingByHostID;
    }

    public MeetingDTO createMeeting(String id, String title, int platform_id, String host_id,
                                    int status_id, long startTime, long endTime, String description)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        CallableStatement ctm = null;
        int rowEffect = 0;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareCall("INSERT INTO Meetings(id,title,time_start,time_end,mentor_id,platform_id,status_id,description) VALUES (?,?,?,?,?,?,?,?);");
                ctm.setString(1,id);
                ctm.setString(2,title);
                ctm.setLong(3, startTime);
                ctm.setLong(4,endTime);
                ctm.setString(5,host_id);
                ctm.setInt(6,platform_id);
                ctm.setInt(7,status_id);
                ctm.setString(8,description);
                rowEffect = ctm.executeUpdate();
                if (rowEffect > 0) {
                    return new MeetingDTO(id, title, platform_id, host_id, status_id, startTime, endTime, description);
                }
            }
        } finally {
            if (ctm != null) {
                ctm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public MeetingDTO updateMeeting(String meetingId, String title, int platform_id, long startTime, long endTime, String description)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ctm = null;
        int rowEffect = 0;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareStatement("UPDATE Meetings " +
                        "SET title=?, platform_id=?, time_start=?, time_end=?, description=? " +
                        "WHERE id=?;");
                ctm.setString(1, title);
                ctm.setInt(2, platform_id);
                ctm.setLong(3, startTime);
                ctm.setLong(4, endTime);
                ctm.setString(5, description);
                ctm.setString(6, meetingId);
                rowEffect = ctm.executeUpdate();
                if (rowEffect > 0) {
                    return getMeetingByID(meetingId);
                }
            }
        } finally {
            if (ctm != null) {
                ctm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public MeetingDTO getMeetingByID(String meetingId) throws SQLException, ClassNotFoundException {
        Connection con = null;
        CallableStatement ctm = null;
        ResultSet rs = null;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareCall("EXEC getMeetingByID ?;");
                ctm.setString(1, meetingId);
                rs = ctm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString(1);
                    String title = rs.getString(2);
                    long startTime = rs.getLong(3);
                    long endTime = rs.getLong(4);
                    String host_id = rs.getString(5);
                    int platform_id = rs.getInt(6);
                    int status_id = rs.getInt(7);
                    String description = rs.getString(8);
                    return new MeetingDTO(id, title, platform_id, host_id, status_id, startTime, endTime, description);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ctm != null) {
                ctm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
