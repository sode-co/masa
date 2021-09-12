package com.devlogs.masa_backend.domain.entities;

public class RequestEntity {
    private String id;
    private String title;
    private String roomId;

    public RequestEntity(String id, String title, String roomId) {
        this.id = id;
        this.title = title;
        this.roomId = roomId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRoomId() {
        return roomId;
    }
}
