package com.devlogs.masa_backend.domain.entities;

public class BecomeMentorRequestEntity extends RequestEntity {

    private String zoomUrl;
    private String meetUrl;

    public BecomeMentorRequestEntity(String id, String description, String userId, STATUS status, String zoomUrl, String meetUrl, long createdDate) {
        super(id, description, userId, status, createdDate);
        this.zoomUrl = zoomUrl;
        this.meetUrl = meetUrl;
    }

    public String getZoomUrl() {
        return zoomUrl;
    }

    public String getMeetUrl() {
        return meetUrl;
    }
}
