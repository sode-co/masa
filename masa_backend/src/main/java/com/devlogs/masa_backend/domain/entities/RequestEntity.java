package com.devlogs.masa_backend.domain.entities;

public class RequestEntity extends Entity {
    public enum STATUS {
        PROCESSING, DENIED, APPROVED
    }
    private String description;
    private String userId;
    private STATUS status;
    private long createdDate;

    public RequestEntity(String id, String description, String userId, STATUS status, Long createdDate) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.status = status;
        this.createdDate = createdDate;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public STATUS getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }
}
