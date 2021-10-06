package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.TopicEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.TopicRepository;
import com.devlogs.masa_backend.meeting.GetMeetingsByMultipleTopicsUseCase.Result.TopicDoesNotExist;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GetMeetingsByMultipleTopicsUseCase {
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
            public int topicId;

            public TopicDoesNotExist(int topicId) {
                this.topicId = topicId;
            }
        }
    }

    private MeetingRepository meetingRepository;
    private TopicRepository topicRepository;

    @Inject
    public GetMeetingsByMultipleTopicsUseCase(MeetingRepository meetingRepository, TopicRepository topicRepository) {
        this.meetingRepository = meetingRepository;
        this.topicRepository = topicRepository;
    }

    public Result executes (int[] topicIds) {
        try {
            HashSet<MeetingEntity> meetings = new HashSet<>();
            for (int id : topicIds) {
                TopicEntity topic = topicRepository.getById(id);
                if (topic == null) {
                    return new TopicDoesNotExist(id);
                }
                meetings.addAll(meetingRepository.getMeetingsByTopic(id));
            }
            return new Result.Success(new ArrayList<MeetingEntity>(meetings));
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
