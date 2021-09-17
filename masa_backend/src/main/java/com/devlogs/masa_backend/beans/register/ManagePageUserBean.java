package com.devlogs.masa_backend.beans.register;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ManagePageUserBean {
    @NotBlank (message = "User name can not be null")
    private String name;
    @Email (message = "Your user email is invalid")
    @NotBlank (message = "Your user email can not empty")
    private String email;
    @Max(value=80, message = "Your age is invalid")
    @Min(value = 16, message = "Your age is invalid")
    private int age;

    public ManagePageUserBean() {

    }

    public ManagePageUserBean(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
