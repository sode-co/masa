package com.devlogs.masa_backend.data.remote_database;

public class MeetingDTO {
    private String id;
    private String title;
    private int platform_id;
    private String host_id;
    private int status_id;
    private int topic_id;
    private long startTime;
    private long endTime;
    private String description;

    public MeetingDTO(String id, String title, int platform_id, String host_id, int status_id, int topic_id, long startTime, long endTime, String description) {
        this.id = id;
        this.title = title;
        this.platform_id = platform_id;
        this.host_id = host_id;
        this.status_id = status_id;
        this.topic_id = topic_id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public int getTopic_id() {
        return topic_id;
    }
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPlatform_id() {
        return platform_id;
    }

    public String getHost_id() {
        return host_id;
    }

    public int getStatus_id() {
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

    @Override
    public String toString() {
        return "MeetingDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", platform_id=" + platform_id +
                ", host_id='" + host_id + '\'' +
                ", status_id=" + status_id +
                ", topic_id=" + topic_id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                '}';
    }
}
