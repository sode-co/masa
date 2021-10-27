package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;

import javax.inject.Inject;

public class GetNumOfCreatedMeetingInWeekUseCase {
    public static class Result {
        public static class Success extends Result {
            public int numOfMeetings;

            public Success(int numOfMeetings) {
                this.numOfMeetings = numOfMeetings;
            }
        }

        public static class ConnectionError extends Result {

        }
    }
    private MeetingRepository meetingRepository;

    @Inject
    public GetNumOfCreatedMeetingInWeekUseCase(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public Result executes () {
        try {
            int numOfMeetings = meetingRepository.countAllCreatedMeetingsInWeek();
            return new Result.Success(numOfMeetings);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
