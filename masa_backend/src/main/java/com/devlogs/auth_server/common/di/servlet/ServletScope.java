package com.devlogs.auth_server.common.di.servlet;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Identifies a type that the injector only instantiates once *IN THE SAME SERVLET CONTEXT* . Not inherited.
 * @see javax.inject.Scope @Scope
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ServletScope {}