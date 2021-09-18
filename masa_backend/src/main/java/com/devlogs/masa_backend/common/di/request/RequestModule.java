package com.devlogs.masa_backend.common.di.request;

import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import dagger.Module;
import dagger.Provides;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Module
public class RequestModule {
    private HttpServletResponse response;
    private HttpServletRequest request;
    private ResponseHelper responseHelper;

    public RequestModule(HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.response = response;
        this.request = request;
        this.responseHelper = new ResponseHelper(response);
    }

    @Provides
    @RequestScope
    public ResponseHelper provideResponseHelper () {
        return responseHelper;
    }
}
