package com.devlogs.masa_backend.servlets.usermanagement;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.manage.UpdateUserRoleUseCase;
import com.devlogs.masa_backend.manage.UpdateUserStatusUseCase;
import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.ADMIN;

@AccessRole(roles = {ADMIN})
@WebServlet(name = "UpdateUserStatusServlet", urlPatterns = "/api/user-management/update-status/*")
public class UpdateUserStatusServlet extends BaseHttpServlet {

    @Inject
    UpdateUserStatusUseCase updateUserStatusUseCase;

    @Override
    public void init () throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }
    protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestHelper requestHelper = this.getRequestComponent().getRequestHelper();
        ResponseHelper responseHelper = this.getRequestComponent().getResponseHelper();

        //get ID from URL
        String userID = requestHelper.getTailRequestParam((param) -> {
            if (param.length() < 8) {
                return false;
            }
            return true;
        } );

        //get Status from UpdateUserStatusUseCase
        UpdateUserStatusUseCase.Result result = null;
        result = updateUserStatusUseCase.executes(userID);

        if (result instanceof UpdateUserStatusUseCase.Result.Success) {
            responseHelper.responseJsonOk("Update successfully" );
        } else if (result instanceof UpdateUserStatusUseCase.Result.ConnectionError) {
            responseHelper.responseMessage(400, "Db connection error");
        } else if (result instanceof  UpdateUserStatusUseCase.Result.UserDoesNotExist) {
            responseHelper.responseMessage(400, "Your user id does not exist");
        }else if (result instanceof  UpdateUserStatusUseCase.Result.NotAllowToUpdate) {
            responseHelper.responseMessage(400, "You can not update user another Admin status!");
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
