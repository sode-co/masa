package com.devlogs.masa_backend.servlets.meeting.statisticize;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetNumOfUserFollowedMeetingInWeekUseCase;
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
@WebServlet(name = "getNumOfUserFollowedMeetingInWeek", urlPatterns = {"/api/meeting-management/statistics/user-followed-meetings"})
public class GetNumOfUserFollowedMeetingInWeekServlet extends BaseHttpServlet {
    @Inject
    GetNumOfUserFollowedMeetingInWeekUseCase getNumOfUserFollowedMeetingInWeekUseCase;

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
            getRequestComponent().getResponseHelper().responseMessage(400, "Invalid meeting id");
        }
        GetNumOfUserFollowedMeetingInWeekUseCase.Result result = getNumOfUserFollowedMeetingInWeekUseCase.executes();
        if (result instanceof GetNumOfUserFollowedMeetingInWeekUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetNumOfUserFollowedMeetingInWeekUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}
