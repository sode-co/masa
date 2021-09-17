package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.HostDoesNotExistException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;

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

        public static class ConnectionError extends Result {

        }
    }

    private MeetingRepository meetingRepository;

    @Inject
    public CreateMeetingUseCase(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public Result executes (String title, MeetingPlatform platform, String hostId, long startTime, long endTime, String description) {
        try {
            MeetingEntity createdMeeting = meetingRepository.create(title, platform, hostId, startTime, endTime, description);
            return new Result.Success(createdMeeting);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        } catch (HostDoesNotExistException e) {
            return new Result.HostDoesNotExist();

        }
    }

}
