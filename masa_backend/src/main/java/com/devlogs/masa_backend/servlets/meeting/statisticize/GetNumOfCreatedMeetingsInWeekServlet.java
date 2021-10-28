package com.devlogs.masa_backend.servlets.meeting.statisticize;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetNumOfCreatedMeetingInWeekUseCase;
import com.devlogs.masa_backend.meeting.GetNumOfMeetingInWeekUseCase;
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
@WebServlet(name = "getNumOfCreatedMeetingsInWeek", urlPatterns = {"/api/meeting-statistics/created-meetings-in-week"})
public class GetNumOfCreatedMeetingsInWeekServlet extends BaseHttpServlet {
    @Inject
    GetNumOfCreatedMeetingInWeekUseCase getNumOfCreatedMeetingInWeekUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetNumOfCreatedMeetingInWeekUseCase.Result result = getNumOfCreatedMeetingInWeekUseCase.executes();
        if (result instanceof GetNumOfCreatedMeetingInWeekUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetNumOfCreatedMeetingInWeekUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}
