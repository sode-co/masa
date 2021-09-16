package com.devlogs.masa_backend.domain.entities;

public class UserEntity {
    private String email;
    private String fullName;
    private UserRole role;
    private UserStatus status;

    public UserEntity(String email, String name, UserRole role, UserStatus status) {
        this.email = email;
        this.fullName = name;
        this.role = role;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
