package com.devlogs.masa_backend.request.become_mentor;

import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.BecomeMentorRequestRepository;

import javax.inject.Inject;

public class GetNumberOfProcessingRequestsUseCase {
    public static class Result {
        public static class Success extends Result {
            public int numOfRequests;

            public Success(int numOfRequests) {
                this.numOfRequests = numOfRequests;
            }
        }
        public static class ConnectionError extends Result {

        }
    }
    private BecomeMentorRequestRepository requestRepository;
    @Inject
    public GetNumberOfProcessingRequestsUseCase(BecomeMentorRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Result executes(){
        try {
            int numOfRequests = requestRepository.countAllProcessingRequest();
            return new Result.Success(numOfRequests);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
