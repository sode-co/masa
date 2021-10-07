package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GetMeetingsByTopicNameReqBody {
    @NotNull(message = "topicName can not be empty")
    @NotEmpty(message = "topicName can not be empty")
    public String[] topicName;
}
