package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import javax.validation.constraints.NotNull;

public class GetMeetingsByMultipleTopicsReqBody {
    @NotNull(message = "topicIds can not be null")
    public int[] topicIds;
}
