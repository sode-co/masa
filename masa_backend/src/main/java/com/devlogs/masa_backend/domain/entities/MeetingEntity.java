package com.devlogs.masa_backend.domain.entities;

public class MeetingEntity {
    private String id;
    private String title;
    private MeetingPlatform platform;
    private String hostId;
    private long startTime;
    private long endTime;
    private String description;

    public MeetingEntity(String id, String title, MeetingPlatform platform, String hostId, long startTime, long endTime, String description) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.hostId = hostId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPlatform(MeetingPlatform platform) {
        this.platform = platform;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public MeetingPlatform getPlatform() {
        return platform;
    }

    public String getHostId() {
        return hostId;
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

    @Override
    public String toString() {
        return "MeetingEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", platform=" + platform +
                ", hostId=" + hostId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                '}';
    }
}
