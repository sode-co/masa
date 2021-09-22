package com.devlogs.masa_backend.servlets.login;

import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.common.DbHelper;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.login.LoginWithGoogleUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;

import static com.devlogs.masa_backend.common.Masa.*;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static com.devlogs.masa_backend.common.Masa.SESSION_KEY.*;
import java.util.Base64;

@WebServlet(name = "logingoogle", urlPatterns = "/logingoogle")
public class GoogleLoginProcessServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;

    public GoogleLoginProcessServlet () {
        super();
        MasaLog.normalLog("Login with google");
    }

    @Inject
    public LoginWithGoogleUseCase loginWithGoogleUseCase;

    private UserEntity processLoginResult (HttpServletResponse response, HttpServletRequest request, LoginWithGoogleUseCase.Result result) throws IOException {
        PrintWriter out = response.getWriter();
        if (result instanceof LoginWithGoogleUseCase.Result.Success) {
            return ((LoginWithGoogleUseCase.Result.Success) result).user;
        } else if (result instanceof LoginWithGoogleUseCase.Result.NotAllowed) {
            out.print("Not allowed");
        } else if (result instanceof LoginWithGoogleUseCase.Result.GeneralError) {
            out.print("General error: " + ((LoginWithGoogleUseCase.Result.GeneralError) result).message);
        }
        return null;
    }

    private void navigateByUserRole (UserRole userRole, HttpServletResponse response, String sendRedirectUrl) throws IOException {
        if (sendRedirectUrl != null && !sendRedirectUrl.isEmpty()) {
          response.sendRedirect(sendRedirectUrl);
        } else switch (userRole.getType()) {
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
        String stateParam = request.getParameter("state");
        String redirectUrl = "";
        if (stateParam != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(stateParam);
            String jsonState = new String(decodedBytes);
            GoogleLoginState state = new Gson().fromJson(jsonState, GoogleLoginState.class);
            redirectUrl = state.getRedirectUrl();
        }
        MasaLog.normalLog("ggredirectUrl: " + redirectUrl);
        LoginWithGoogleUseCase.Result result = loginWithGoogleUseCase.executes(request.getParameter("code"));
        UserEntity user = processLoginResult(response, request,result);
        request.getSession(true).setAttribute(USER, user);
        if (user != null) {
            navigateByUserRole(user.getRole(), response, redirectUrl);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
