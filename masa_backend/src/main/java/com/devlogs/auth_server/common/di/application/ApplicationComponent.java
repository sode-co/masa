package com.devlogs.auth_server.common.di.application;

import com.devlogs.auth_server.common.di.servlet.ServletComponent;
import com.devlogs.auth_server.common.di.servlet.ServletModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    ServletComponent newServletComponent (ServletModule servletModule);
}
