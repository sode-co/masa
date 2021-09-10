package com.devlogs.masa_backend.domain.ports.dto;

public class AccountDto {
    private String email;
    private String phoneNumber;
    private String password;

    public AccountDto(String email, String phoneNumber, String password) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
