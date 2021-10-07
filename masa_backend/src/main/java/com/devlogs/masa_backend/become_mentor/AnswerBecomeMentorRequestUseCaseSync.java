package com.devlogs.masa_backend.become_mentor;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.*;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.BecomeMentorRequestRepository;

import com.devlogs.masa_backend.domain.ports.PlatformRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class AnswerBecomeMentorRequestUseCaseSync {
    public static class Result {
        public static class Success extends Result {

        }
        public static class InvalidUserRole extends Result {

        }
        public static class GeneralError extends Result {

        }
        public static class RequestAlreadyAnswered extends Result {

        }
        public static class RequestNotFound extends Result {

        }
        public static class UserNotFound extends Result {

        }
    }

    private BecomeMentorRequestRepository requestRepository;
    private UserRepository userRepository;
    private PlatformRepository platformRepository;

    @Inject
    public AnswerBecomeMentorRequestUseCaseSync(PlatformRepository platformRepository, BecomeMentorRequestRepository requestRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.platformRepository = platformRepository;
    }

    public Result executes (String requestId, RequestEntity.STATUS answer) {
        try {
            MasaLog.normalLog("Answer become request with id: " + requestId);
            BecomeMentorRequestEntity request = requestRepository.getRequestById(requestId);

            if (request == null) {
                return new Result.RequestNotFound();
            }

            UserEntity user = userRepository.getUserById(request.getUserId());

            if (user == null) {
                return new Result.UserNotFound();
            }


            if (user.getRole().getType() != UserRole.TYPE.GUEST) {
                return new Result.InvalidUserRole();
            }

            if (request.getStatus() != RequestEntity.STATUS.PROCESSING) {
                return new Result.RequestAlreadyAnswered();
            }

            requestRepository.updateRequestStatus(requestId, answer);
            if (answer == RequestEntity.STATUS.APPROVED) {
                userRepository.updateUserRole(request.getUserId(), new UserRole(UserRole.TYPE.MENTOR));
                platformRepository.addPlatform(new MeetingPlatform(MeetingPlatform.PLATFORM.GOOGLE_MEET,request.getUserId(), request.getMeetUrl()));
                platformRepository.addPlatform(new MeetingPlatform(MeetingPlatform.PLATFORM.ZOOM,request.getUserId(), request.getZoomUrl()));
            }
            return new Result.Success();
        } catch (ConnectionException e) {
            return new Result.GeneralError();
        }
    }
}
