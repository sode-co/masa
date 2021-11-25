package com.devlogs.masa_backend.appointment;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.AppointmentEntity;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.TimeOutException;
import com.devlogs.masa_backend.domain.ports.AppointmentRepository;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.domain.ports.sendmail.Email;
import com.devlogs.masa_backend.domain.ports.sendmail.RemindAppointmentEmail;
import com.devlogs.masa_backend.domain.ports.sendmail.SendMailGateway;

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

        public static class AppointmentAlreadyExist extends Result {
            public AppointmentEntity appointment;

            public AppointmentAlreadyExist(AppointmentEntity appointment) {
                this.appointment = appointment;
            }
        }
    }

        private UserRepository userRepository;
        private MeetingRepository meetingRepository;
        private AppointmentRepository appointmentRepository;
        private RemindMeetingTime remindMeetingTime;
        private SendMailGateway sendMailGateway;

        @Inject
        public FollowMeetingUseCase(UserRepository userRepository, MeetingRepository meetingRepository, AppointmentRepository appointmentRepository, RemindMeetingTime remindMeetingTime, SendMailGateway sendMailGateway) {
            this.userRepository = userRepository;
            this.meetingRepository = meetingRepository;
            this.appointmentRepository = appointmentRepository;
            this.remindMeetingTime = remindMeetingTime;
            this.sendMailGateway = sendMailGateway;
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
                // get host
                UserEntity host = userRepository.getUserById(meeting.getHostId());

                // check if user already join meeting
                AppointmentEntity appointment = appointmentRepository.getAppointment(userId, meetingId);
                if (appointment != null) {
                    return new Result.AppointmentAlreadyExist (appointment);
                }

                appointment = appointmentRepository.createAppointment(userId, meetingId);

                // send remind email to user
                Long remindTime = remindMeetingTime.getRemindTime(meeting.getStartTime());
                // create email
                Email email = new RemindAppointmentEmail(meeting.getPlatform().getUrl(), meeting.getTitle(), meeting.getStartTime(), meeting.getDescription(), host.getFullName());

                new Thread(() -> {
                    // we don't mind the reponse is success or not => speed up
                    try {
                        sendMailGateway.sendEmailWithScheduler(email, user.getEmail(), remindTime);
                        MasaLog.normalLog("Remind email has been sent to:" + email);
                    } catch (ConnectionException e) {
                        MasaLog.normalLog("Can not send remind email to " + email + " due to: " + e.getMessage());
                    } catch (TimeOutException e) {
                        MasaLog.normalLog("Can not send remind email to " + email + " due to: " + e.getMessage());
                    }
                }).start();
                MasaLog.normalLog("set the remind time: " + remindTime);
                return new Result.Success(appointment);
            } catch (ConnectionException e) {
                return new Result.ConnectionError();
            }
    }
}
