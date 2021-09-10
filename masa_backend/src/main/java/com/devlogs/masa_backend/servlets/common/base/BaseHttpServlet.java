package com.devlogs.masa_backend.servlets.common.base;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.di.application.ApplicationComponent;
import com.devlogs.masa_backend.common.di.controller.ControllerComponent;
import com.devlogs.masa_backend.common.di.controller.DataModule;
import com.devlogs.masa_backend.common.di.controller.RepositoryModule;
import com.devlogs.masa_backend.common.di.servlet.ServletModule;
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
