package com.devlogs.masa_backend.servlets.meeting_question.createMeetingQuestion;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CreateMeetingQuestionReq {
    @NotBlank(message = "Your question title can not be empty")
    @Length(min = 1, max = 250, message = "Question title have to be between 10 to 20 characters")
    private String title;
    @NotBlank(message = "Your user id can not be empty")
    private String userId;
    @NotBlank(message = "Your meeting id can not be empty")
    private String meetingId;

    public CreateMeetingQuestionReq() {
    }

    public CreateMeetingQuestionReq(String title, String userId, String meetingId) {
        this.title = title;
        this.userId = userId;
        this.meetingId = meetingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}
