package com.devlogs.masa_backend.login_convention;

import com.devlogs.masa_backend.domain.entities.UserRole;

import javax.annotation.Nullable;

public interface EmailValidator {
      class Result {
        @Nullable
        public UserRole role;
          public boolean isValid;

        public Result(@Nullable  UserRole role, boolean isValid) {
            this.role = role;
            this.isValid = isValid;
        }
    }

    EmailValidator.Result check (String email);
}
