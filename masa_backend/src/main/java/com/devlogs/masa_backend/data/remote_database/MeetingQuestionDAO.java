package com.devlogs.masa_backend.data.remote_database;

import com.devlogs.masa_backend.data.common.DbHelper;

import javax.inject.Inject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingQuestionDAO {
    private DbHelper dbHelper;
    @Inject
    public MeetingQuestionDAO(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<MeetingQuestionDTO> getAllQuestionsByMeetingId(String meeting_id) throws SQLException, ClassNotFoundException {
        List<MeetingQuestionDTO> meetingQuestionDTOList = new ArrayList<>();
        try (Connection con = dbHelper.connect()) {
            CallableStatement ctm = con.prepareCall("SELECT ID, TITLE, USER_ID, MEETING_ID, CREATED_DATE FROM MEETINGQUESTIONS " +
                    "WHERE MEETING_ID =? ORDER BY CREATED_DATE DESC;");
            ctm.setString(1,meeting_id);
            ResultSet result = ctm.executeQuery();
            while (result.next()) {
                String id = result.getString(1);
                String title = result.getString(2);
                String userId = result.getString(3);
                String metingId = result.getString(4);
                long createdDate= result.getLong(5);
                meetingQuestionDTOList.add(new MeetingQuestionDTO(id,title,userId,metingId,createdDate));
            }
        }
        return meetingQuestionDTOList;
    }

    public MeetingQuestionDTO createQuestions(String id,String title,String user_id,String meeting_id,long created_date) throws SQLException, ClassNotFoundException {
        MeetingQuestionDTO meetingQuestionDTO = null;
        try (Connection con = dbHelper.connect()) {
            CallableStatement ctm = con.prepareCall("INSERT INTO MEETINGQUESTIONS(ID, TITLE, USER_ID, MEETING_ID, CREATED_DATE) " +
                    "VALUES(?,?,?,?,?);");
            ctm.setString(1,id);
            ctm.setString(2,title);
            ctm.setString(3,user_id);
            ctm.setString(4,meeting_id);
            ctm.setLong(5,created_date);
            int result = ctm.executeUpdate();
            if (result>0) {
                meetingQuestionDTO = new MeetingQuestionDTO(id,title,user_id,meeting_id,created_date);
            }
        }
        return meetingQuestionDTO;
    }
}
