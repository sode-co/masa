package com.devlogs.masa_backend.data.remote_database;

public class UserDto {


    private String id;
    private String fullName;
    private String email;
    private String avatar_url;
    private int role_ID;
    private int status_id;


    public UserDto() {
    }

    public UserDto(String id, String fullName, String email, String avatar_url, int role_ID, int status_id) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.avatar_url = avatar_url;
        this.role_ID = role_ID;
        this.status_id = status_id;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public int getRole_ID() {
        return role_ID;
    }

    public int getStatus_id() {
        return status_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                " id= '" + id + '\'' +
                ",  fullName= '" + fullName + '\'' +
                ",  email= '" + email + '\'' +
                ",  avatar_url= '" + avatar_url + '\'' +
                ",  role_ID= " + role_ID +
                ",  status_id= " + status_id +
                '}';
    }

}
