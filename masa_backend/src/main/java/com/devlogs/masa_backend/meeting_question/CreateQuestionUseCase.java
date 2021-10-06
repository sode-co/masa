package com.devlogs.masa_backend.meeting_question;

import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.MeetingQuestionEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.domain.ports.MeetingQuestionRepository;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;

import javax.inject.Inject;

public class CreateQuestionUseCase {
    public static class Result {
        public static class Success extends Result {
            public MeetingQuestionEntity meetingQuestion;

            public Success(MeetingQuestionEntity meetingQuestion) {
                this.meetingQuestion = meetingQuestion;
            }
        }
        public static class ConnectionError extends Result {

        }
        public static class UserNotFoundError extends Result {

        }
        public static class MeetingNotFoundError extends Result {

        }
    }

    private MeetingQuestionRepository meetingQuestionRepository;
    private UserRepository userRepository;
    private MeetingRepository meetingRepository;
    @Inject
    public CreateQuestionUseCase(MeetingQuestionRepository meetingQuestionRepository, UserRepository userRepository, MeetingRepository meetingRepository) {
        this.meetingQuestionRepository = meetingQuestionRepository;
        this.userRepository = userRepository;
        this.meetingRepository = meetingRepository;
    }



    public Result executes (String title, String userId, String meetingId) {
        try {
            UserEntity user = userRepository.getUserById(userId);
            if (user == null) {
                return new Result.UserNotFoundError();
            }
            MeetingEntity meeting = meetingRepository.getById(meetingId);
            if(meeting == null){
                return new Result.MeetingNotFoundError();
            }

            MeetingQuestionEntity meetingQuestion = meetingQuestionRepository.createMeetingQuestion(title,user.getId(),meeting.getId());
            if (meetingQuestion == null){
                throw new RuntimeException("Can not create meeting question");
            }
            return new Result.Success(meetingQuestion);
        } catch (ConnectionException e) {
            return new Result.ConnectionError();
        }
    }
}
