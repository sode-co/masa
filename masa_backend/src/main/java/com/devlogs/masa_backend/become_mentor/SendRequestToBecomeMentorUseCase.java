package com.devlogs.masa_backend.become_mentor;

import com.devlogs.masa_backend.become_mentor.SendRequestToBecomeMentorUseCase.Result.*;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.TimeOutException;
import com.devlogs.masa_backend.domain.ports.RequestRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.domain.ports.sendmail.BecomeMentorEmail;
import com.devlogs.masa_backend.domain.ports.sendmail.SendMailGateway;
import com.devlogs.masa_backend.platform.PlatformChecker;

import javax.inject.Inject;
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
    private RequestRepository requestRepository;

    @Inject
    public SendRequestToBecomeMentorUseCase(UserRepository userRepository, PlatformChecker platformChecker, SendMailGateway sendMailGateway, RequestRepository requestRepository) {
        this.userRepository = userRepository;
        this.platformChecker = platformChecker;
        this.sendMailGateway = sendMailGateway;
        this.requestRepository = requestRepository;
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
            else if(user.getRole().getType() != UserRole.TYPE.GUEST) {
                return new OnlyGuestCanBecomeMentor();
            }
            // check platform
            if (!platformChecker.isValid(MeetingPlatform.PLATFORM.ZOOM, zoomUrl) && !platformChecker.isValid(MeetingPlatform.PLATFORM.GOOGLE_MEET, googleMeetUrl)) {
                return new InvalidPlatform();
            }
            // save request
            RequestEntity addedRequest = requestRepository.addRequest(user.getId(), description, RequestEntity.TYPE.BECOME_MENTOR, RequestEntity.STATUS.PROCESSING);
            // send email to admin
            List<UserEntity> admins = userRepository.getAllAdmin();
            BecomeMentorEmail email = new BecomeMentorEmail(zoomUrl, googleMeetUrl, user.getEmail(), user.getId(), user.getFullName(), description, addedRequest.getId());

            for (UserEntity admin : admins) {
                sendMailGateway.sendEmailNow(email, admin.getEmail());
                MasaLog.normalLog("Email-BecomeMentor-" +email.getSubject() + " had been sent to " + admin.getEmail());
            }
            return new Success();

        } catch (ConnectionException e) {
            return new GeneralError(e.getMessage());
        } catch (TimeOutException e) {
            return new SendMailFailedButRequestSaved();
        }
    }

}
