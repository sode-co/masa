package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;
import java.util.List;

public class GetAllUserNotFollowedMeetingUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<MeetingEntity> meetings;

            public Success(List<MeetingEntity> meetings) {
                this.meetings = meetings;
            }
        }
        public static class UserNotFoundError extends Result {

        }
        public static class ConnectionError extends Result {

        }
    }

    private MeetingRepository meetingRepository;
    private UserRepository userRepository;

    @Inject
    public GetAllUserNotFollowedMeetingUseCase(MeetingRepository meetingRepository, UserRepository userRepository) {
        this.meetingRepository = meetingRepository;
        this.userRepository = userRepository;
    }

    public Result executes (String userId) {
        try {
            UserEntity user = userRepository.getUserById(userId);
            if (user == null) {
                return new Result.UserNotFoundError();
            }
            List<MeetingEntity> meetings = meetingRepository.getNotFollowedMeetings(userId);
            return new Result.Success(meetings);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
