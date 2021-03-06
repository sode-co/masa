package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.*;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.TopicRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class CreateMeetingUseCase {

    public static class Result {
        public static class Success extends Result {
            public MeetingEntity createdMeeting;
            public UserEntity host;

            public Success(MeetingEntity createdMeeting, UserEntity host) {
                this.createdMeeting = createdMeeting;
                this.host = host;
            }
        }

        public static class HostDoesNotExist extends Result {

        }

        public static class NotMentorError extends Result {

        }

        public static class ConnectionError extends Result {

        }
    }

    private MeetingRepository meetingRepository;
    private UserRepository userRepository;
    private TopicRepository topicRepository;
    @Inject
    public CreateMeetingUseCase(MeetingRepository meetingRepository, UserRepository userRepository, TopicRepository topicRepository) {
        this.meetingRepository = meetingRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
    }

    public Result executes (String title, MeetingPlatform.PLATFORM platform, String hostId, String topicTitle,long startTime, long endTime, String description) {
        try {
            UserEntity host = userRepository.getUserById(hostId);
            if (host == null) {
                return new Result.HostDoesNotExist();
            }
            if (host.getRole().getType() != UserRole.TYPE.MENTOR) {
               return new Result.NotMentorError();
            }
            TopicEntity topic = topicRepository.getByTitle(topicTitle);
            if(topic == null){
                topic = topicRepository.createTopic(topicTitle);
            }
            MeetingEntity createdMeeting = meetingRepository.create(title , platform,hostId , topic,startTime, endTime, description);
            return new Result.Success(createdMeeting, host);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }

}
