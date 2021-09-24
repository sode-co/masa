package com.devlogs.masa_backend.request;

import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.RequestRepository;

import javax.inject.Inject;
import java.util.List;

public class GetAllRequestUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<RequestEntity> requests;

            public Success(List<RequestEntity> requests) {
                this.requests = requests;
            }
        }
        public static class ConnectionError extends Result {

        }
    }
    private RequestRepository requestRepository;
    @Inject
    public GetAllRequestUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Result executes(){
        try {
            List<RequestEntity> requests = requestRepository.getAll();
            return new Result.Success(requests);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
