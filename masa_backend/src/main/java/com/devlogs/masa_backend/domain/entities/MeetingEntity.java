package com.devlogs.masa_backend.domain.entities;

import java.util.Objects;

public class MeetingEntity extends Entity {
    private String title;
    private MeetingPlatform platform;
    private TopicEntity topic;
    private String hostId;
    private long startTime;
    private long endTime;
    private String description;

    public MeetingEntity(String id, String title, MeetingPlatform platform, TopicEntity topic, String hostId, long startTime, long endTime, String description) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.topic = topic;
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

    public TopicEntity getTopic() {
        return topic;
    }

    public void setTopic(TopicEntity topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "MeetingEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", platform=" + platform +
                ", topic=" + topic +
                ", hostId='" + hostId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MeetingEntity that = (MeetingEntity) o;
        return startTime == that.startTime && endTime == that.endTime && Objects.equals(title, that.title) && Objects.equals(platform, that.platform) && Objects.equals(topic, that.topic) && Objects.equals(hostId, that.hostId) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, platform, topic, hostId, startTime, endTime, description);
    }
}
