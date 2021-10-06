package com.devlogs.masa_backend.topics;

import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.TopicRepository;
import com.devlogs.masa_backend.topics.GetAllTopicsUseCase;
import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

public class GetAllTopicsUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<TopicEntity> topics;

            public Success(List<TopicEntity> topics) {
                this.topics = topics;
            }
        }

        public static class GeneralError extends Result {

        }
    }

    private final TopicRepository topicRepository;

    @Inject
    public GetAllTopicsUseCase(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Result executes () {
        try {
            List<TopicEntity> topics = topicRepository.getAllTopic();
            return new Result.Success(topics);
        } catch (ConnectionException e) {
            return new Result.GeneralError();
        }
    }
}
