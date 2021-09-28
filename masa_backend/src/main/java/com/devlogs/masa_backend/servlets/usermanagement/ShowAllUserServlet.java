package com.devlogs.masa_backend.servlets.usermanagement;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.data.remote_database.UserDao;
import com.devlogs.masa_backend.data.remote_database.UserDto;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.manage.GetAllUserUserCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import com.devlogs.masa_backend.appointment.FollowMeetingUseCase;
import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.RequestHelper.ValidateResult;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowAllUserServlet", urlPatterns = "/api/user-management/all")
public class ShowAllUserServlet extends BaseHttpServlet {

    @Inject
    protected UserDao dao;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseHelper responseHelper = this.getRequestComponent().getResponseHelper();

        try {
            ArrayList<UserDto> result = (ArrayList<UserDto>) dao.getAllUsers();

            if (result.size() == 0) {
                responseHelper.responseMessage(400,"No user is existed!!!" );
            } else
                responseHelper.responseJsonOk(new Gson().toJson(result));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // doGet(req, resp);
    }
}
