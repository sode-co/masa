package com.devlogs.masa_backend.common.di.application;

import com.devlogs.masa_backend.common.di.filter.FilterComponent;
import com.devlogs.masa_backend.common.di.filter.FilterModule;
import com.devlogs.masa_backend.common.di.servlet.ServletComponent;
import com.devlogs.masa_backend.common.di.servlet.ServletModule;
import com.devlogs.masa_backend.servlets.listeners.ApplicationContextListener;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    ServletComponent newServletComponent (ServletModule servletModule);
    FilterComponent newFilterComponent (FilterModule servletModule);
    void inject(ApplicationContextListener applicationContextListener);
}
