package com.devlogs.masa_backend.appointment;

import com.devlogs.masa_backend.domain.entities.AppointmentEntity;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.AppointmentRepository;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class UnFollowMeetingUseCase {
    public static class Result {
        public static class Success extends Result  {}
        public static class MeetingNotFound extends Result {}
        public static class UserNotFound extends Result {}
        public static class GeneralError extends Result {}
    }

    private UserRepository userRepository;
    private AppointmentRepository appointmentRepository;
    private MeetingRepository meetingRepository;

    @Inject
    public UnFollowMeetingUseCase(UserRepository userRepository, AppointmentRepository appointmentRepository, MeetingRepository meetingRepository) {
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
        this.meetingRepository = meetingRepository;
    }

    public Result executes (String userId, String meetingId) {
        try {
            UserEntity user = userRepository.getUserById(userId);
            if (user == null) {
                return new Result.UserNotFound();
            }

            MeetingEntity meeting = meetingRepository.getById(meetingId);
            if (meeting == null) {
                return new Result.MeetingNotFound();
            }

            AppointmentEntity appointment = appointmentRepository.getAppointment(userId, meetingId);

            if (appointment == null) {
                return new Result.Success();
            }

            appointmentRepository.removeAppointment(userId, meetingId);
            return new Result.Success();
        } catch (ConnectionException e) {
            return new Result.GeneralError();
        }


    }
}
