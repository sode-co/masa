package com.devlogs.masa_backend.servlets.meeting_question.getMeetingQuestion;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetMeetingByHostUseCase;
import com.devlogs.masa_backend.meeting_question.GetAllQuestionsByMeetingIdUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.*;

@AccessRole(roles = {ADMIN, MENTOR})
@WebServlet(name = "getmeetingquestionbymeetingid", urlPatterns = {"/api/meeting_question/questions/*"})
public class GetAllMeetingQuestionByMeetingIdServlet extends BaseHttpServlet {
    @Inject
    protected GetAllQuestionsByMeetingIdUseCase getAllQuestionsByMeetingIdUseCase;

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
        GetAllQuestionsByMeetingIdUseCase.Result result = getAllQuestionsByMeetingIdUseCase.executes(meetingId);
        if (result instanceof GetAllQuestionsByMeetingIdUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Connection to db error");
        } else if ( result instanceof GetAllQuestionsByMeetingIdUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            getRequestComponent().getResponseHelper().responseJsonOk(json);
        }
    }
}

