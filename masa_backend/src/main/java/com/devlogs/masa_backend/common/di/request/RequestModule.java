package com.devlogs.masa_backend.common.di.request;

import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.io.IOException;

@Module
public class RequestModule {
    private HttpServletResponse response;
    private HttpServletRequest request;
    private ResponseHelper responseHelper;
    private RequestHelper requestHelper;

    public RequestModule(HttpServletResponse response, HttpServletRequest request, Validator validator) throws IOException {
        this.response = response;
        this.request = request;
        this.responseHelper = new ResponseHelper(response);
        this.requestHelper = new RequestHelper(request, validator);
    }

    @Provides
    @RequestScope
    public HttpServletResponse provideCurrentHttpServletResponse () {
        return response;
    }

    @Provides
    @RequestScope
    public HttpServletRequest provideCurrentHttpServletRequest () {
        return request;
    }

    @Provides
    @RequestScope
    public ResponseHelper provideResponseHelper () {
        return responseHelper;
    }

    @Provides
    @RequestScope
    public RequestHelper provideRequestHelper () {
        return requestHelper;
    }
}
