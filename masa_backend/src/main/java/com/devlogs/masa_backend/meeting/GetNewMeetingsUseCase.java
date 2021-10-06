package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;

import javax.inject.Inject;
import java.util.List;

public class GetNewMeetingsUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<MeetingEntity> meetings;

            public Success(List<MeetingEntity> meetings) {
                this.meetings = meetings;
            }
        }

        public static class ConnectionError extends Result{

        }
    }

    private MeetingRepository meetingRepository;

    @Inject
    public GetNewMeetingsUseCase(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public Result executes () {
        try {
            List<MeetingEntity> meetings = meetingRepository.getNewMeetings();
            return new Result.Success(meetings);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
