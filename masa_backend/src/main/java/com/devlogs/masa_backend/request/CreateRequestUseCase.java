package com.devlogs.masa_backend.request;

import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.RequestRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class CreateRequestUseCase {
    public static class Result {
        public static class Success extends Result {
            public RequestEntity requestEntity;

            public Success(RequestEntity requestEntity) {
                this.requestEntity = requestEntity;
            }
        }

        public static class HostDoesNotExist extends Result {

        }

        public static class NotRoleAllowError extends Result {

        }

        public static class ConnectionError extends Result {

        }
    }

    private UserRepository userRepository;
    private RequestRepository requestRepository;
    @Inject

    public CreateRequestUseCase(UserRepository userRepository, RequestRepository requestRepository) {
        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
    }

    public Result executes (String description, RequestEntity.TYPE type, String userId) {
        try {
            UserEntity user = userRepository.getUserById(userId);
            if (user == null) {
                return new Result.HostDoesNotExist();
            }
            if (user.getRole().getType() == UserRole.TYPE.STUDENT) {
                return new Result.NotRoleAllowError();
            }
            RequestEntity requestEntity = requestRepository.addRequest(userId,description,type, RequestEntity.STATUS.PROCESSING);
            return new Result.Success(requestEntity);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
