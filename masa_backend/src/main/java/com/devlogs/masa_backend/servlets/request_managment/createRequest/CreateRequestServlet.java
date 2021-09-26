package com.devlogs.masa_backend.servlets.request_managment.createRequest;

import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.RequestEntity.TYPE;
import com.devlogs.masa_backend.request.CreateRequestUseCase;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "create-request", urlPatterns = {"/api/request/create", "/api/request-management/create"})
public class CreateRequestServlet extends BaseHttpServlet {
    @Inject
    public CreateRequestUseCase createRequestUseCase;
    @Inject
    Validator validator;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining());
        CreateRequestReq reqBody = null;
        if (requestData != null && !requestData.isEmpty()) {
            try{
                reqBody = getRequestReqBodyFromReqBody(requestData);
            } catch (JsonSyntaxException ex) {
                getRequestComponent().getResponseHelper().responseMessage(400,ex.getMessage());
                return;
            }
        }
        Set<ConstraintViolation<CreateRequestReq>> violations = validator.validate(reqBody);
        String invalidMessage = "";
        for (ConstraintViolation<CreateRequestReq> violation : violations) {
            invalidMessage += violation.getMessage() + ", \n";
        }
        if (invalidMessage.isEmpty()) {
            MasaLog.normalLog("Start create request");
            createRequest(reqBody,resp);
        } else {
            MasaLog.normalLog("Violation req: " + invalidMessage);
            getRequestComponent().getResponseHelper().responseMessage(400,invalidMessage);
            return;
        }
    }

    private CreateRequestReq getRequestReqBodyFromReqBody(String requestData) throws JsonSyntaxException {
        return  new Gson().fromJson(requestData, CreateRequestReq.class);
    }

    private void createRequest(CreateRequestReq reqBody, HttpServletResponse resp) throws IOException {
        TYPE requestType;
        if(reqBody.getType().equalsIgnoreCase("BECOME_MENTOR")){
            requestType = TYPE.BECOME_MENTOR;
        }else{
            getRequestComponent().getResponseHelper().responseMessage(400,"Invalid request type");
            return;
        }
        MasaLog.normalLog("Request from user id: " + reqBody.getUserId());
        CreateRequestUseCase.Result  result = createRequestUseCase.executes(reqBody.getDescription(), requestType, reqBody.getUserId());

        if (result instanceof CreateRequestUseCase.Result.Success) {
            String resultJson = new Gson().toJson(result);
            MasaLog.normalLog("Created request from user id: " + ((CreateRequestUseCase.Result.Success) result).requestEntity.getUserId());
            getRequestComponent().getResponseHelper().responseJsonOk(resultJson);
        } else if (result instanceof CreateRequestUseCase.Result.ConnectionError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Internal server error, can not connect to db");
            return;
        } else if (result instanceof CreateRequestUseCase.Result.HostDoesNotExist) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Your user id doesn't exist");
            return;
        } else if (result instanceof CreateRequestUseCase.Result.NotRoleAllowError) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Student can not make request");
            return;
        }
    }
}
