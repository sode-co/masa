package com.devlogs.masa_backend.common.annotations;

import com.devlogs.masa_backend.domain.entities.UserRole;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AccessRole {
    UserRole.TYPE[] roles();
}
