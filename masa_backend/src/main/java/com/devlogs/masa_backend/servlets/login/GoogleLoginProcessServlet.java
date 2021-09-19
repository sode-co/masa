package com.devlogs.masa_backend.servlets.login;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.login.LoginWithGoogleUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import static com.devlogs.masa_backend.common.Masa.*;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static com.devlogs.masa_backend.common.Masa.SESSION_KEY.*;

@WebServlet(name = "logingoogle", urlPatterns = "/logingoogle")
public class GoogleLoginProcessServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    public LoginWithGoogleUseCase loginWithGoogleUseCase;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            getControllerComponent().inject(this);
            LoginWithGoogleUseCase.Result result = loginWithGoogleUseCase.executes(request.getParameter("code"));
            processLoginResult(response,request, result);
    }

    private void processLoginResult (HttpServletResponse response, HttpServletRequest request, LoginWithGoogleUseCase.Result result) throws IOException {
        PrintWriter out = response.getWriter();
        if (result instanceof LoginWithGoogleUseCase.Result.Success) {
            UserEntity currentUser = ((LoginWithGoogleUseCase.Result.Success) result).user;
            request.getSession(true).setAttribute(USER, currentUser);
            navigateByUserRole(currentUser.getRole(), response);
        } else if (result instanceof LoginWithGoogleUseCase.Result.NotAllowed) {
            out.print("Not allowed");
        } else if (result instanceof LoginWithGoogleUseCase.Result.GeneralError) {
            out.print("General error: " + ((LoginWithGoogleUseCase.Result.GeneralError) result).message);
        }
    }

    private void navigateByUserRole (UserRole userRole, HttpServletResponse response) throws IOException {
        switch (userRole.getType()) {
            case ADMIN: {
                response.sendRedirect(PAGE.ADMIN.USER_MANAGEMENT_PAGE);
                break;
            }
            case STUDENT: {
                response.sendRedirect(PAGE.STUDENT.MEETING_PAGE);
                break;
            }
            case GUEST: {
                response.sendRedirect(PAGE.GUEST.WELCOME);
                break;
            }
            case MENTOR: {
                response.sendRedirect(PAGE.MENTOR.MEETING_PAGE);
                break;
            }
            default: {
                throw new RuntimeException("Invalid user role: " + userRole.getType());
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
