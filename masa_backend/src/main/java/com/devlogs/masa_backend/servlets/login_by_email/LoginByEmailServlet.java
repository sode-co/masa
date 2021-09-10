package com.devlogs.masa_backend.servlets.login_by_email;

import com.devlogs.masa_backend.data.common.DbHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginByEmail", urlPatterns = "/loginByEmail")
public class LoginByEmailServlet extends BaseHttpServlet {
    @Inject
    public DbHelper dbHelper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getControllerComponent().inject(this);

//            req.getServletContext().log("Connecting to db: " + dbHelper.DB_URL);
//            dbHelper.connect();
            resp.getWriter().println("Oh lala2");
            req.getServletContext().log("Connected to db: ");
    }
}
