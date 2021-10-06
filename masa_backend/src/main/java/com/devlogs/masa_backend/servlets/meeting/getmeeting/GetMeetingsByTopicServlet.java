package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetMeetingsByTopicUseCase;
import com.devlogs.masa_backend.meeting.GetNewMeetingsUseCase;
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
import java.util.concurrent.atomic.AtomicInteger;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.*;

@AccessRole(roles = {ADMIN, MENTOR, STUDENT})
@WebServlet(name = "getmeetingbytopicservlet", urlPatterns = {"/api/meeting-management/topic/meetings/*"})
public class GetMeetingsByTopicServlet extends BaseHttpServlet {

    @Inject
    protected GetMeetingsByTopicUseCase getMeetingsByTopicUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseHelper responseHelper = getRequestComponent().getResponseHelper();
        RequestHelper requestHelper = getRequestComponent().getRequestHelper();

        AtomicInteger topicId = new AtomicInteger(-1);
        requestHelper.getTailRequestParam((param) -> {
            try {
                topicId.set(Integer.parseInt(param));
            } catch (NumberFormatException ex) {
                return false;
            }
            return true;
        });

        if (topicId.get() == -1) {
            responseHelper.responseMessage(500, "Your topic id is invalid");
            return;
        }

        GetMeetingsByTopicUseCase.Result result = getMeetingsByTopicUseCase.executes(topicId.get());
        if (result instanceof GetMeetingsByTopicUseCase.Result.ConnectionError) {
            responseHelper.responseMessage(500, "Connection to db error");
        } else if (result instanceof GetMeetingsByTopicUseCase.Result.TopicDoesNotExist) {
            responseHelper.responseMessage(404, "Topic id not found");
        }
        else if ( result instanceof GetMeetingsByTopicUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            responseHelper.responseJsonOk(json);
        }
    }
}
