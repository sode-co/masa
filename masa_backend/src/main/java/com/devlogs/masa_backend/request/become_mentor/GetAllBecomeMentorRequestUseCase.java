package com.devlogs.masa_backend.request.become_mentor;

import com.devlogs.masa_backend.domain.entities.BecomeMentorRequestEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.BecomeMentorRequestRepository;

import javax.inject.Inject;
import java.util.List;

public class GetAllBecomeMentorRequestUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<BecomeMentorRequestEntity> requests;

            public Success(List<BecomeMentorRequestEntity> requests) {
                this.requests = requests;
            }
        }
        public static class ConnectionError extends Result {

        }
    }
    private BecomeMentorRequestRepository requestRepository;
    @Inject
    public GetAllBecomeMentorRequestUseCase(BecomeMentorRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Result executes(){
        try {
            List<BecomeMentorRequestEntity> requests = requestRepository.getAll();
            return new Result.Success(requests);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
