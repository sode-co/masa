package com.devlogs.masa_backend.servlets.common.base;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.di.application.ApplicationComponent;
import com.devlogs.masa_backend.common.di.controller.ControllerComponent;
import com.devlogs.masa_backend.common.di.controller.DataModule;
import com.devlogs.masa_backend.common.di.controller.RepositoryModule;
import com.devlogs.masa_backend.common.di.request.RequestComponent;
import com.devlogs.masa_backend.common.di.request.RequestModule;
import com.devlogs.masa_backend.common.di.servlet.ServletComponent;
import com.devlogs.masa_backend.common.di.servlet.ServletModule;
import com.devlogs.masa_backend.common.helper.MasaLog;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;

public class BaseHttpServlet extends HttpServlet {
    private ControllerComponent controllerComponent;
    private ServletComponent servletComponent;
    private RequestComponent requestComponent;

    protected ServletComponent getServletComponent () {
        if (servletComponent == null) {
            servletComponent = ((ApplicationComponent) getServletContext().getAttribute(Masa.Component.APPLICATION_COMPONENT))
                    .newServletComponent(new ServletModule());
        }
        return servletComponent;
    }

    protected ControllerComponent getControllerComponent () {
        if (controllerComponent == null) {
            controllerComponent = getServletComponent()
                    .newControllerComponent(
                            new DataModule(),
                            new RepositoryModule());
        }
        return controllerComponent;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!resp.isCommitted()) {
            MasaLog.normalLog("do Services:2 " + this.getClass().getSimpleName());
            requestComponent = getServletComponent().newRequestComponent(new RequestModule(resp, req, getServletComponent().getValidator()));
        } else {
            requestComponent = null;
        }
        super.service(req, resp);
    }

    protected RequestComponent getRequestComponent () {
        if (requestComponent == null) {
            throw new RuntimeException("You're out of request scope");
        }
        return requestComponent;
    }

    protected HttpServletRequest getCurrentRequest () {
        return getRequestComponent().getCurrentRequest();
    }

    protected HttpServletResponse getCurrentResponse () {
        return getRequestComponent().getCurrentResponse();
    }


}
