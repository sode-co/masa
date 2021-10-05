package com.devlogs.masa_backend.domain.entities;

public class AppointmentEntity extends Entity{
    private String userId;
    private String meetingId;

    public AppointmentEntity(String userId, String meetingId) {
        this.userId = userId;
        this.meetingId = meetingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getMeetingId() {
        return meetingId;
    }
}
