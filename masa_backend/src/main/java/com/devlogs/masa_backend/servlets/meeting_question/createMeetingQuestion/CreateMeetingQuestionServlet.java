package com.devlogs.masa_backend.servlets.meeting_question.createMeetingQuestion;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.MeetingPlatform;
import com.devlogs.masa_backend.meeting.CreateMeetingUseCase;
import com.devlogs.masa_backend.meeting_question.CreateQuestionUseCase;
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
import java.util.Set;
import java.util.stream.Collectors;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.*;

@AccessRole(roles = {ADMIN, MENTOR,STUDENT})
@WebServlet(name = "createmeetingquestion", urlPatterns = {"/api/meeting_question/create"})
public class CreateMeetingQuestionServlet extends BaseHttpServlet {
    @Inject
    public CreateQuestionUseCase createQuestionUseCase;
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
        CreateMeetingQuestionReq reqBody = null;
        if (requestData != null && !requestData.isEmpty()) {
            try{
                reqBody = getMeetingQuestionReqBodyFromReqBody(requestData);
            } catch (JsonSyntaxException ex) {
                getRequestComponent().getResponseHelper().responseMessage(400,ex.getMessage());
                return;
            }
        }
        Set<ConstraintViolation<CreateMeetingQuestionReq>> violations = validator.validate(reqBody);
        String invalidMessage = "";
        for (ConstraintViolation<CreateMeetingQuestionReq> violation : violations) {
            invalidMessage += violation.getMessage() + ", \n";
        }
        if (invalidMessage.isEmpty()) {
            MasaLog.normalLog("Start create metting question");
            createMeetingQuestion(reqBody,resp);
        } else {
            MasaLog.normalLog("Violation req: " + invalidMessage);
            getRequestComponent().getResponseHelper().responseMessage(400,invalidMessage);
            return;
        }
    }

    private CreateMeetingQuestionReq getMeetingQuestionReqBodyFromReqBody(String requestData) throws JsonSyntaxException {
        return  new Gson().fromJson(requestData, CreateMeetingQuestionReq.class);
    }

    private void createMeetingQuestion(CreateMeetingQuestionReq reqBody, HttpServletResponse resp) throws IOException {
        CreateQuestionUseCase.Result result = createQuestionUseCase.executes(reqBody.getTitle(), reqBody.getUserId(),reqBody.getMeetingId());

        if (result instanceof CreateQuestionUseCase.Result.Success) {
            String resultJson = new Gson().toJson(result);
            MasaLog.normalLog("Created meeting question: " + ((CreateQuestionUseCase.Result.Success) result).meetingQuestion.getId());
            getRequestComponent().getResponseHelper().responseJsonOk(resultJson);
        } else if (result instanceof CreateQuestionUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Internal server error, can not connect to db");
            return;
        } else if (result instanceof CreateQuestionUseCase.Result.UserNotFoundError) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Your user id doesn't exist");
            return;
        } else if (result instanceof CreateQuestionUseCase.Result.MeetingNotFoundError) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Your meeting id doesn't exist");
            return;
        }
    }
}
