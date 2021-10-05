package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;

import java.util.List;

public interface TopicRepository {
    TopicEntity getById(int topicID) throws ConnectionException;
    TopicEntity getByTitle(String title) throws ConnectionException;
    TopicEntity createTopic(String title) throws ConnectionException;
    List<TopicEntity> getAllTopic() throws ConnectionException;
}
