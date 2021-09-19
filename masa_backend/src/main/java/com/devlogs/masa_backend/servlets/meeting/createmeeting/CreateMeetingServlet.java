package com.devlogs.masa_backend.servlets.meeting.createmeeting;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform.PLATFORM;
import com.devlogs.masa_backend.meeting.CreateMeetingUseCase;
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
import java.io.PrintWriter;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "create-meeting", urlPatterns = {"/api/meeting/create", "/api/meeting-management/create"})
public class CreateMeetingServlet extends BaseHttpServlet {
    @Inject
    public CreateMeetingUseCase createMeetingUseCase;
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
        CreateMeetingReq reqBody = null;
        if (requestData != null && !requestData.isEmpty()) {
            try{
                reqBody = getMeetingReqBodyFromReqBody(requestData);
            } catch (JsonSyntaxException ex) {
                getRequestComponent().getResponseHelper().responseMessage(400,ex.getMessage());
                return;
            }
        }
        Set<ConstraintViolation<CreateMeetingReq>> violations = validator.validate(reqBody);
        String invalidMessage = "";
        for (ConstraintViolation<CreateMeetingReq> violation : violations) {
            invalidMessage += violation.getMessage() + ", \n";
        }
        if (invalidMessage.isEmpty()) {
            MasaLog.normalLog("Start create metting");
            createMeeting(reqBody,resp);
        } else {
            MasaLog.normalLog("Violation req: " + invalidMessage);
            getRequestComponent().getResponseHelper().responseMessage(400,invalidMessage);
            return;
        }
    }

    private CreateMeetingReq getMeetingReqBodyFromReqBody(String requestData) throws JsonSyntaxException {
           return  new Gson().fromJson(requestData, CreateMeetingReq.class);
    }

    private void createMeeting(CreateMeetingReq reqBody, HttpServletResponse resp) throws IOException {
        PLATFORM meetingPlatform;
        if (reqBody.getPlatform().equalsIgnoreCase("ZOOM")) {
            meetingPlatform = PLATFORM.ZOOM;
        } else if (reqBody.getPlatform().equalsIgnoreCase("GOOGLE_MEET")) {
            meetingPlatform = PLATFORM.GOOGLE_MEET;
        } else {
            getRequestComponent().getResponseHelper().responseMessage(400, "Invalid meeting platform");
            return;
        }
        MasaLog.normalLog("Meeting title: " + reqBody.getTitle());
        CreateMeetingUseCase.Result result = createMeetingUseCase.executes(reqBody.getTitle(), meetingPlatform, reqBody.getHost(), reqBody.getStartTime(), reqBody.getEndTime(), reqBody.getDescription());

        if (result instanceof CreateMeetingUseCase.Result.Success) {
            String resultJson = new Gson().toJson(result);
            MasaLog.normalLog("Created meeting: " + ((CreateMeetingUseCase.Result.Success) result).createdMeeting.getId());
            getRequestComponent().getResponseHelper().responseJsonOk(resultJson);
        } else if (result instanceof CreateMeetingUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Internal server error, can not connect to db");
            return;
        } else if (result instanceof CreateMeetingUseCase.Result.HostDoesNotExist) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Your host id doesn't exist");
            return;
        } else if (result instanceof CreateMeetingUseCase.Result.NotMentorError) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Only mentor can create meeting");
            return;
        }
    }
}
