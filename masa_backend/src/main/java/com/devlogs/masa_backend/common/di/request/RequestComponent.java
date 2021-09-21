package com.devlogs.masa_backend.common.di.request;

import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import dagger.Subcomponent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Subcomponent(modules = RequestModule.class)
@RequestScope
public interface RequestComponent {
     HttpServletRequest getCurrentRequest();
     HttpServletResponse getCurrentResponse ();
     ResponseHelper getResponseHelper ();
     RequestHelper getRequestHelper ();
}
