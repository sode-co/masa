package com.devlogs.masa_backend.servlets.usermanagement;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.manage.GetUserByNameUseCase;
import com.devlogs.masa_backend.manage.GetUserByRoleUserCase;
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
@WebServlet(name = "GetUserByNamServlet", urlPatterns = "/api/user-management/get-user-by-name/*")
public class GetUserByNameServlet extends BaseHttpServlet {

    @Inject
    protected GetUserByNameUseCase getUserByNameUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
        MasaLog.normalLog("AHIHIH " );
    }

    protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestHelper requestHelper = this.getRequestComponent().getRequestHelper();
        ResponseHelper responseHelper = this.getRequestComponent().getResponseHelper();

        String name = requestHelper.getTailRequestParam((param) -> {
            if (  param.length() > 0  ) {
                return true;
            }
            return false;
        } );
        MasaLog.normalLog("name la: " + name);
        GetUserByNameUseCase.Result result = getUserByNameUseCase.executes(name);
        MasaLog.normalLog("okkkkkkk " );

        if (result instanceof GetUserByNameUseCase.Result.Success) {
            responseHelper.responseJsonOk(new Gson().toJson(result) );
        } else if (result instanceof GetUserByNameUseCase.Result.ConnectionError) {
            responseHelper.responseMessage(400, "Db connection error");
        } else if (result instanceof  GetUserByNameUseCase.Result.NoUserExist) {
            responseHelper.responseMessage(400, "Can not find user like "+ name);
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
