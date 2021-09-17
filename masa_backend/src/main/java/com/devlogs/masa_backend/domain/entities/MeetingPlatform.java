package com.devlogs.masa_backend.domain.entities;

public class MeetingPlatform {
    public enum PLATFORM {
        ZOOM, GOOGLE_MEET
    }

    private PLATFORM platform;
    private String url;

    public MeetingPlatform(PLATFORM platform, String url) {
        this.platform = platform;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public PLATFORM getPlatform() {
        return platform;
    }
}
