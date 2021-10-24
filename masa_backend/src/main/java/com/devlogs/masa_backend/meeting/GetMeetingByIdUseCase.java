package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;
import java.util.List;

public class GetMeetingByIdUseCase {
    public static class Result {
        public static class Success extends Result {
            public MeetingEntity meeting;

            public Success(MeetingEntity meeting) {
                this.meeting = meeting;
            }
        }

        public static class ConnectionError extends Result {

        }
    }

    private MeetingRepository meetingRepository;
    @Inject
    public GetMeetingByIdUseCase(MeetingRepository meetingRepository ) {
        this.meetingRepository = meetingRepository;
    }

    public Result executes (String meetingId) {
        try {
            MeetingEntity meetings = meetingRepository.getById(meetingId);
            return new Result.Success(meetings);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
