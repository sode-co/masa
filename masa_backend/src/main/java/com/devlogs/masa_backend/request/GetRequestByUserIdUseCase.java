package com.devlogs.masa_backend.request;

import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.RequestRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;
import java.util.List;

public class GetRequestByUserIdUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<RequestEntity> requests;
            public Success(List<RequestEntity> requests) {
                this.requests = requests;
            }
        }

        public static class ConnectionError extends Result {

        }
        public static class UserDoesNotExist extends Result {

        }
    }

    private RequestRepository requestRepository;
    private UserRepository userRepository;
    @Inject
    public GetRequestByUserIdUseCase(RequestRepository requestRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    public Result executes (String hostId) {
        try {
            UserEntity userEntity = userRepository.getUserById(hostId);
            if (userEntity == null) {
                return new Result.UserDoesNotExist();
            }
            List<RequestEntity> requests = requestRepository.getRequestByUserId(hostId);
            return new Result.Success(requests);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
