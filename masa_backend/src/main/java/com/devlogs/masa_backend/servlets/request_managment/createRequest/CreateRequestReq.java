package com.devlogs.masa_backend.servlets.request_managment.createRequest;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.servlets.common.validation.EnumValidator;

import javax.validation.constraints.NotBlank;

public class CreateRequestReq {
    @NotBlank(message = "Your request description can not be empty")
    private String description;
    @NotBlank(message = "Your request type can not be empty")
    @EnumValidator(
            enumClazz = RequestEntity.TYPE.class,
            message = "Your request type have to be `BECOME_MENTOR`"
    )
    private String type;
    @NotBlank(message = "Your user id can not be empty")
    private String userId;

    public CreateRequestReq(){}

    public CreateRequestReq(String description, String type, String userId) {
        this.description = description;
        this.type = type;
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
