package com.devlogs.masa_backend.servlets.filters;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.servlets.common.helpers.UrlHelper;
import com.devlogs.masa_backend.servlets.login.GoogleLoginState;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class AuthFilter implements Filter {

    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        MasaLog.normalLog("Auth Filter Init");
    }

    public void doFilter(ServletRequest r,
                         ServletResponse rs,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) r;
        HttpServletResponse response = (HttpServletResponse) rs;
        request.setCharacterEncoding("UTF-8");
        MasaLog.normalLog("Auth check nha");
        if (Masa.AUTH_MODE.equals("UNCHECK")) {
            MasaLog.warningLog("YOU'RE IN UNCHECK AUTH MODE, IN SECURE");
            chain.doFilter(request, response);
            return;
        }
        Masa.onServerName(request.getProtocol(),request.getServerName(),request.getServerPort());

        if (request.getSession(true).getAttribute(Masa.SESSION_KEY.USER) != null) {
            chain.doFilter(request, response);
            return;
        }

        Cookie[] cookies = request.getCookies();
        String googleAccessToken = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("GOOGLE_ACCESS_TOKEN")) {
                    googleAccessToken = cookie.getValue();
                    break;
                }
            }
        }

        String resource = UrlHelper.getResourceUrl(request.getRequestURI());
        if (resource.contains("login")) {
            chain.doFilter(request, response);
            return;
        }
        GoogleLoginState ggState = new GoogleLoginState(resource);
        String resourceInJson = new Gson().toJson(ggState);
        MasaLog.normalLog("Request resource in json: " + resourceInJson);
        String encodedResource = Base64.getEncoder().encodeToString(resourceInJson.getBytes());
        MasaLog.normalLog("EncodedResource" + encodedResource);

        if (googleAccessToken.isEmpty()) {
            if (resource.isEmpty()) {
                MasaLog.normalLog("NO ACCESS_TOKEN GO MAIN PAGE, ALLOWED");
                // means user want to go to main page => allowed even user don't have google_access token
                chain.doFilter(request, response);
                return;
            }
            // if user want to access but don't have google_token => forward to google login page => forward to resource
            if (resource.contains("api")) {
                // that's mean user access it as api => return 500 code
                response.setStatus(500);
                response.getWriter().println("UnAuthorized");
            } else {
                String googleProcessLogin = "http://localhost:"+request.getServerPort()+"/masa/logingoogle";
                MasaLog.normalLog("Google redirect url: "+ googleProcessLogin);
            String loginWithGoogleUrl = String.format(
                    "https://accounts.google.com/o/oauth2/auth?" +
                    "response_type=code" +
                    "&client_id=%s" +
                    "&redirect_uri=%s" +
                    "&scope=email profile" +
                    "&prompt=consent"+
                    "&access_type=offline"+
                    "&state=%s",Masa.CLIENT_ID, googleProcessLogin, encodedResource);
            MasaLog.normalLog("NO ACCESS_TOKEN GO RESOURCE PAGE, NOT ALLOWED => GOOGLE LOGIN API: " + loginWithGoogleUrl);
            response.sendRedirect(loginWithGoogleUrl);
            return;
            }
        } else {
            String loginServlet = "/login";
            MasaLog.normalLog("HAVE ACCESS_TOKEN GO RESOURCE PAGE, ALLOWED => LOGIN SERVLET");
            // if user have google_access_token => forward to resource
            request.setAttribute("access_token", googleAccessToken);
            request.setAttribute("state", encodedResource);
            request.getRequestDispatcher(loginServlet).forward(request, response);
            return;
        }
    }
}
