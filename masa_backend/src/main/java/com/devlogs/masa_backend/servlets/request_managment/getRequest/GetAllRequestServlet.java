package com.devlogs.masa_backend.servlets.request_managment.getRequest;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.request.GetAllRequestUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.ADMIN;

@AccessRole(roles = {ADMIN})
@WebServlet(name = "getallrequestservlet", urlPatterns = {"/api/request-management/requests"})
public class GetAllRequestServlet extends BaseHttpServlet {
    @Inject
    GetAllRequestUseCase getAllRequestUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetAllRequestUseCase.Result result = getAllRequestUseCase.executes();
        if (result instanceof GetAllRequestUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetAllRequestUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}
