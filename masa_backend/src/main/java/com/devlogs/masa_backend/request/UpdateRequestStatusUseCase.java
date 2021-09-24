package com.devlogs.masa_backend.request;

import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.errors.NotFoundException;
import com.devlogs.masa_backend.domain.ports.RequestRepository;

import javax.inject.Inject;

public class UpdateRequestStatusUseCase {
    public static class Result {
        public static class Success extends Result {
        }

        public static class ConnectionError extends Result {

        }

        public static class RequestDoesNotExist extends Result {

        }
    }

    private RequestRepository requestRepository;
    @Inject
    public UpdateRequestStatusUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }


    public Result executes (String requestId , RequestEntity.STATUS status) {
        try {
            RequestEntity requestEntity = requestRepository.getRequestById(requestId);
            if (requestEntity == null) {
                return new Result.RequestDoesNotExist();
            }
            requestRepository.updateRequestStatus(requestId, status);
            return new Result.Success();
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
