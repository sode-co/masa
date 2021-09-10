package com.devlogs.auth_server.servlets.common.base;

import com.devlogs.auth_server.common.Masa;
import com.devlogs.auth_server.common.di.application.ApplicationComponent;
import com.devlogs.auth_server.common.di.controller.ControllerComponent;
import com.devlogs.auth_server.common.di.controller.DataModule;
import com.devlogs.auth_server.common.di.controller.RepositoryModule;
import com.devlogs.auth_server.common.di.servlet.ServletModule;
import javax.servlet.http.HttpServlet;

public class BaseHttpServlet extends HttpServlet {
    protected ControllerComponent getControllerComponent () {
        return ((ApplicationComponent) getServletContext().getAttribute(Masa.Component.APPLICATION_COMPONENT))
                .newServletComponent(new ServletModule())
                .newControllerComponent(
                        new DataModule(),
                        new RepositoryModule());
    }
}
