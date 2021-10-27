package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;

import javax.inject.Inject;

public class GetNumOfUserFollowedMeetingInWeekUseCase {
    public static class Result {
        public static class Success extends Result {
            public int numOfUserFollowed;

            public Success(int numOfUserFollowed) {
                this.numOfUserFollowed = numOfUserFollowed;
            }
        }

        public static class ConnectionError extends Result {

        }
    }

    private MeetingRepository meetingRepository;
    @Inject
    public GetNumOfUserFollowedMeetingInWeekUseCase(MeetingRepository meetingRepository ) {
        this.meetingRepository = meetingRepository;
    }

    public Result executes () {
        try {
            int result = meetingRepository.countNumOfUserFollowedMeetingInWeek();
            return new Result.Success(result);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
