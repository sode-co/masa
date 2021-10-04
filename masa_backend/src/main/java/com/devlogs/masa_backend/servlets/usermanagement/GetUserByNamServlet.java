package com.devlogs.masa_backend.servlets.usermanagement;

import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetUserByNamServlet", urlPatterns = "/api/user-management/get-user-by-name/*")
public class GetUserByNamServlet extends BaseHttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
