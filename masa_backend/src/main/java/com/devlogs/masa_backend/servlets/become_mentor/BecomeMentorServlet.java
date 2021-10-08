package com.devlogs.masa_backend.servlets.become_mentor;


import com.devlogs.masa_backend.become_mentor.SendRequestToBecomeMentorUseCase;
import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.platform.PlatformChecker;
import com.devlogs.masa_backend.servlets.common.RequestHelper;
import com.devlogs.masa_backend.servlets.common.RequestHelper.ValidateResult;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.devlogs.masa_backend.servlets.common.base.BaseHttpServlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.*;

@AccessRole(roles = {MEMBER})
@WebServlet(name = "BecomeMentorServlet", urlPatterns = "/api/mentor-management/become-mentor/*")
public class BecomeMentorServlet extends BaseHttpServlet {

    @Inject
    protected SendRequestToBecomeMentorUseCase sendRequestToBecomeMentorUseCase;
    @Inject
    protected PlatformChecker platformChecker;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestHelper requestHelper = getRequestComponent().getRequestHelper();
        ResponseHelper responseHelper = getRequestComponent().getResponseHelper();
        // check url param
        String userId = requestHelper.getTailRequestParam((param) -> {
            if (param.length() < 8) {
                return false;
            }
            return true;
        });

        // check reqBody
        ValidateResult<BecomeMentorReqBody> reqBodyValidateResult =  requestHelper.getRequestBody(BecomeMentorReqBody.class);

        if (!reqBodyValidateResult.isValid()) {
            responseHelper.responseMessage(400, reqBodyValidateResult.getFailMessage());
            return;
        }
        BecomeMentorReqBody reqBody = reqBodyValidateResult.getValidReqBody();
        if (!reqBody.isValidUrl()) {
            responseHelper.responseMessage(400, "Your url is invalid");
            return;
        }
        sendBecomeMentorRequest(userId, reqBody.getDescription(), reqBody.getZoomUrl(), reqBody.getGoogleMeetUrl());

    }

    private void sendBecomeMentorRequest (String userId, String description, String zoomUrl, String googleMeetUrl) throws IOException {
        SendRequestToBecomeMentorUseCase.Result result = sendRequestToBecomeMentorUseCase.executes(userId, description, zoomUrl, googleMeetUrl);
        if (result instanceof SendRequestToBecomeMentorUseCase.Result.OnlyGuestCanBecomeMentor) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Only guest can become mentor");
        } else if (result instanceof SendRequestToBecomeMentorUseCase.Result.UserAlreadyAMentor) {
            getRequestComponent().getResponseHelper().responseMessage(400, "You're already mentor");
        } else if (result instanceof SendRequestToBecomeMentorUseCase.Result.InvalidPlatform) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Your url is invalid");
        }  else if (result instanceof SendRequestToBecomeMentorUseCase.Result.UserNotFound) {
            getRequestComponent().getResponseHelper().responseMessage(400, "Your user id doesn't exist");
        }  else if (result instanceof SendRequestToBecomeMentorUseCase.Result.GeneralError) {
            getRequestComponent().getResponseHelper().responseMessage(500, "Internal server error: " + ((SendRequestToBecomeMentorUseCase.Result.GeneralError) result).message);
        } else if (result instanceof SendRequestToBecomeMentorUseCase.Result.SendMailFailedButRequestSaved) {
            getRequestComponent().getResponseHelper().responseMessage(200, "Success, but we can not send email to admin right now");
        } else if (result instanceof SendRequestToBecomeMentorUseCase.Result.Success) {
            getRequestComponent().getResponseHelper().responseMessage(200, "Success, we already sent your request to admin");
        }
    }
}
