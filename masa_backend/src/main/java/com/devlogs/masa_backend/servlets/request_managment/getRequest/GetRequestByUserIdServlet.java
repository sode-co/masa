package com.devlogs.masa_backend.servlets.request_managment.getRequest;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetMeetingByHostUseCase;
import com.devlogs.masa_backend.request.GetRequestByUserIdUseCase;
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
@WebServlet(name = "getrequestbyuserid", urlPatterns = {"/api/request-management/requests/user/*"})
public class GetRequestByUserIdServlet extends BaseHttpServlet {
    @Inject
    protected GetRequestByUserIdUseCase getRequestByUserIdUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        String userId = url.substring(url.lastIndexOf("/") +1);

        if (userId.contains("/")) {userId = userId.replaceAll("/", "");}
        if (userId.trim().isEmpty()) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Invalid user id");
        }
        GetRequestByUserIdUseCase.Result result = getRequestByUserIdUseCase.executes(userId);
        if (result instanceof GetRequestByUserIdUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetRequestByUserIdUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}
