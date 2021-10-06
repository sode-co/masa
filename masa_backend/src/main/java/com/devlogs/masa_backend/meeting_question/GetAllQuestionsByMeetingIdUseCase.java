package com.devlogs.masa_backend.meeting_question;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingQuestionEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingQuestionRepository;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.meeting.GetAllMeetingUseCase;

import javax.inject.Inject;
import java.util.List;

public class GetAllQuestionsByMeetingIdUseCase {
    public static class Result {
        public static class Success extends Result {
            public List<MeetingQuestionEntity> meetingQuestions;

            public Success(List<MeetingQuestionEntity> meetingQuestions) {
                this.meetingQuestions = meetingQuestions;
            }
        }

        public static class ConnectionError extends Result {

        }
        public static class MeetingNotFoundError extends Result {

        }
    }

    private MeetingQuestionRepository meetingQuestionRepository;
    private MeetingRepository meetingRepository;

    @Inject
    public GetAllQuestionsByMeetingIdUseCase(MeetingQuestionRepository meetingQuestionRepository,MeetingRepository meetingRepository) {
        this.meetingQuestionRepository = meetingQuestionRepository;
        this.meetingRepository = meetingRepository;
    }

    public Result executes (String id) {
        try {
            MeetingEntity meeting = meetingRepository.getById(id);
            if (meeting==null){
                return new Result.MeetingNotFoundError();
            }
            List<MeetingQuestionEntity> meetingQuestions = meetingQuestionRepository.getAllQuestionsByMeetingId(meeting.getId());
            return new Result.Success(meetingQuestions);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
