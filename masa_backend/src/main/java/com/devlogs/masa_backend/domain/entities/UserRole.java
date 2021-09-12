package com.devlogs.masa_backend.domain.entities;

public class UserRole {
    public enum TYPE {
        ADMIN, USER, MEMBER, LECTURER, MENTOR
    }

    private TYPE type;

    public UserRole(TYPE type) {
        this.type = type;
    }

    public TYPE getType() {
        return type;
    }
}
