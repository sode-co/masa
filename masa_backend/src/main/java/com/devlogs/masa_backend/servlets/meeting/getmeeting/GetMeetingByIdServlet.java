package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetMeetingByHostUseCase;
import com.devlogs.masa_backend.meeting.GetMeetingByIdUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.*;

@AccessRole(roles = {ADMIN, MENTOR, STUDENT})
@WebServlet(name = "getmeetingbyid", urlPatterns = {"/api/meeting-management/meeting/*"})
public class GetMeetingByIdServlet extends BaseHttpServlet {

    @Inject
    protected GetMeetingByIdUseCase getMeetingByIdUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        String meetingId = url.substring(url.lastIndexOf("/") +1);

        if (meetingId.contains("/")) {meetingId = meetingId.replaceAll("/", "");}
        if (meetingId.trim().isEmpty()) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Invalid host id");
        }
        GetMeetingByIdUseCase.Result result = getMeetingByIdUseCase.executes(meetingId);
        if (result instanceof GetMeetingByIdUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetMeetingByIdUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}