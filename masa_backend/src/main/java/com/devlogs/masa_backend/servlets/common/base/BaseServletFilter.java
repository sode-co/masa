package com.devlogs.masa_backend.servlets.common.base;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.di.application.ApplicationComponent;
import com.devlogs.masa_backend.common.di.controller.ControllerComponent;
import com.devlogs.masa_backend.common.di.controller.DataModule;
import com.devlogs.masa_backend.common.di.controller.RepositoryModule;
import com.devlogs.masa_backend.common.di.filter.FilterComponent;
import com.devlogs.masa_backend.common.di.filter.FilterModule;
import com.devlogs.masa_backend.common.di.request.RequestComponent;
import com.devlogs.masa_backend.common.di.request.RequestModule;
import com.devlogs.masa_backend.common.di.servlet.ServletComponent;
import com.devlogs.masa_backend.common.di.servlet.ServletModule;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServletFilter implements Filter {
    private ControllerComponent controllerComponent;
    private FilterComponent servletComponent;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (servletComponent == null) {
            servletComponent = ((ApplicationComponent) filterConfig.getServletContext().getAttribute(Masa.Component.APPLICATION_COMPONENT))
                    .newFilterComponent(new FilterModule());
        }
    }

    protected FilterComponent getFilterComponent () {
        return servletComponent;
    }

    protected ControllerComponent getControllerComponent () {
        if (controllerComponent == null) {
            controllerComponent = getFilterComponent()
                    .newControllerComponent(
                            new DataModule(),
                            new RepositoryModule());
        }
        return controllerComponent;
    }

}
