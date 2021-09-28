package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetAllMeetingUseCase;
import com.devlogs.masa_backend.meeting.GetAllUserFollowedMeetingUseCase;
import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.*;

@AccessRole(roles = {ADMIN, STUDENT})
@WebServlet(name = "getalluserfollowedmeetingservlet", urlPatterns = {"/api/meeting-management/followed-meetings/*"})
public class GetAllUserFollowedMeetingServlet extends BaseHttpServlet {

    @Inject
    protected GetAllUserFollowedMeetingUseCase getAllUserFollowedMeetingUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestHelper requestHelper = getRequestComponent().getRequestHelper();
        ResponseHelper responseHelper = getRequestComponent().getResponseHelper();

        String userId = requestHelper.getTailRequestParam(null );
        GetAllUserFollowedMeetingUseCase.Result result = getAllUserFollowedMeetingUseCase.executes(userId);
        if (result instanceof GetAllUserFollowedMeetingUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else  if (result instanceof GetAllUserFollowedMeetingUseCase.Result.UserNotFoundError) {
            getRequestComponent().getResponseHelper().responseMessage(404, "Your user id is not exist");
        }
        else if ( result instanceof GetAllUserFollowedMeetingUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}
