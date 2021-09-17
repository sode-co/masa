package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.MeetingPlatformRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class CreateMeetingUseCase {

    public static class Result {
        public static class Success extends Result {
            public MeetingEntity createdMeeting;

            public Success(MeetingEntity createdMeeting) {
                this.createdMeeting = createdMeeting;
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
    private MeetingPlatformRepository meetingPlatformRepository;
    private UserRepository userRepository;

    @Inject
    public CreateMeetingUseCase(MeetingRepository meetingRepository,MeetingPlatformRepository meetingPlatformRepository,UserRepository userRepository) {
        this.meetingRepository = meetingRepository;
        this.userRepository = userRepository;
        this.meetingPlatformRepository = meetingPlatformRepository;
    }

    public Result executes (String title, MeetingPlatform.PLATFORM platform, String hostId, long startTime, long endTime, String description) {
        try {
            UserEntity host = userRepository.getUserById(hostId);
            if (host == null) {
                return new Result.HostDoesNotExist();
            }
            if (host.getRole().getType() != UserRole.TYPE.MENTOR) {
               return new Result.NotMentorError();
            }
            MeetingEntity createdMeeting = meetingRepository.create(title , platform,hostId , startTime, endTime, description);
            return new Result.Success(createdMeeting);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }

}
