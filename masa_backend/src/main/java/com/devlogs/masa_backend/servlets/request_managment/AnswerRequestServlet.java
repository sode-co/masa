package com.devlogs.masa_backend.servlets.request_managment;

import com.devlogs.masa_backend.become_mentor.AnswerBecomeMentorRequestUseCaseSync;
import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.ADMIN;

@AccessRole(roles = {ADMIN})
@WebServlet(name = "answer", urlPatterns = "/api/admin/request-management/response")
public class AnswerRequestServlet extends BaseHttpServlet {

    @Inject
    protected AnswerBecomeMentorRequestUseCaseSync answerBecomeMentorRequestUseCaseSync;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestId = req.getParameter("id");
        String btAnswer = req.getParameter("btAnswer");
        String userId = req.getParameter("userId");
        String zoom = req.getParameter("zoom");
        String meet = req.getParameter("meet");

        RequestEntity.STATUS status = null;

        if (btAnswer.equalsIgnoreCase("Accept")) {
            status = RequestEntity.STATUS.APPROVED;
        } else if (btAnswer.equalsIgnoreCase("Denied")) {
            status = RequestEntity.STATUS.DENIED;
        }
        if (status != null) {
            AnswerBecomeMentorRequestUseCaseSync.Result result = answerBecomeMentorRequestUseCaseSync.executes(requestId,zoom, meet,userId, status);

            MasaLog.normalLog("Answer become mentor request result: " + result.getClass().getSimpleName());

            if (result instanceof AnswerBecomeMentorRequestUseCaseSync.Result.Success) {
                getRequestComponent().getResponseHelper().responseMessage(200, status.name());
            } else if (result instanceof AnswerBecomeMentorRequestUseCaseSync.Result.RequestAlreadyAnswered) {
                getRequestComponent().getResponseHelper().responseMessage(200, "Request already answered");
            } else if (result instanceof AnswerBecomeMentorRequestUseCaseSync.Result.UserNotFound) {
                getRequestComponent().getResponseHelper().responseMessage(404, "User not found");
            } else if (result instanceof AnswerBecomeMentorRequestUseCaseSync.Result.RequestNotFound) {
                getRequestComponent().getResponseHelper().responseMessage(404, "Request doesn't exist");
            } else if (result instanceof AnswerBecomeMentorRequestUseCaseSync.Result.GeneralError) {
                getRequestComponent().getResponseHelper().responseMessage(500, "Internal server error");
            } else if (result instanceof AnswerBecomeMentorRequestUseCaseSync.Result.InvalidUserRole) {
                getRequestComponent().getResponseHelper().responseMessage(500, "Invalid user role");
            }

        } else {
            getRequestComponent().getResponseHelper().responseMessage(400, "Bad request");
        }
    }
}
