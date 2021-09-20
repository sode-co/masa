package com.devlogs.masa_backend.domain.entities;

public class RequestEntity {
    public enum TYPE {
        BECOME_MENTOR
    }
    public enum STATUS {
        PROCESSING, DENIED, APPROVED
    }
    private String id;
    private String description;
    private TYPE type;
    private String userId;
    private STATUS status;

    public RequestEntity(String id, String description, TYPE type, String userId, STATUS status) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.userId = userId;
        this.status = status;
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

    public TYPE getType() {
        return type;
    }

    public String getUserId() {
        return userId;
    }
}
