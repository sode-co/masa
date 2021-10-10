package com.devlogs.masa_backend.servlets.meeting.getmeeting;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.meeting.GetMeetingsByMultipleTopicsNameUseCase;
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

@AccessRole(roles = {ADMIN, MENTOR, STUDENT})
@WebServlet(name = "getmeetingbytopicname", urlPatterns = {"/api/meeting-management/topic-name/meetings"})
public class GetMeetingsByTopicNameServlet extends BaseHttpServlet {

    @Inject
    protected GetMeetingsByMultipleTopicsNameUseCase getMeetingsByMultipleTopicsNameUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseHelper responseHelper = getRequestComponent().getResponseHelper();
        RequestHelper requestHelper = getRequestComponent().getRequestHelper();

        RequestHelper.ValidateResult<GetMeetingsByTopicNameReqBody> validateResult = requestHelper.getRequestBody(GetMeetingsByTopicNameReqBody.class);

        if (!validateResult.isValid()) {
            responseHelper.responseMessage(500, validateResult.getFailMessage());
        }

        GetMeetingsByMultipleTopicsNameUseCase.Result result = getMeetingsByMultipleTopicsNameUseCase.executes(validateResult.getValidReqBody().topicName);
        if (result instanceof GetMeetingsByMultipleTopicsNameUseCase.Result.ConnectionError) {
            responseHelper.responseMessage(500, "Connection to db error");
        } else if (result instanceof GetMeetingsByMultipleTopicsNameUseCase.Result.TopicDoesNotExist) {
            responseHelper.responseMessage(404, "Topic name not found: " + ((GetMeetingsByMultipleTopicsNameUseCase.Result.TopicDoesNotExist) result).name );
        }
        else if ( result instanceof GetMeetingsByMultipleTopicsNameUseCase.Result.Success) {
            String json = new Gson().toJson(result);
            responseHelper.responseJsonOk(json);
        }
    }
}
