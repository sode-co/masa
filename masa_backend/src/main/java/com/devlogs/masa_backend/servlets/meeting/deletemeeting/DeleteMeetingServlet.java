package com.devlogs.masa_backend.servlets.meeting.deletemeeting;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.meeting.UpdateMeetingStatusUseCase;
import com.devlogs.masa_backend.meeting.UpdateMeetingUseCaseSync;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.devlogs.masa_backend.servlets.meeting.updatemeeting.UpdateMeetingReq;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.MENTOR;

@AccessRole(roles = {MENTOR})
@WebServlet(name = "delete-meeting", urlPatterns = {"/api/meeting/delete", "/api/meeting-management/delete"})
public class DeleteMeetingServlet extends BaseHttpServlet {
    @Inject
    public UpdateMeetingStatusUseCase updateMeetingStatusUseCase;
    @Inject
    public Validator validator;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining());
        DeleteMeetingReq reqBody = null;
        if (requestData != null && !requestData.isEmpty()) {
            try{
                reqBody = getMeetingReqBodyFromReqBody(requestData);
            } catch (JsonSyntaxException ex) {
                getRequestComponent().getResponseHelper().responseMessage(400, ex.getMessage());
                return;
            }
        }
        Set<ConstraintViolation<DeleteMeetingReq>> violations = validator.validate(reqBody);
        String invalidMessage = "";
        for (ConstraintViolation<DeleteMeetingReq> violation : violations) {
            invalidMessage += violation.getMessage() + ", \n";
        }
        if (invalidMessage.isEmpty()) {
            deleteMeeting(reqBody,resp);
        } else {
            MasaLog.normalLog("Violation req: " + invalidMessage);
            getRequestComponent().getResponseHelper().responseMessage(400, invalidMessage);
            return;
        }
    }

    private DeleteMeetingReq getMeetingReqBodyFromReqBody(String requestData) throws JsonSyntaxException {
        return  new Gson().fromJson(requestData, DeleteMeetingReq.class);
    }

    private void deleteMeeting(DeleteMeetingReq reqBody, HttpServletResponse resp) throws IOException {
        UpdateMeetingStatusUseCase.Result result = updateMeetingStatusUseCase.executes(reqBody.getId());

        if (result instanceof UpdateMeetingStatusUseCase.Result.Success) {
            resp.setStatus(200);
            String resultJson = new Gson().toJson(result);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            getRequestComponent().getResponseHelper().responseJsonOk(resultJson);
            return;
        } else if (result instanceof UpdateMeetingStatusUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Internal server error, can not connect to db");
            return;
        } else if (result instanceof UpdateMeetingStatusUseCase.Result.MeetingDoesNotExist) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Meeting does not exist");
            return;
        }
    }
}
