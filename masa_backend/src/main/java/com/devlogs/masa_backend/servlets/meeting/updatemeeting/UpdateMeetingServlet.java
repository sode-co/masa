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
import java.io.PrintWriter;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "update-meeting", urlPatterns = "/api/meeting/update")
public class UpdateMeetingServlet extends BaseHttpServlet {
    @Inject
    public UpdateMeetingUseCaseSync updateMeetingUseCase;
    @Inject
    public Validator validator;
    private PrintWriter out;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        getControllerComponent().inject(this);
        out = resp.getWriter();
        String requestData = req.getReader().lines().collect(Collectors.joining());
        UpdateMeetingReq reqBody = null;
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
        Set<ConstraintViolation<UpdateMeetingReq>> violations = validator.validate(reqBody);
        String invalidMessage = "";
        for (ConstraintViolation<UpdateMeetingReq> violation : violations) {
            invalidMessage += violation.getMessage() + ", \n";
        }
        if (invalidMessage.isEmpty()) {
            updateMeeting(reqBody,resp);
        } else {
            resp.setStatus(400);
            MasaLog.normalLog("Violation req: " + invalidMessage);
            out.print(invalidMessage);
            out.flush();
            return;
        }
    }

    private UpdateMeetingReq getMeetingReqBodyFromReqBody(String requestData) throws JsonSyntaxException {
           return  new Gson().fromJson(requestData, UpdateMeetingReq.class);
    }

    private UpdateMeetingReq getMeetingReqBodyFromReqParam (HttpServletRequest req) {
        Long startTime = Long.parseLong(req.getParameter("startTime"));
        Long endTime = Long.parseLong(req.getParameter("endTime"));
        return new UpdateMeetingReq(
                req.getParameter("title"),
                req.getParameter("platform"),
                req.getParameter("platformUrl"),
                req.getParameter("host"),
                startTime,
                endTime,
                req.getParameter("description"));
    }

    private void updateMeeting(UpdateMeetingReq reqBody, HttpServletResponse resp) throws IOException {
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
        UpdateMeetingUseCaseSync.Result result = updateMeetingUseCase.executes(reqBody.getId(),reqBody.getTitle(), meetingPlatform, reqBody.getStartTime(), reqBody.getEndTime(), reqBody.getDescription());

        if (result instanceof UpdateMeetingUseCaseSync.Result.Success) {
            resp.setStatus(200);
            String resultJson = new Gson().toJson(((UpdateMeetingUseCaseSync.Result.Success) result).createdMeeting);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(resultJson);
            out.flush();
            return;
        } else if (result instanceof UpdateMeetingUseCaseSync.Result.ConnectionError) {
            resp.setStatus(500);
            out.print("Internal server error, can not connect to db");
            out.flush();
            return;
        } else if (result instanceof UpdateMeetingUseCaseSync.Result.MeetingDoesNotExist) {
            resp.setStatus(500);
            out.print("Meeting does not exist");
            out.flush();
            return;
        }
    }
}
