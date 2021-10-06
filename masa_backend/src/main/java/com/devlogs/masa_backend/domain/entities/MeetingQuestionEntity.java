package com.devlogs.masa_backend.domain.entities;

public class MeetingQuestionEntity {
    private String id;
    private String title;
    private String userId;
    private String meetingId;
    private long createdDate;

    public MeetingQuestionEntity(String id, String title, String userId, String meetingId, long createdDate) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.meetingId = meetingId;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
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
