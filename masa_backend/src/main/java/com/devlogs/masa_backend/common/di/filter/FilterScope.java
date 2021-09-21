package com.devlogs.masa_backend.common.di.filter;

import javax.inject.Scope;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Identifies a type that the injector only instantiates once *IN THE SAME SERVLET CONTEXT* . Not inherited.
 * @see Scope @Scope
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface FilterScope {}