package com.devlogs.masa_backend.servlets.login;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.common.DbHelper;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.login.LoginWithGoogleUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import static com.devlogs.masa_backend.common.Masa.PAGE;
import static com.devlogs.masa_backend.common.Masa.SESSION_KEY.USER;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;
    @Inject
    public LoginWithGoogleUseCase loginWithGoogleUseCase;

    private UserEntity processLoginResult (HttpServletResponse response, HttpServletRequest request, LoginWithGoogleUseCase.Result result) throws IOException {
        PrintWriter out = response.getWriter();
        if (result instanceof LoginWithGoogleUseCase.Result.Success) {
            return ((LoginWithGoogleUseCase.Result.Success) result).user;
        } else if (result instanceof LoginWithGoogleUseCase.Result.NotAllowed) {
            response.setStatus(400);
            out.print("Not allowed");
            out.flush();
        } else if (result instanceof LoginWithGoogleUseCase.Result.GeneralError) {
            response.setStatus(500);
            out.print("General error: " + ((LoginWithGoogleUseCase.Result.GeneralError) result).message);
            out.flush();
        }
        return null;
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

    @Override
    public void init() throws ServletException {
        super.init();
        MasaLog.normalLog("Google auth Init");
        getControllerComponent().inject(this);
    }
    @Inject
    protected DbHelper dbHelper;

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MasaLog.normalLog("hellooo");
        String googleAccessToken = (String) request.getAttribute("access_token");

        if (googleAccessToken == null || googleAccessToken.isEmpty()) {
            response.setStatus(500);
            response.getWriter().println("Access token required");
        }

        String stateParam = (String) request.getAttribute("state");
        String redirectUrl = "";
        if (stateParam != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(stateParam);
            String jsonState = new String(decodedBytes);
            GoogleLoginState state = new Gson().fromJson(jsonState, GoogleLoginState.class);
            redirectUrl = state.getRedirectUrl();
        }
        MasaLog.normalLog("ggredirectUrl: " + redirectUrl);

        LoginWithGoogleUseCase.Result result = loginWithGoogleUseCase.executes(googleAccessToken);
        UserEntity user = processLoginResult(response, request,result);
        request.getSession(true).setAttribute(USER, user);
        if (user != null) {
            Cookie ggCookie = new Cookie(Masa.COOKIE.GOOGLE_ACCESS_TOKEN, googleAccessToken);
            response.addCookie(ggCookie);
            MasaLog.normalLog("ggredirectUrl: " + redirectUrl);
            if (redirectUrl != null && !redirectUrl.isEmpty()) {
                if (redirectUrl.contains("api")) {
                    MasaLog.normalLog("ggredirectUrl: " + redirectUrl);
                    request.getRequestDispatcher("/" + redirectUrl).forward(request, response);
                    return;
                } else {
                    MasaLog.normalLog("ggredirectUrl: " + redirectUrl);
                    response.sendRedirect(redirectUrl);
                    return;
                }
            }
            navigateByUserRole(user.getRole(), response);
        } else {
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doProcess(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request,response);
    }

}
