package com.devlogs.masa_backend.common.di.application;

import com.devlogs.masa_backend.common.di.servlet.ServletComponent;
import com.devlogs.masa_backend.common.di.servlet.ServletModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    ServletComponent newServletComponent (ServletModule servletModule);
}
