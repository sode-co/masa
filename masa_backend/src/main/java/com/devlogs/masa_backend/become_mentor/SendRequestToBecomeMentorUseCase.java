package com.devlogs.masa_backend.become_mentor;

import com.devlogs.masa_backend.become_mentor.SendRequestToBecomeMentorUseCase.Result.*;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.TimeOutException;
import com.devlogs.masa_backend.domain.ports.BecomeMentorRequestRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.domain.ports.sendmail.BecomeMentorEmail;
import com.devlogs.masa_backend.domain.ports.sendmail.SendMailGateway;
import com.devlogs.masa_backend.platform.PlatformChecker;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class SendRequestToBecomeMentorUseCase {
    public static class Result {
        public static class Success extends Result {

        }

        public static class UserNotFound extends Result {}

        public static class UserAlreadyAMentor extends Result {}

        public static class InvalidPlatform extends Result {

        }

        public static class OnlyGuestCanBecomeMentor extends Result {

        }

        public static class SendMailFailedButRequestSaved extends Result {}

        public static class GeneralError extends Result {
            public String message;

            public GeneralError(String message) {
                this.message = message;
            }
        }
    }

    private UserRepository userRepository;
    private PlatformChecker platformChecker;
    private SendMailGateway sendMailGateway;
    private BecomeMentorRequestRepository requestRepository;

    @Inject
    public SendRequestToBecomeMentorUseCase(UserRepository userRepository, PlatformChecker platformChecker, SendMailGateway sendMailGateway, BecomeMentorRequestRepository requestRepository) {
        this.userRepository = userRepository;
        this.platformChecker = platformChecker;
        this.sendMailGateway = sendMailGateway;
        this.requestRepository = requestRepository;
    }

    ArrayList<Exception> ex = new ArrayList<>();

    private void handleException (Exception exception) {
        ex.add(exception);
    }

    public Result executes (String userId, String description,  String zoomUrl, String googleMeetUrl) {
        try {
            UserEntity user = userRepository.getUserById(userId);
            if (user == null) {
                return new UserNotFound();
            }
            if (user.getRole().getType() == UserRole.TYPE.MENTOR) {
                return new UserAlreadyAMentor();
            }
            else if(user.getRole().getType() != UserRole.TYPE.MEMBER) {
                return new OnlyGuestCanBecomeMentor();
            }
            // check platform
            if (!platformChecker.isValid(MeetingPlatform.PLATFORM.ZOOM, zoomUrl) && !platformChecker.isValid(MeetingPlatform.PLATFORM.GOOGLE_MEET, googleMeetUrl)) {
                return new InvalidPlatform();
            }
            MasaLog.normalLog("Send email to become mentor");
            // save request
            RequestEntity addedRequest = requestRepository.addRequest(user.getId(), description, googleMeetUrl, zoomUrl, RequestEntity.STATUS.PROCESSING);
            // send email to admin
            List<UserEntity> admins = userRepository.getAllAdmin();
            BecomeMentorEmail email = new BecomeMentorEmail(zoomUrl, googleMeetUrl, user.getEmail(), user.getId(), user.getFullName(), description, addedRequest.getId());
            ArrayList<Thread> ts = new ArrayList<>();
            for (UserEntity admin : admins) {
                MasaLog.normalLog("Send email to become mentor3: " + admin.getEmail());
                Thread t = new Thread(() -> {
                    try {
                        sendMailGateway.sendEmailNow(email, admin.getEmail());
                    } catch (ConnectionException e) {
                        handleException(e);
                    } catch (TimeOutException e) {
                        handleException(e);
                    }
                });
                ts.add(t);
                t.start();
                MasaLog.normalLog("Email-BecomeMentor-" +email.getSubject() + " had been sent to " + admin.getEmail());
            }
            MasaLog.normalLog("Send email to become mentor2");

            for (Thread t : ts) {
                t.join();
            }

            if (ex.size() > 0) {
                MasaLog.warningLog("Has exception: " + ex.size());
                for (Exception exception : ex) {
                    if (exception instanceof ConnectionException) {
                        return new Result.SendMailFailedButRequestSaved();
                    }
                    if (exception instanceof TimeOutException) {
                        return new Result.SendMailFailedButRequestSaved();
                    }
                }
            }
            return new Success();

        } catch (ConnectionException e) {
            return new GeneralError(e.getMessage());
        } catch (InterruptedException e) {
            return new Result.GeneralError(e.getMessage());
        }
    }

}
