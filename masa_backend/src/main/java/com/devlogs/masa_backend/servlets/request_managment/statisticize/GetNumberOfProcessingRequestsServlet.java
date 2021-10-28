package com.devlogs.masa_backend.servlets.request_managment.statisticize;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.request.become_mentor.GetAllBecomeMentorRequestUseCase;
import com.devlogs.masa_backend.request.become_mentor.GetNumberOfProcessingRequestsUseCase;
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
@WebServlet(name = "numberOfProcessingRequests", urlPatterns = "/api/admin/request-management/statistics")
public class GetNumberOfProcessingRequestsServlet extends BaseHttpServlet {
    @Inject
    GetNumberOfProcessingRequestsUseCase getNumberOfProcessingRequestsUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetNumberOfProcessingRequestsUseCase.Result result = getNumberOfProcessingRequestsUseCase.executes();
        if (result instanceof GetNumberOfProcessingRequestsUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetNumberOfProcessingRequestsUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}
