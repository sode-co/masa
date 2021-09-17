package com.devlogs.masa_backend.servlets.meeting.updatemeeting;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform.PLATFORM;
import com.devlogs.masa_backend.meeting.CreateMeetingUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.devlogs.masa_backend.servlets.meeting.createmeeting.CreateMeetingReq;
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

@WebServlet(name = "create-meeting", urlPatterns = "/api/meeting/create")
public class UpdateMeetingServlet extends BaseHttpServlet {
    @Inject
    public CreateMeetingUseCase createMeetingUseCase;
    @Inject
    public Validator validator;
    private PrintWriter out;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        getControllerComponent().inject(this);
        out = resp.getWriter();
        String requestData = req.getReader().lines().collect(Collectors.joining());
        CreateMeetingReq reqBody = null;
        if (requestData != null && !requestData.isEmpty()) {
            try{
                reqBody = getMeetingReqBodyFromReqBody(requestData);
            } catch (JsonSyntaxException ex) {
                resp.setStatus(400);
                out.print(ex.getMessage());
                out.flush();
                return;
            }
        } else {
            try {
                reqBody = getMeetingReqBodyFromReqParam(req);
            } catch (NumberFormatException ex) {
                resp.setStatus(400 );
                out.print(ex.getMessage());
                out.flush();
                return;
            }
        }
        Set<ConstraintViolation<CreateMeetingReq>> violations = validator.validate(reqBody);
        String invalidMessage = "";
        if (!reqBody.isUrlMatchPlatform()) {
            resp.setStatus(400);
            out.print("Your url is not belong to this platform");
            out.flush();
            return;
        }
        for (ConstraintViolation<CreateMeetingReq> violation : violations) {
            invalidMessage += violation.getMessage() + ", \n";
        }
        if (invalidMessage.isEmpty()) {
            createMeeting(reqBody,resp);
        } else {
            resp.setStatus(400);
            MasaLog.normalLog("Violation req: " + invalidMessage);
            out.print(invalidMessage);
            out.flush();
            return;
        }
    }

    private CreateMeetingReq getMeetingReqBodyFromReqBody(String requestData) throws JsonSyntaxException {
           return  new Gson().fromJson(requestData, CreateMeetingReq.class);
    }

    private CreateMeetingReq getMeetingReqBodyFromReqParam (HttpServletRequest req) {
        Long startTime = Long.parseLong(req.getParameter("startTime"));
        Long endTime = Long.parseLong(req.getParameter("endTime"));
        return new CreateMeetingReq(
                req.getParameter("title"),
                req.getParameter("platform"),
                req.getParameter("platformUrl"),
                req.getParameter("host"),
                startTime,
                endTime,
                req.getParameter("description"));
    }

    private void createMeeting(CreateMeetingReq reqBody, HttpServletResponse resp) throws IOException {
        PLATFORM meetingPlatform;
        if (reqBody.getPlatform().equalsIgnoreCase("ZOOM")) {
            meetingPlatform = PLATFORM.ZOOM;
        } else if (reqBody.getPlatform().equalsIgnoreCase("GOOGLE_MEET")) {
            meetingPlatform = PLATFORM.GOOGLE_MEET;
        } else {
            resp.setStatus(400);
            out.print("Invalid meeting platform");
            out.flush();
            return;
        }
        CreateMeetingUseCase.Result result = createMeetingUseCase.executes(reqBody.getTitle(), meetingPlatform, reqBody.getHost(), reqBody.getStartTime(), reqBody.getEndTime(), reqBody.getDescription());

        if (result instanceof CreateMeetingUseCase.Result.Success) {
            resp.setStatus(200);
            String resultJson = new Gson().toJson(((CreateMeetingUseCase.Result.Success) result).createdMeeting);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(resultJson);
            out.flush();
        } else if (result instanceof CreateMeetingUseCase.Result.ConnectionError) {
            resp.setStatus(500);
            out.print("Internal server error, can not connect to db");
            out.flush();
            return;
        } else if (result instanceof CreateMeetingUseCase.Result.HostDoesNotExist) {
            resp.setStatus(500);
            out.print("Your host id doesn't exist");
            out.flush();
            return;
        }
    }
}
