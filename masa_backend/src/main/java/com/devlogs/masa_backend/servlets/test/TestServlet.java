package com.devlogs.masa_backend.servlets.test;

import com.devlogs.masa_backend.become_mentor.SendRequestToBecomeMentorUseCase;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.remote_database.UserDao;
import com.devlogs.masa_backend.repository.user.UserRepositoryImp;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet", urlPatterns = "/TestServlet")
public class TestServlet extends BaseHttpServlet {
    @Inject
    public UserRepositoryImp imp;
    @Inject
    public SendRequestToBecomeMentorUseCase sendRequestToBecomeMentor;
    @Inject
    UserDao dao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getControllerComponent().inject(this);
        SendRequestToBecomeMentorUseCase.Result result = sendRequestToBecomeMentor.executes("GU100008", "Heloo description ne", "https://www.us05web.zoom.us/j/83708124951?pwd=MWhKNC9KWlZMa21kaTBEMXR0dGdpdz09", "https://www.meet.google.com/jsg-rqjg-ybi");
        MasaLog.normalLog("Send request result: " + result.getClass().getSimpleName());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
