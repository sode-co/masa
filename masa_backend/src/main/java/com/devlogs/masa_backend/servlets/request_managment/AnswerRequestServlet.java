package com.devlogs.masa_backend.servlets.request_managment;

import com.devlogs.masa_backend.become_mentor.AnswerBecomeMentorRequestUseCaseSync;
import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.domain.entities.RequestEntity;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.ADMIN;

@AccessRole(roles = {ADMIN})
public class AnswerRequestServlet extends BaseHttpServlet {

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

        if (btAnswer.equalsIgnoreCase("Accept")) {
            answerBecomeMentorRequestUseCaseSync.executes(requestId,userId, RequestEntity.STATUS.APPROVED);
        } else if (btAnswer.equalsIgnoreCase("Denied")) {
            answerBecomeMentorRequestUseCaseSync.executes(requestId,userId, RequestEntity.STATUS.DENIED);
        }
    }
}
