package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class UpdateMeetingUseCaseSync {

    public static class Result {
        public static class Success extends Result {
            public MeetingEntity updatedMeeting;
            public UserEntity host;

            public Success(MeetingEntity updatedMeeting, UserEntity host) {
                this.updatedMeeting = updatedMeeting;
                this.host = host;
            }
        }

        public static class ConnectionError extends Result {

        }

        public static class MeetingDoesNotExist extends Result {

        }
    }

    private MeetingRepository meetingRepository;
    private UserRepository userRepository;

    @Inject
    public UpdateMeetingUseCaseSync(MeetingRepository meetingRepository, UserRepository userRepository) {
        this.meetingRepository = meetingRepository;
        this.userRepository = userRepository;
    }

    public Result executes (String meetingId, String title, MeetingPlatform.PLATFORM platform, long startTime, long endTime, String description) {
        try {
            MeetingEntity currentMeeting = meetingRepository.getById(meetingId);
            if (currentMeeting == null) {
                return new Result.MeetingDoesNotExist();
            }
            MeetingEntity updatedMeeting = meetingRepository.updateMeeting(meetingId,title, platform, startTime, endTime, description);
            return new Result.Success(updatedMeeting, userRepository.getUserById(updatedMeeting.getHostId()));
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        } catch (NotFoundException e) {
            return new Result.MeetingDoesNotExist();
        }
    }
}
