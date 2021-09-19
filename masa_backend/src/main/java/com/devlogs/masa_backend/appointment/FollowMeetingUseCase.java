package com.devlogs.masa_backend.appointment;

import com.devlogs.masa_backend.domain.entities.AppointmentEntity;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.AppointmentRepository;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import javax.inject.Inject;

public class FollowMeetingUseCase {
    public static class Result {
        public static class Success extends Result {
            public AppointmentEntity appointment;

            public Success(AppointmentEntity appointment) {
                this.appointment = appointment;
            }
        }

        public static class UserNotFound extends Result {

        }

        public static class MeetingNotFound extends Result {

        }

        public static class ConnectionError extends Result {

        }
    }

        private UserRepository userRepository;
        private MeetingRepository meetingRepository;
        private AppointmentRepository appointmentRepository;

        @Inject
        public FollowMeetingUseCase(UserRepository userRepository, MeetingRepository meetingRepository, AppointmentRepository appointmentRepository) {
            this.userRepository = userRepository;
            this.meetingRepository = meetingRepository;
            this.appointmentRepository = appointmentRepository;
        }


        public Result executes (String userId, String meetingId) {
            try {
//                UserEntity user = userRepository.getUserById(userId);
//                if (user == null) {
//                    return new Result.UserNotFound();
//                }
                MeetingEntity meeting = meetingRepository.getById(meetingId);
                if (meeting == null) {
                    return new Result.MeetingNotFound();
                }
                AppointmentEntity appointment = appointmentRepository.createAppointment(userId, meetingId);
                return new Result.Success(appointment);
            } catch (ConnectionException e) {
                return new Result.ConnectionError();
            }
    }
}
