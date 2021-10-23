package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.TopicRepository;
import com.devlogs.masa_backend.meeting.GetMeetingsByTopicUseCase.Result.TopicDoesNotExist;

import javax.inject.Inject;
import java.util.List;

public class GetMeetingsByTopicUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<MeetingEntity> meetings;

            public Success(List<MeetingEntity> meetings) {
                this.meetings = meetings;
            }
        }

        public static class ConnectionError extends Result{

        }

        public static class TopicDoesNotExist extends Result {

        }
    }

    private MeetingRepository meetingRepository;
    private TopicRepository topicRepository;
    @Inject
    public GetMeetingsByTopicUseCase(MeetingRepository meetingRepository, TopicRepository topicRepository) {
        this.meetingRepository = meetingRepository;
        this.topicRepository = topicRepository;
    }

    public Result executes (int topicId) {
        try {

            TopicEntity topic = topicRepository.getById(topicId);
            if (topic == null) {
                return new TopicDoesNotExist();
            }
            List<MeetingEntity> meetings = meetingRepository.getMeetingsByTopic(topicId);
            return new Result.Success(meetings);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
