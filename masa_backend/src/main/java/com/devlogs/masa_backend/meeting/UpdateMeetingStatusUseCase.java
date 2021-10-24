package com.devlogs.masa_backend.meeting;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.AppointmentRepository;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class UpdateMeetingStatusUseCase {
    public static class Result {
        public static class Success extends Result {
            public MeetingEntity updatedMeeting;

            public Success(MeetingEntity updatedMeeting) {
                this.updatedMeeting = updatedMeeting;
            }
        }

        public static class ConnectionError extends Result {

        }

        public static class MeetingDoesNotExist extends Result {

        }
    }

    private MeetingRepository meetingRepository;
    private AppointmentRepository appointmentRepository;

    @Inject
    public UpdateMeetingStatusUseCase(MeetingRepository meetingRepository, AppointmentRepository appointmentRepository) {
        this.meetingRepository = meetingRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public Result executes (String meetingId) {
        try {
            MeetingEntity currentMeeting = meetingRepository.getById(meetingId);
            if (currentMeeting == null) {
                return new Result.MeetingDoesNotExist();
            }
            appointmentRepository.removeAllAppointmentsByMeetingId(meetingId);
            MeetingEntity updatedMeeting = meetingRepository.updateMeetingStatus(meetingId);
            return new Result.Success(updatedMeeting);

        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        } catch (NotFoundException e) {
            return new Result.MeetingDoesNotExist();
        }
    }
}
