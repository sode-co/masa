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
        List<MeetingDTO> listMeeting = new ArrayList<>();
        try (Connection con = dbHelper.connect()) {
            CallableStatement ctm = con.prepareCall("SELECT ID, TITLE, TIME_START, TIME_END, MENTOR_ID, PLATFORM_ID, STATUS_ID, TOPIC_ID, DESCRIPTION " +
                    "FROM MEETINGS;");
            ResultSet result = ctm.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String title = result.getString(2);
                long startTime = result.getLong(3);
                long endTime = result.getLong(4);
                String host_id = result.getString(5);
                int platform_id = result.getInt(6);
                int status_id = result.getInt(7);
                int topic_id = result.getInt(8);
                String description = result.getString(9);
                listMeeting.add(new MeetingDTO(id,title,platform_id,host_id,status_id,topic_id,startTime,endTime,description));
            }
        }
        return listMeeting;
    }

    public List<MeetingDTO> getMeetingsByHost(String hostId) throws SQLException, ClassNotFoundException {
        List<MeetingDTO> listMeetingByHostID = new ArrayList<>();
        try (Connection con = dbHelper.connect()) {
            CallableStatement ctm = con.prepareCall("SELECT ID, TITLE, TIME_START, TIME_END, MENTOR_ID, PLATFORM_ID, STATUS_ID, TOPIC_ID, DESCRIPTION " +
                    "FROM MEETINGS WHERE MENTOR_ID=?;");
            ctm.setString(1, hostId);
            ResultSet result = ctm.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String title = result.getString(2);
                long startTime = result.getLong(3);
                long endTime = result.getLong(4);
                String host_id = result.getString(5);
                int platform_id = result.getInt(6);
                int status_id = result.getInt(7);
                int topic_id = result.getInt(8);
                String description = result.getString(9);
                listMeetingByHostID.add(new MeetingDTO(id,title,platform_id,host_id,status_id,topic_id,startTime,endTime,description));
            }
        }
        return listMeetingByHostID;
    }

    public MeetingDTO createMeeting(String id, String title, int platform_id, String host_id,
                                    int status_id, int topic_id,long startTime, long endTime, String description)
            throws SQLException, ClassNotFoundException {
        int rowEffect = 0;
        try (Connection con = dbHelper.connect()) {
            CallableStatement ctm = con.prepareCall("INSERT INTO Meetings(ID, TITLE, TIME_START, TIME_END, MENTOR_ID, PLATFORM_ID, STATUS_ID, TOPIC_ID, DESCRIPTION) " +
                    "VALUES (?,?,?,?,?,?,?,?,?);");
            ctm.setString(1, id);
            ctm.setString(2, title);
            ctm.setLong(3, startTime);
            ctm.setLong(4, endTime);
            ctm.setString(5, host_id);
            ctm.setInt(6, platform_id);
            ctm.setInt(7, status_id);
            ctm.setInt(8, topic_id);
            ctm.setString(9, description);
            rowEffect = ctm.executeUpdate();
            if (rowEffect > 0) {
                return new MeetingDTO(id, title, platform_id, host_id, status_id, topic_id, startTime, endTime, description);
            }
        }
        return null;
    }

    public MeetingDTO updateMeeting(String meetingId, String title, int platform_id, long startTime, long endTime, String description)
            throws SQLException, ClassNotFoundException {
        int rowEffect = 0;
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ctm = con.prepareStatement("UPDATE Meetings " +
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
        return null;
    }

    public MeetingDTO getMeetingByID(String meetingId) throws SQLException, ClassNotFoundException {
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ctm = con.prepareStatement("SELECT ID, TITLE, TIME_START, TIME_END, MENTOR_ID, PLATFORM_ID, STATUS_ID, TOPIC_ID,DESCRIPTION " +
                    "FROM Meetings WHERE id=? ;");
            ctm.setString(1, meetingId);
            ResultSet result = ctm.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String title = result.getString(2);
                long startTime = result.getLong(3);
                long endTime = result.getLong(4);
                String host_id = result.getString(5);
                int platform_id = result.getInt(6);
                int status_id = result.getInt(7);
                int topic_id = result.getInt(8);
                String description = result.getString(9);
                return new MeetingDTO(id, title, platform_id, host_id, status_id, topic_id,startTime, endTime, description);
            }
        }
        return null;
    }

    public List<MeetingDTO> getUserFollowedMeetings (String userId) throws SQLException, ClassNotFoundException {
        ArrayList<MeetingDTO> followedMeetings = new ArrayList<>();
        try (Connection connection = dbHelper.connect()) {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT ID, TITLE, TIME_START, TIME_END, MENTOR_ID, PLATFORM_ID, STATUS_ID, TOPIC_ID,DESCRIPTION " +
                                                                                "FROM MEETINGS " +
                                                                                "WHERE ID IN (SELECT MEETING_ID FROM APPOINTMENTS WHERE USER_ID = ?)");
            queryStatement.setString(1, userId);
            ResultSet result = queryStatement.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String title = result.getString(2);
                long startTime = result.getLong(3);
                long endTime = result.getLong(4);
                String host_id = result.getString(5);
                int platform_id = result.getInt(6);
                int status_id = result.getInt(7);
                int topic_id = result.getInt(8);
                String description = result.getString(9);
                followedMeetings.add(new MeetingDTO(id, title, platform_id, host_id, status_id, topic_id,startTime, endTime, description));
            }
        }
        return followedMeetings;
    }

    public List<MeetingDTO> getUserNotFollowedMeetings (String userId) throws SQLException, ClassNotFoundException {
        ArrayList<MeetingDTO> notFollowedMeetings = new ArrayList<>();
        try (Connection connection = dbHelper.connect()) {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT ID, TITLE, TIME_START, TIME_END, MENTOR_ID, PLATFORM_ID, STATUS_ID, TOPIC_ID,DESCRIPTION " +
                    "FROM MEETINGS " +
                    "WHERE ID NOT IN (SELECT MEETING_ID FROM APPOINTMENTS WHERE USER_ID = ?)");
            queryStatement.setString(1, userId);
            ResultSet result = queryStatement.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String title = result.getString(2);
                long startTime = result.getLong(3);
                long endTime = result.getLong(4);
                String host_id = result.getString(5);
                int platform_id = result.getInt(6);
                int status_id = result.getInt(7);
                int topic_id = result.getInt(8);
                String description = result.getString(9);
                notFollowedMeetings.add(new MeetingDTO(id, title, platform_id, host_id, status_id, topic_id,startTime, endTime, description));
            }
        }
        return notFollowedMeetings;
    }
}
