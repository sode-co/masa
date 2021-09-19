package com.devlogs.masa_backend.data.remote_database;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.UserEntity;

public class MeetingDTO {
    private String id;
    private String title;
    private String platform_id;
    private String host_id;
    private String status_id;
    private long startTime;
    private long endTime;
    private String description;

    public MeetingDTO(String id, String title, String platform_id, String host_id, String status_id, long startTime, long endTime, String description) {
        this.id = id;
        this.title = title;
        this.platform_id = platform_id;
        this.host_id = host_id;
        this.status_id = status_id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPlatform_id() {
        return platform_id;
    }

    public String getHost_id() {
        return host_id;
    }

    public String getStatus_id() {
        return status_id;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }
}
