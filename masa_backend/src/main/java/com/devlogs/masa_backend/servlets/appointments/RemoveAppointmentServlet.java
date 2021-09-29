package com.devlogs.masa_backend.servlets.appointments;

import com.devlogs.masa_backend.appointment.FollowMeetingUseCase;
import com.devlogs.masa_backend.appointment.UnFollowMeetingUseCase;
import com.devlogs.masa_backend.common.annotations.AccessRole;
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

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.*;

@AccessRole(roles = {STUDENT})
@WebServlet(name = "unfollowmeetingservlet", urlPatterns = "/api/appointment-management/remove")
public class RemoveAppointmentServlet extends BaseHttpServlet {

    @Inject
    protected UnFollowMeetingUseCase unFollowMeetingUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestHelper requestHelper = getRequestComponent().getRequestHelper();
        ResponseHelper responseHelper = getRequestComponent().getResponseHelper();
        ValidateResult<RemoveAppointmentReqBody> validateResult = requestHelper.getRequestBody(RemoveAppointmentReqBody.class);
        requestHelper.getTailRequestParam((value) -> {
           return true;
        });
        if (validateResult instanceof ValidateResult.InValid) {
            getRequestComponent().getResponseHelper().responseMessage(400, ((ValidateResult.InValid<RemoveAppointmentReqBody>) validateResult).getMessage());
        }
        RemoveAppointmentReqBody reqBody = ((ValidateResult.Valid<RemoveAppointmentReqBody>) validateResult).getBody();

        UnFollowMeetingUseCase.Result result = unFollowMeetingUseCase.executes(reqBody.getUserId(), reqBody.getMeetingId());

        if (result instanceof UnFollowMeetingUseCase.Result.MeetingNotFound) {
            responseHelper.responseMessage(400, "Your meeting id does not exist");
        } else if (result instanceof UnFollowMeetingUseCase.Result.UserNotFound) {
            responseHelper.responseMessage(400, "Your user id does not exist");
        } else if (result instanceof UnFollowMeetingUseCase.Result.GeneralError) {
            responseHelper.responseMessage(500, "Internal server error");
        } else if (result instanceof UnFollowMeetingUseCase.Result.Success ) {
            responseHelper.responseJson(200, "{\"message\":\"UnFollow success\"}");
        }
    }
}
