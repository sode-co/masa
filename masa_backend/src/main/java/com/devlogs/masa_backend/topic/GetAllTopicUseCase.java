package com.devlogs.masa_backend.topic;

import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.TopicRepository;

import javax.inject.Inject;
import java.util.List;

public class GetAllTopicUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<TopicEntity> topics;

            public Success(List<TopicEntity> topics) {
                this.topics = topics;
            }
        }
        public static class ConnectionError extends Result {

        }
    }

    private TopicRepository topicRepository;
    @Inject
    public GetAllTopicUseCase(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Result executes () {
        try {
            List<TopicEntity> topics = topicRepository.getAllTopic();
            return new Result.Success(topics);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
