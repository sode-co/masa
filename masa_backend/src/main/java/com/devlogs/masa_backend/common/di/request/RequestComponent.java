package com.devlogs.masa_backend.common.di.request;

import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import dagger.Subcomponent;

@Subcomponent(modules = RequestModule.class)
@RequestScope
public interface RequestComponent {
     ResponseHelper getResponseHelper ();
     RequestHelper getRequestHelper ();
}
