package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.domain.entities.MeetingEntity;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.meeting.GetMeetingByHostUseCase;
import com.devlogs.masa_backend.meeting.GetMeetingByIdUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.devlogs.masa_backend.servlets.meeting.common.GetMeetingResponse;
import com.devlogs.masa_backend.user.GetUserByIdUseCase;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.*;

@AccessRole(roles = {ADMIN, MENTOR, STUDENT})
@WebServlet(name = "getmeetingbyid", urlPatterns = {"/api/meeting-management/meeting/*"})
public class GetMeetingByIdServlet extends BaseHttpServlet {

    @Inject
    protected GetMeetingByIdUseCase getMeetingByIdUseCase;
    @Inject
    protected GetUserByIdUseCase getUserByIdUseCase;
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
        }
        if (result instanceof GetMeetingByIdUseCase.Result.NotFound) {
            getRequestComponent().getResponseHelper().responseMessage(404, "Meeting not found");
        }
        else if ( result instanceof GetMeetingByIdUseCase.Result.Success) {
            GetUserByIdUseCase.Result getUserResult = getUserByIdUseCase.executes(((GetMeetingByIdUseCase.Result.Success) result).meeting.getHostId());
            if (getUserResult instanceof GetUserByIdUseCase.Result.Success) {
                MeetingEntity meeting = ((GetMeetingByIdUseCase.Result.Success) result).meeting;
                UserEntity host = ((GetUserByIdUseCase.Result.Success) getUserResult).getUser();
                GetMeetingResponse.Data responseData = new GetMeetingResponse.Data(meeting.getId(),meeting.getTitle(),meeting.getPlatform(), meeting.getTopic(), host, meeting.getStartTime(), meeting.getEndTime(), meeting.getDescription());
                String json = new Gson().toJson(responseData);
                getRequestComponent().getResponseHelper().responseJsonOk(json);
            } else {
                getRequestComponent().getResponseHelper().responseMessage(404, "Host not found");
            }

        }
    }
}
