package com.devlogs.masa_backend.manage;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.BecomeMentorRequestEntity;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.BecomeMentorRequestRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.repository.user.UserRepositoryImp;
import com.devlogs.masa_backend.request.become_mentor.GetAllBecomeMentorRequestUseCase;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetUserFromRequestProcessingUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<UserEntity> userEntities;

            public Success(List<UserEntity> userEntities) {
                this.userEntities = userEntities;
            }
        }
        public static class ConnectionError extends Result {

        }
    }

    private final BecomeMentorRequestRepository requestRepository;
    private final UserRepository userRepository;

    @Inject
    public GetUserFromRequestProcessingUseCase(BecomeMentorRequestRepository requestRepository,UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    public Result executes(){
        try {
            List<BecomeMentorRequestEntity> requests = requestRepository.getAll();
            String user_id;
            List<UserEntity> userEntities = new ArrayList<>();
            for (BecomeMentorRequestEntity entity : requests) {
                if (entity.getStatus() == RequestEntity.STATUS.PROCESSING) {
                    user_id = entity.getUserId();
                    userEntities.add(userRepository.getUserById(user_id));
                }
            }
            return new Result.Success(userEntities);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }

}


