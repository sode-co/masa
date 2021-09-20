package com.devlogs.masa_backend.data.remote_database;

public class AppointmentDTO {
    private String userId;
    private String meetingId;

    public AppointmentDTO(String userId, String meetingId) {
        this.userId = userId;
        this.meetingId = meetingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "userId='" + userId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                '}';
    }
}
