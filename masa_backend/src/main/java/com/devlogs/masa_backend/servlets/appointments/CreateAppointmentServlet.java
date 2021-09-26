package com.devlogs.masa_backend.servlets.appointments;

import com.devlogs.masa_backend.appointment.FollowMeetingUseCase;
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

import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.ADMIN;
import static com.devlogs.masa_backend.domain.entities.UserRole.TYPE.MENTOR;

@AccessRole(roles = {MENTOR, ADMIN})
@WebServlet(name = "followmeetingservlet", urlPatterns = "/api/appointment-management/create")
public class CreateAppointmentServlet extends BaseHttpServlet {

    @Inject
    protected FollowMeetingUseCase followMeetingUseCase;

    @Override
    public void init() throws ServletException {
        super.init();
        getControllerComponent().inject(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestHelper requestHelper = getRequestComponent().getRequestHelper();
        ResponseHelper responseHelper = getRequestComponent().getResponseHelper();
        ValidateResult<CreateAppointmentReqBody> validateResult = requestHelper.getRequestBody(CreateAppointmentReqBody.class);

        if (validateResult instanceof ValidateResult.InValid) {
            getRequestComponent().getResponseHelper().responseMessage(400, ((ValidateResult.InValid<CreateAppointmentReqBody>) validateResult).getMessage());
        }
        CreateAppointmentReqBody reqBody = ((ValidateResult.Valid<CreateAppointmentReqBody>) validateResult).getBody();

        FollowMeetingUseCase.Result result = followMeetingUseCase.executes(reqBody.getUserId(), reqBody.getMeetingId());

        if (result instanceof FollowMeetingUseCase.Result.MeetingNotFound) {
            responseHelper.responseMessage(400, "Your meeting id does not exist");
        } else if (result instanceof FollowMeetingUseCase.Result.UserNotFound) {
            responseHelper.responseMessage(400, "Your user id does not exist");
        } else if (result instanceof FollowMeetingUseCase.Result.ConnectionError) {
            responseHelper.responseMessage(400, "Db connection error");
        } else if (result instanceof FollowMeetingUseCase.Result.Success || result instanceof FollowMeetingUseCase.Result.AppointmentAlreadyExist) {
            responseHelper.responseJsonOk(new Gson().toJson(result));
        }
    }
}
