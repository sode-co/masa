package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetMeetingsByMultipleTopicsUseCase;
import com.devlogs.masa_backend.meeting.GetMeetingsByTopicUseCase;
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
@WebServlet(name = "getmeetingbymultipletopic", urlPatterns = {"/api/meeting-management/topics/meetings"})
public class GetMeetingsByMultipleTopicsServlet extends BaseHttpServlet {

    @Inject
    protected GetMeetingsByMultipleTopicsUseCase getMeetingsByMultipleTopicsUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req,resp);
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseHelper responseHelper = getRequestComponent().getResponseHelper();
        RequestHelper requestHelper = getRequestComponent().getRequestHelper();

        RequestHelper.ValidateResult<GetMeetingsByMultipleTopicsReqBody> validateResult = requestHelper.getRequestBody(GetMeetingsByMultipleTopicsReqBody.class);

        if (!validateResult.isValid()) {
            responseHelper.responseMessage(500, "invalid topicId");
        }

        GetMeetingsByMultipleTopicsUseCase.Result result = getMeetingsByMultipleTopicsUseCase.executes(validateResult.getValidReqBody().topicIds);
        if (result instanceof GetMeetingsByMultipleTopicsUseCase.Result.ConnectionError) {
            responseHelper.responseMessage(500, "Connection to db error");
        } else if (result instanceof GetMeetingsByMultipleTopicsUseCase.Result.TopicDoesNotExist) {
            responseHelper.responseMessage(404, "Topic id not found");
        }
        else if ( result instanceof GetMeetingsByMultipleTopicsUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            responseHelper.responseJsonOk(json);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doProcess(req,resp);
    }
}
