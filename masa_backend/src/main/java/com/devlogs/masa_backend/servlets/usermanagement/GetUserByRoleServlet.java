package com.devlogs.masa_backend.servlets.usermanagement;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.manage.GetAllUserUserCase;
import com.devlogs.masa_backend.manage.GetUserByRoleUserCase;
import com.devlogs.masa_backend.manage.UpdateUserRoleUseCase;
import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.ADMIN;

@AccessRole(roles = {ADMIN})
@WebServlet(name = "GetUserByRoleServlet", urlPatterns = "/api/user-management/get-user-by-role/*")
public class GetUserByRoleServlet extends BaseHttpServlet {

    @Inject
    protected GetUserByRoleUserCase getUserByRoleUserCase;

    @Override
    public void init () throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestHelper requestHelper = this.getRequestComponent().getRequestHelper();
        ResponseHelper responseHelper = this.getRequestComponent().getResponseHelper();

        String role = requestHelper.getTailRequestParam((param) -> {
            if (    param.equalsIgnoreCase("MENTOR"   )
                    || param.equalsIgnoreCase("ADMIN" )
                    ||param.equalsIgnoreCase("STUDENT")
                    || param.equalsIgnoreCase("GUEST" ) ) {
                return true;
            }
            return false;
        } );
        MasaLog.normalLog("role la "+ role);

        GetUserByRoleUserCase.Result result = getUserByRoleUserCase.executes(role);

        if (result instanceof GetUserByRoleUserCase.Result.Success) {
            responseHelper.responseJsonOk(new Gson().toJson(result) );
        } else if (result instanceof GetUserByRoleUserCase.Result.ConnectionError) {
            responseHelper.responseMessage(400, "Db connection error");
        } else if (result instanceof  GetUserByRoleUserCase.Result.NoUserExist) {
            responseHelper.responseMessage(400, "No user is existed in this role");
        }else if (result instanceof  GetUserByRoleUserCase.Result.NotRoleAllowError) {
            responseHelper.responseMessage(400, "Your role is invalid");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }
}
