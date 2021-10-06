package com.devlogs.masa_backend.servlets.usermanagement;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.errors.ConnectionException;
import com.devlogs.masa_backend.repository.user.UserRepositoryImp;
import com.devlogs.masa_backend.servlets.common.RequestHelper.ValidateResult;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.manage.GetAllUserUserCase;
import com.devlogs.masa_backend.manage.UpdateUserRoleUseCase;
import com.devlogs.masa_backend.servlets.appointments.CreateAppointmentReqBody;
import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.devlogs.masa_backend.servlets.meeting.createmeeting.CreateMeetingReq;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.ADMIN;

@AccessRole(roles = {ADMIN})
@WebServlet(name = "UpdateUserRoleServlet", urlPatterns = "/api/user-management/update-role/*")
public class UpdateUserRoleServlet extends BaseHttpServlet {

    @Inject
    protected UpdateUserRoleUseCase updateUserRoleUseCase;

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

        //get Role from updateUserRoleUseCase
        UpdateUserRoleUseCase.Result result = null;
        result = updateUserRoleUseCase.executes(userID);

        if (result instanceof UpdateUserRoleUseCase.Result.Success) {
            responseHelper.responseJsonOk("Update successfully" );
        } else if (result instanceof UpdateUserRoleUseCase.Result.ConnectionError) {
            responseHelper.responseMessage(400, "Db connection error");
        } else if (result instanceof  UpdateUserRoleUseCase.Result.UserDoesNotExist) {
            responseHelper.responseMessage(400, "Your user id does not exist");
        }else if (result instanceof  UpdateUserRoleUseCase.Result.NotRoleAllowError) {
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
