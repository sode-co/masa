package com.devlogs.masa_backend.servlets.usermanagement.get_user_from_request;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.manage.GetAllUserUserCase;
import com.devlogs.masa_backend.manage.GetUserFromRequestProcessingUseCase;
import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.ADMIN;

@AccessRole(roles = {ADMIN})
@WebServlet(name = "get_user_entity_from_request_processing",
        urlPatterns = "/api/user-management/get_user_in_processing")
public class GetUserFromRequestProcessingServlet extends BaseHttpServlet {

    @Inject
    protected GetUserFromRequestProcessingUseCase getUserFromRequestProcessingUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);

    }

    protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestHelper requestHelper = this.getRequestComponent().getRequestHelper();
        ResponseHelper responseHelper = this.getRequestComponent().getResponseHelper();

        GetUserFromRequestProcessingUseCase.Result result = getUserFromRequestProcessingUseCase.executes();

        if (result instanceof GetUserFromRequestProcessingUseCase.Result.Success) {
            responseHelper.responseJsonOk(new Gson().toJson(result));
        } else if (result instanceof  GetUserFromRequestProcessingUseCase.Result.ConnectionError) {
            responseHelper.responseMessage(400, "Connection Error!!!");
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

