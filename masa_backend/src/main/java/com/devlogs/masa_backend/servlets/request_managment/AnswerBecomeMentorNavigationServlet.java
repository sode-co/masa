package com.devlogs.masa_backend.servlets.request_managment;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.login.LoginWithGoogleUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.devlogs.masa_backend.common.Masa.API.REQUEST.ANSWER_BECOME_MENTOR_REQUEST_NAV;
import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.ADMIN;

@AccessRole(roles = {ADMIN})
@WebServlet(name = "AnswerBecomeMentorNavigationServlet", urlPatterns = "/" + ANSWER_BECOME_MENTOR_REQUEST_NAV + "/*")
public class AnswerBecomeMentorNavigationServlet extends BaseHttpServlet {

    @Inject
    protected LoginWithGoogleUseCase loginWithGoogleUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // check whether user loged in or not

        // if not navigate to google login page

    }
}
