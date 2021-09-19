package com.devlogs.masa_backend.servlets.appointments;

import javax.validation.constraints.NotBlank;

public class CreateAppointmentReqBody {
    @NotBlank
    private String userId;
    @NotBlank
    private String meetingId;

    public CreateAppointmentReqBody () {

    }

    public CreateAppointmentReqBody(String userId, String meetingId) {
        this.userId = userId;
        this.meetingId = meetingId;
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
