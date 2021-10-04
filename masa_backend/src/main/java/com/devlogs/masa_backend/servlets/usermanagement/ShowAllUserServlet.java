package com.devlogs.masa_backend.servlets.usermanagement;


import com.devlogs.masa_backend.common.helper.MasaLog;

import com.devlogs.masa_backend.manage.GetAllUserUserCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.google.gson.Gson;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ShowAllUserServlet", urlPatterns = "/api/user-management/all")
public class ShowAllUserServlet extends BaseHttpServlet {

    @Inject
    protected GetAllUserUserCase getAllUserUserCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseHelper responseHelper = this.getRequestComponent().getResponseHelper();

        GetAllUserUserCase.Result result = getAllUserUserCase.executes();

        if (result instanceof GetAllUserUserCase.Result.Success) {
            responseHelper.responseJsonOk(new Gson().toJson(result));

        } else
            responseHelper.responseMessage(400,"No user is existed!!!" );

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // doGet(req, resp);
    }
}
