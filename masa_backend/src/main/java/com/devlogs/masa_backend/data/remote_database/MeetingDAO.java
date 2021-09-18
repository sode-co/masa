package com.devlogs.masa_backend.data.remote_database;

import com.devlogs.masa_backend.data.common.DbHelper;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAO {
    private DbHelper dbHelper;
    private List<MeetingDTO> listMeeting;
    private List<MeetingDTO> listMeetingByHostID;

    @Inject
    public MeetingDAO(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<MeetingDTO> getListMeeting() {
        return listMeeting;
    }

    public List<MeetingDTO> getListMeetingByHostID() {
        return listMeetingByHostID;
    }

    public void getAllMeetings() throws SQLException, ClassNotFoundException {
        Connection con = null;
        CallableStatement ctm = null;
        ResultSet rs = null;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareCall("EXEC getAllMeetings;");
                rs = ctm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString('1');
                    String title = rs.getString("2");
                    long startTime = rs.getLong("3");
                    long endTime = rs.getLong("4");
                    String host_id = rs.getString("5");
                    String platform_id = rs.getString("6");
                    String status_id = rs.getString("7");
                    String description = rs.getString("8");
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

    }

    public void getMeetingsByHost(String hostId) throws SQLException, ClassNotFoundException {
        Connection con = null;
        CallableStatement ctm = null;
        ResultSet rs = null;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareCall("EXEC getMeetingsByHost(?);");
                ctm.setString(1,hostId);
                rs = ctm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString('1');
                    String title = rs.getString("2");
                    long startTime = rs.getLong("3");
                    long endTime = rs.getLong("4");
                    String host_id = rs.getString("5");
                    String platform_id = rs.getString("6");
                    String status_id = rs.getString("7");
                    String description = rs.getString("8");
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

    }

    public MeetingDTO createMeeting(String id, String title, String platform_id, String host_id,
                                    String status_id, long startTime, long endTime, String description)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        CallableStatement ctm = null;
        int rowEffect = 0;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareCall("INSERT INTO Meeting(id,title,time_start,time_end,platform_id,mentor_id,status_id,description) VALUES (?,?,?,?,?,?,?,?)");
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

    public MeetingDTO updateMeeting(String meetingId, String title, String platform_id, long startTime, long endTime, String description)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        CallableStatement ctm = null;
        int rowEffect = 0;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareCall("UPDATE Meeting " +
                        "SET title=?, platform_id=?, time_start=?, time_end=?, description=? " +
                        "WHERE id=?;");
                ctm.setString(1,title);
                ctm.setString(2,platform_id);
                ctm.setLong(3,startTime);
                ctm.setLong(4,endTime);
                ctm.setString(5,description);
                ctm.setString(6,meetingId);
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

    public MeetingDTO getMeetingByID(String meetingId)throws SQLException, ClassNotFoundException {
        Connection con = null;
        CallableStatement ctm = null;
        ResultSet rs = null;
        try {
            con = dbHelper.connect();
            if (con != null) {
                ctm = con.prepareCall("EXEC getMeetingByID(?);");
                ctm.setString(1,meetingId);
                rs = ctm.executeQuery();
                while (rs.next()){
                    String id = rs.getString('1');
                    String title = rs.getString("2");
                    long startTime = rs.getLong("3");
                    long endTime = rs.getLong("4");
                    String host_id = rs.getString("5");
                    String platform_id = rs.getString("6");
                    String status_id = rs.getString("7");
                    String description = rs.getString("8");
                    return new MeetingDTO(id,title,platform_id,host_id,status_id,startTime,endTime,description);
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
