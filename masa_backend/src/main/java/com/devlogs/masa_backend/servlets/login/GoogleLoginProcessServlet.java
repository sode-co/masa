package com.devlogs.masa_backend.servlets.login;

import com.devlogs.masa_backend.login.LoginWithGoogleUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logingoogle", urlPatterns = "/logingoogle")
public class GoogleLoginProcessServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    public LoginWithGoogleUseCase loginWithGoogleUseCase;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            getControllerComponent().inject(this);
            LoginWithGoogleUseCase.Result result = loginWithGoogleUseCase.executes(request.getParameter("code"));
            PrintWriter out = response.getWriter();
            if (result instanceof LoginWithGoogleUseCase.Result.Success) {
                out.println("Login success" + ((LoginWithGoogleUseCase.Result.Success) result).user.toString());
            } else if (result instanceof LoginWithGoogleUseCase.Result.NotAllowed) {
                out.print("Not allowed");
            } else if (result instanceof LoginWithGoogleUseCase.Result.GeneralError) {
                out.print("General error: " + ((LoginWithGoogleUseCase.Result.GeneralError) result).message);
            }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
