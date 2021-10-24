package com.devlogs.masa_backend.servlets.meeting.deletemeeting;

import javax.validation.constraints.NotBlank;

public class DeleteMeetingReq {
    @NotBlank(message = "Your meeting id can not be empty")
    private String id;

    public DeleteMeetingReq() {

    }

    public DeleteMeetingReq(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
