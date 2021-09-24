package com.devlogs.masa_backend.servlets.login;

import com.devlogs.masa_backend.api.google.GetGoogleAccessToken;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.common.DbHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logingoogle", urlPatterns = "/logingoogle")
public class GoogleLoginProcessServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        MasaLog.normalLog("Google auth Init");
        getControllerComponent().inject(this);
    }
    @Inject
    protected DbHelper dbHelper;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String googleAccessToken = new GetGoogleAccessToken().getToken(request.getParameter("code"))[0];
        String loginServlet = "/login";
        String state = request.getParameter("state");
        if (state != null) {
            request.setAttribute("state", state);
        }
        request.setAttribute("access_token", googleAccessToken);
        request.getRequestDispatcher(loginServlet).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
