package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.TopicRepository;
import com.devlogs.masa_backend.meeting.GetMeetingsByMultipleTopicsNameUseCase.Result.TopicDoesNotExist;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GetMeetingsByMultipleTopicsNameUseCase {
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
            public String name;

            public TopicDoesNotExist(String name) {
                this.name = name;
            }
        }
    }

    private MeetingRepository meetingRepository;
    private TopicRepository topicRepository;

    @Inject
    public GetMeetingsByMultipleTopicsNameUseCase(MeetingRepository meetingRepository, TopicRepository topicRepository) {
        this.meetingRepository = meetingRepository;
        this.topicRepository = topicRepository;
    }

    public Result executes (String[] topicNames) {
        try {
            HashSet<MeetingEntity> meetings = new HashSet<>();
            for (String name : topicNames) {
                TopicEntity topic = topicRepository.getByTitle(name);
                if (topic == null) {
                    return new TopicDoesNotExist(name);
                }
                meetings.addAll(meetingRepository.getMeetingsByTopic(topic.getId()));
            }
            return new Result.Success(new ArrayList<MeetingEntity>(meetings));
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
