package com.devlogs.auth_server.servlets.login_by_email;

import com.devlogs.auth_server.data.common.DbHelper;
import com.devlogs.auth_server.servlets.common.base.BaseHttpServlet;

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

        try {
            req.getServletContext().log("Connecting to db: " + dbHelper.DB_URL);
            dbHelper.connect();
            resp.getWriter().println("Oh lala");
            req.getServletContext().log("Connected to db: ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
