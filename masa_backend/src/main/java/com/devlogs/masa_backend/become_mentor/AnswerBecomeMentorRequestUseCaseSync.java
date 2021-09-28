package com.devlogs.masa_backend.become_mentor;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
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

    public Result executes (String requestId, String zoom, String meet, String userId, RequestEntity.STATUS answer) {
        try {
            MasaLog.normalLog("Answer become request with id: " + requestId);
            RequestEntity request = requestRepository.getRequestById(requestId);
            UserEntity user = userRepository.getUserById(userId);

            if (user == null) {
                return new Result.UserNotFound();
            }

            if (request == null) {
                return new Result.RequestNotFound();
            }

            if (user.getRole().getType() != UserRole.TYPE.GUEST) {
                return new Result.InvalidUserRole();
            }

            if (request.getStatus() != RequestEntity.STATUS.PROCESSING) {
                return new Result.RequestAlreadyAnswered();
            }

            requestRepository.updateRequestStatus(requestId, answer);
            if (answer == RequestEntity.STATUS.APPROVED) {
                userRepository.updateUserRole(userId, new UserRole(UserRole.TYPE.MENTOR));
                platformRepository.addPlatform(new MeetingPlatform(MeetingPlatform.PLATFORM.GOOGLE_MEET,userId, meet));
                platformRepository.addPlatform(new MeetingPlatform(MeetingPlatform.PLATFORM.ZOOM,userId, zoom));
            }
            return new Result.Success();
        } catch (ConnectionException e) {
            return new Result.GeneralError();
        }
    }
}
