package com.devlogs.auth_server.servlets.listeners;

import com.devlogs.auth_server.common.Masa;
import com.devlogs.auth_server.common.di.application.ApplicationModule;
//import com.devlogs.auth_server.common.di.application.DaggerApplicationComponent;

import javax.servlet.ServletContextEvent;

public class ServletContextListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        sce.getServletContext().setAttribute(Masa.Component.APPLICATION_COMPONENT,
//                DaggerApplicationComponent.builder()
//                        .applicationModule(new ApplicationModule(sce.getServletContext())).build());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
