package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import com.devlogs.masa_backend.meeting.GetMeetingByHostUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getmeetingbyhostid", urlPatterns = {"/api/meeting-management/meetings/host/*"})
public class GetMeetingByHostIdServlet extends BaseHttpServlet {

    @Inject
    protected GetMeetingByHostUseCase getMeetingByHostUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        String hostId = url.substring(url.lastIndexOf("/") +1);
        if (hostId.contains("/")) {hostId.replaceAll("/", "");}

        GetMeetingByHostUseCase.Result result = getMeetingByHostUseCase.executes(hostId);
        if (result instanceof GetMeetingByHostUseCase.Result.ConnectionError) {
            resp.setStatus(500);
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetMeetingByHostUseCase.Result.Success) {
            resp.setStatus(200);
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}
