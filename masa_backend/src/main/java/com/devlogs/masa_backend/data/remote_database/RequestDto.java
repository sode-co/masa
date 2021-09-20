package com.devlogs.masa_backend.data.remote_database;

public class RequestDto {
    private String id;
    private String description;
    private String userId;
    private int statusId;
    private int typeId;

    public RequestDto(String id, String description, String userId, int statusId, int typeId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.statusId = statusId;
        this.typeId = typeId;
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

    public int getStatusId() {
        return statusId;
    }

    public int getTypeId() {
        return typeId;
    }
}
