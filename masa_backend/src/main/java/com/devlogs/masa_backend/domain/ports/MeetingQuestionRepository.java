package com.devlogs.masa_backend.domain.ports;

import com.devlogs.masa_backend.domain.entities.MeetingQuestionEntity;
import com.devlogs.masa_backend.domain.errors.ConnectionException;

import java.util.List;

public interface MeetingQuestionRepository {
    List<MeetingQuestionEntity> getAllQuestionsByMeetingId(String id) throws ConnectionException;
    MeetingQuestionEntity createMeetingQuestion(String title, String userId, String meetingId) throws ConnectionException;
}
