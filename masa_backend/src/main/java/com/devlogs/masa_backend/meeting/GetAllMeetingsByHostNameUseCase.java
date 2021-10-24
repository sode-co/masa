package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;
import java.util.List;

public class GetAllMeetingsByHostNameUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<MeetingEntity> meetings;

            public Success(List<MeetingEntity> meetings) {
                this.meetings = meetings;
            }
        }

        public static class ConnectionError extends Result {

        }
        public static class UserDoesNotExist extends Result {

        }
    }

    private MeetingRepository meetingRepository;
    private UserRepository userRepository;
    @Inject
    public GetAllMeetingsByHostNameUseCase(MeetingRepository meetingRepository, UserRepository userRepository) {
        this.meetingRepository = meetingRepository;
        this.userRepository = userRepository;
    }

    public Result executes (String hostName) {
        try {
            List<UserEntity> listUserEntity = userRepository.getUserByName(hostName);
            if (listUserEntity.size() == 0) {
                return new Result.UserDoesNotExist();
            }
            List<MeetingEntity> meetings = meetingRepository.getMeetingsByHostName(hostName);
            return new Result.Success(meetings);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
