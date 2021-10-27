package com.devlogs.masa_backend.servlets.meeting.statisticize;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetNumOfActiveMeetingsUseCase;
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
@WebServlet(name = "getNumOfActiveMeetings", urlPatterns = {"/api/meeting-statistics/active-meetings"})
public class GetNumOfActiveMeetingsServlet extends BaseHttpServlet {
    @Inject
    GetNumOfActiveMeetingsUseCase getNumOfActiveMeetingsUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetNumOfActiveMeetingsUseCase.Result result = getNumOfActiveMeetingsUseCase.executes();
        if (result instanceof GetNumOfActiveMeetingsUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetNumOfActiveMeetingsUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}
