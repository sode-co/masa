package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;

import javax.inject.Inject;

public class UpdateMeetingUseCaseSync {

    public static class Result {
        public static class Success extends Result {
            public MeetingEntity createdMeeting;

            public Success(MeetingEntity createdMeeting) {
                this.createdMeeting = createdMeeting;
            }
        }

        public static class ConnectionError extends Result {

        }

        public static class MeetingDoesNotExist extends Result {

        }
    }

    private MeetingRepository meetingRepository;

    @Inject
    public UpdateMeetingUseCaseSync(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public Result executes (String meetingId, String title, MeetingPlatform platform, long startTime, long endTime, String description) {
        try {
            MeetingEntity createdMeeting = meetingRepository.updateMeeting(title, platform, startTime, endTime, description);
            return new Result.Success(createdMeeting);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        } catch (NotFoundException e) {
            return new Result.MeetingDoesNotExist();
        }
    }
}
