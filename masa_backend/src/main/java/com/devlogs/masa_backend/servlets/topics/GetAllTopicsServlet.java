package com.devlogs.masa_backend.servlets.topics;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.devlogs.masa_backend.topics.GetAllTopicsUseCase;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AccessRole(roles = {UserRole.TYPE.STUDENT, UserRole.TYPE.ADMIN, UserRole.TYPE.MENTOR, UserRole.TYPE.MEMBER})
@WebServlet(name = "getalltopicservlet", urlPatterns = {"/api/topic-management/all"})
public class GetAllTopicsServlet extends BaseHttpServlet {

    @Inject
    protected GetAllTopicsUseCase getAllTopicsUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseHelper responseHelper = getRequestComponent().getResponseHelper();

        GetAllTopicsUseCase.Result result = getAllTopicsUseCase.executes();

        if (result instanceof GetAllTopicsUseCase.Result.Success) {
            responseHelper.responseJson(200, new Gson().toJson(result));
            return;
        }

        if (result instanceof GetAllTopicsUseCase.Result.GeneralError) {
            responseHelper.responseMessage(500, "Internal server error: general error");
            return;
        }
    }

}
