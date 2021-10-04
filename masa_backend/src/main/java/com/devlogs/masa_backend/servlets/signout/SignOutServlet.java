package com.devlogs.masa_backend.servlets.signout;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "signoutservlet", urlPatterns = {"/auth-management/signout"})
public class SignOutServlet extends BaseHttpServlet {

    private void doProcess (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cookie cookie1 = new Cookie(Masa.COOKIE.GOOGLE_ACCESS_TOKEN, "");
        cookie1.setMaxAge(0);
        cookie1.setPath("/");
        Cookie cookie2 = new Cookie("JSESSIONID", "");
        cookie2.setMaxAge(0);
        cookie2.setPath("/");
        resp.addCookie(cookie2);
        resp.addCookie(cookie1);
        session.removeAttribute(Masa.SESSION_KEY.USER);
        resp.sendRedirect("/masa");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }
}
