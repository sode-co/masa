package com.devlogs.masa_backend.become_mentor;

import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.RequestRepository;
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

        public static class RequestNotFound extends Result {

        }
        public static class UserNotFound extends Result {

        }
    }

    private RequestRepository requestRepository;
    private UserRepository userRepository;

    @Inject
    public AnswerBecomeMentorRequestUseCaseSync(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Result executes (String requestId, String userId, RequestEntity.STATUS answer) {
        try {
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
            requestRepository.answerRequest(requestId, answer);

            return new Result.Success();
        } catch (ConnectionException e) {
            return new Result.GeneralError();
        }
    }
}
