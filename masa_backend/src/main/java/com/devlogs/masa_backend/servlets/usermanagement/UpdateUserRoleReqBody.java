package com.devlogs.masa_backend.servlets.usermanagement;

import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.servlets.common.validation.EnumValidator;

import javax.validation.constraints.NotBlank;

public class UpdateUserRoleReqBody {

    @EnumValidator(
            enumClazz = UserRole.TYPE.class,
            message = "Your role must be 'GUEST' or 'MENTOR' or 'STUDENT' or 'ADMIN'"
    )
    private String role;

    public UpdateUserRoleReqBody() {
    }

    public UpdateUserRoleReqBody( String role) {

        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
