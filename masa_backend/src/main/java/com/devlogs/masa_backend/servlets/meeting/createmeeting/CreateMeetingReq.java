package com.devlogs.masa_backend.servlets.meeting.createmeeting;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.servlets.common.validation.EnumValidator;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateMeetingReq {
    @NotBlank(message = "Your meeting title can not be empty")
    @Length(min = 1, max = 28, message = "Meeting title have to be between 10 to 20 characters")
    private String title;
    @NotBlank(message = "Your platform can not be empty")
    @EnumValidator(
            enumClazz = MeetingPlatform.PLATFORM.class,
            message = "Your platform have to be `ZOOM` or `GOOGLE_MEET`"
    )
    private String platform;
    @NotBlank(message = "Your host id can not be empty")
    private String host;
    @NotBlank(message = "Your topic can not be empty")
    private String topic;
    @NotNull(message = "Your meeting startTime can not be empty")
    @Min(value = 1, message = "Your meeting startTime is invalid")
    private long startTime;
    @NotNull(message = "Your meeting endTime can not be empty")
    @Min(value = 1, message = "Your meeting endTime is invalid")
    private long endTime;
    @NotBlank(message = "Your meeting description can not be empty")
    private String description;

    public CreateMeetingReq( ) {
    }

    public CreateMeetingReq(String title, String platform, String host, String topic, long startTime, long endTime, String description) {
        this.title = title;
        this.platform = platform;
        this.host = host;
        this.topic = topic;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
