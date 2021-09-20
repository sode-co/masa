package com.devlogs.masa_backend.servlets.listeners;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.di.application.ApplicationModule;
import com.devlogs.masa_backend.common.di.application.DaggerApplicationComponent;
import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("The real real path: " + sce.getServletContext().getRealPath("/WEB-INF"));
        sce.getServletContext().setAttribute(Masa.Component.APPLICATION_COMPONENT,
                DaggerApplicationComponent.builder()
                        .applicationModule(new ApplicationModule(sce.getServletContext())).build());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }


}
