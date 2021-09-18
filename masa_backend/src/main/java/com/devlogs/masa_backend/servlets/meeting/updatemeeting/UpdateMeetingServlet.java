package com.devlogs.masa_backend.servlets.meeting.updatemeeting;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform.PLATFORM;
import com.devlogs.masa_backend.meeting.UpdateMeetingUseCaseSync;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
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

@WebServlet(name = "update-meeting", urlPatterns = {"/api/meeting/update", "/api/meeting-management/update"})
public class UpdateMeetingServlet extends BaseHttpServlet {
    @Inject
    public UpdateMeetingUseCaseSync updateMeetingUseCase;
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
        UpdateMeetingReq reqBody = null;
        if (requestData != null && !requestData.isEmpty()) {
            try{
                reqBody = getMeetingReqBodyFromReqBody(requestData);
            } catch (JsonSyntaxException ex) {
                getRequestComponent().getResponseHelper().responseMessage(400, ex.getMessage());
                return;
            }
        }
        Set<ConstraintViolation<UpdateMeetingReq>> violations = validator.validate(reqBody);
        String invalidMessage = "";
        for (ConstraintViolation<UpdateMeetingReq> violation : violations) {
            invalidMessage += violation.getMessage() + ", \n";
        }
        if (invalidMessage.isEmpty()) {
            updateMeeting(reqBody,resp);
        } else {
            MasaLog.normalLog("Violation req: " + invalidMessage);
            getRequestComponent().getResponseHelper().responseMessage(400, invalidMessage);
            return;
        }
    }

    private UpdateMeetingReq getMeetingReqBodyFromReqBody(String requestData) throws JsonSyntaxException {
           return  new Gson().fromJson(requestData, UpdateMeetingReq.class);
    }

    private void updateMeeting(UpdateMeetingReq reqBody, HttpServletResponse resp) throws IOException {
        PLATFORM meetingPlatform;
        if (reqBody.getPlatform().equalsIgnoreCase("ZOOM")) {
            meetingPlatform = PLATFORM.ZOOM;
        } else if (reqBody.getPlatform().equalsIgnoreCase("GOOGLE_MEET")) {
            meetingPlatform = PLATFORM.GOOGLE_MEET;
        } else {
            getRequestComponent().getResponseHelper().responseMessage(400, "Invalid meeting platform");
            return;
        }
        UpdateMeetingUseCaseSync.Result result = updateMeetingUseCase.executes(reqBody.getId(),reqBody.getTitle(), meetingPlatform, reqBody.getStartTime(), reqBody.getEndTime(), reqBody.getDescription());

        if (result instanceof UpdateMeetingUseCaseSync.Result.Success) {
            resp.setStatus(200);
            String resultJson = new Gson().toJson(result);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            getRequestComponent().getResponseHelper().responseJsonOk(resultJson);
            return;
        } else if (result instanceof UpdateMeetingUseCaseSync.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Internal server error, can not connect to db");
            return;
        } else if (result instanceof UpdateMeetingUseCaseSync.Result.MeetingDoesNotExist) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Meeting does not exist");
            return;
        }
    }
}
