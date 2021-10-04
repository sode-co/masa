package com.devlogs.masa_backend.repository.request;

public class BecomeMentorRequestPayload {
    private String zoomUrl;
    private String meetUrl;

    public BecomeMentorRequestPayload () {

    }

    public BecomeMentorRequestPayload(String zoomUrl, String meetUrl) {
        this.zoomUrl = zoomUrl;
        this.meetUrl = meetUrl;
    }

    public String getZoomUrl() {
        return zoomUrl;
    }

    public void setZoomUrl(String zoomUrl) {
        this.zoomUrl = zoomUrl;
    }

    public String getMeetUrl() {
        return meetUrl;
    }

    public void setMeetUrl(String meetUrl) {
        this.meetUrl = meetUrl;
    }
}
