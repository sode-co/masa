package com.devlogs.masa_backend.domain.entities;

public class MeetingPlatform {
    public enum PLATFORM {
        GOOGLE_MEET,ZOOM
    }

    private String mentorId;
    private PLATFORM platform;
    private String url;

    public MeetingPlatform(PLATFORM platform,String mentorId, String url) {
        this.platform = platform;
        this.mentorId = mentorId;
        this.url = url;
    }

    public String getMentorId() {
        return mentorId;
    }

    public String getUrl() {
        return url;
    }

    public PLATFORM getPlatform() {
        return platform;
    }
}
