package com.devlogs.masa_backend.repository.topic;

import com.devlogs.masa_backend.data.remote_database.TopicDAO;
import com.devlogs.masa_backend.data.remote_database.TopicDTO;
import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.TopicRepository;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicRepositoryImp implements TopicRepository {
    private TopicDAO topicDAO;

    @Inject
    public TopicRepositoryImp(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    @Override
    public TopicEntity getById(int topicID) throws ConnectionException {
        TopicEntity topic = null;
        try {
            TopicDTO dto = topicDAO.getTopicByID(topicID);
            if (dto != null){
                topic = new TopicEntity(dto.getId(), dto.getTitle());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return topic;
    }

    @Override
    public TopicEntity getByTitle(String title) throws ConnectionException {
        TopicEntity topic = null;
        try {
            TopicDTO dto = topicDAO.getTopicByTitle(title);
            if (dto != null){
                topic = new TopicEntity(dto.getId(), dto.getTitle());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return topic;
    }

    @Override
    public TopicEntity createTopic(String title) throws ConnectionException {
        TopicEntity topic = null;
        try {
            TopicDTO dto = topicDAO.createTopic(title);
            if (dto != null){
                topic = new TopicEntity(dto.getId(), dto.getTitle());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return topic;
    }

    @Override
    public List<TopicEntity> getAllTopic() throws ConnectionException {
        List<TopicEntity> results = new ArrayList<>();
        try {
            List<TopicDTO> list = topicDAO.getAllTopics();
            if (list != null){
                for (TopicDTO dto : list){
                    results.add(new TopicEntity(dto.getId(), dto.getTitle()));
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return results;
    }
}
