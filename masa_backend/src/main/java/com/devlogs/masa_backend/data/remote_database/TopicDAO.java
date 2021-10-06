package com.devlogs.masa_backend.data.remote_database;

import com.devlogs.masa_backend.data.common.DbHelper;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDAO {
    private DbHelper dbHelper;

    @Inject
    public TopicDAO(DbHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public TopicDTO getTopicByID(int topic_id) throws SQLException, ClassNotFoundException {
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ctm = con.prepareStatement("SELECT ID, TITLE " +
                    "FROM Topics WHERE id=? ;");
            ctm.setInt(1, topic_id);
            ResultSet result = ctm.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                return new TopicDTO(id,title);
            }
        }
        return null;
    }

    public TopicDTO getTopicByTitle(String title) throws SQLException, ClassNotFoundException {
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ctm = con.prepareStatement("SELECT ID, TITLE " +
                    "FROM Topics WHERE title=? ;");
            ctm.setString(1, title);
            ResultSet result = ctm.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String topic_title = result.getString(2);
                return new TopicDTO(id,topic_title);
            }
        }
        return null;
    }

    public TopicDTO createTopic(String title) throws SQLException, ClassNotFoundException {
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ctm = con.prepareStatement("INSERT INTO Topics VALUES(?);");
            ctm.setString(1, title);
            int result = ctm.executeUpdate();
            if(result > 0) {
                return getTopicByTitle(title);
            }
        }
        return null;
    }

    public List<TopicDTO> getAllTopics() throws SQLException, ClassNotFoundException {
        List<TopicDTO> list = new ArrayList<>();
        try (Connection con = dbHelper.connect()) {
            PreparedStatement ctm = con.prepareStatement("SELECT ID, TITLE " +
                    "FROM Topics");
            ResultSet result = ctm.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String topic_title = result.getString(2);
                list.add(new TopicDTO(id,topic_title));
            }
        }
        return list;
    }
}
