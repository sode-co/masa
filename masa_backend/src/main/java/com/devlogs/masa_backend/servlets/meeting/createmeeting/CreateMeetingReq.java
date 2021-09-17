package com.devlogs.masa_backend.servlets.meeting.createmeeting;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.servlets.common.validation.EnumValidator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
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
    @NotBlank(message = "Your meeting url can not be empty")
    @URL(message = "Your meeting url is incorrect")
    private String platformUrl;
    @NotBlank(message = "Your host id can not be empty")
    private String host;
    @NotNull(message = "Your meeting startTime can not be empty")
    private long startTime;
    @NotNull(message = "Your meeting endTime can not be empty")
    private long endTime;
    @NotBlank(message = "Your meeting description can not be empty")
    private String description;

    public CreateMeetingReq( ) {
    }

    public CreateMeetingReq(String title, String platform, String platformUrl, String host, long startTime, long endTime, String description) {
        this.title = title;
        this.platform = platform;
        this.platformUrl = platformUrl;
        this.host = host;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public boolean isUrlMatchPlatform () {
        return (platform.equalsIgnoreCase("ZOOM") && platformUrl.contains("zoom.us"))
                || (platform.equalsIgnoreCase("GOOGLE_MEET") && platformUrl.contains("meet.google.com"));

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

    public String getPlatformUrl() {
        return platformUrl;
    }

    public void setPlatformUrl(String platformUrl) {
        this.platformUrl = platformUrl;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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
