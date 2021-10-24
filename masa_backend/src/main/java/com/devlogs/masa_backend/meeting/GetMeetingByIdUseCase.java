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
        public static class NotFound extends Result {

        }
    }

    private MeetingRepository meetingRepository;
    @Inject
    public GetMeetingByIdUseCase(MeetingRepository meetingRepository ) {
        this.meetingRepository = meetingRepository;
    }

    public Result executes (String meetingId) {
        try {
            MeetingEntity meeting = meetingRepository.getById(meetingId);
            if (meeting == null) {
                return new Result.NotFound();
            }
            return new Result.Success(meeting);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
