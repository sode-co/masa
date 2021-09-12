package com.devlogs.masa_backend.domain.entities;

public class UserEntity {
    private String email;
    private String name;
    private UserRole role;
    private UserStatus status;

    public UserEntity(String email, String name, UserRole role, UserStatus status) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() {
        return role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus (UserStatus status) {
        this.status = status;
    }
}
