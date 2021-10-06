package com.devlogs.masa_backend.domain.entities;

public class MeetingQuestionEntity {
    private String id;
    private String title;
    private String userId;
    private String meetingId;
    private String createdDate;

    public MeetingQuestionEntity(String id, String title, String userId, String meetingId, String createdDate) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.meetingId = meetingId;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUserId() {
        return userId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "MeetingQuestionEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
