package com.devlogs.masa_backend.common.di.controller;

import com.devlogs.masa_backend.request.GetRequestByUserIdUseCase;
import com.devlogs.masa_backend.servlets.appointments.CreateAppointmentServlet;
import com.devlogs.masa_backend.servlets.become_mentor.BecomeMentorServlet;
import com.devlogs.masa_backend.servlets.filters.AuthFilter;
import com.devlogs.masa_backend.servlets.filters.RoleFilter;
import com.devlogs.masa_backend.servlets.login.GoogleLoginProcessServlet;
import com.devlogs.masa_backend.servlets.meeting.createmeeting.CreateMeetingServlet;
import com.devlogs.masa_backend.servlets.meeting.getmeeting.GetAllMeetingServlet;
import com.devlogs.masa_backend.servlets.meeting.getmeeting.GetMeetingByHostIdServlet;
import com.devlogs.masa_backend.servlets.meeting.updatemeeting.UpdateMeetingServlet;

import com.devlogs.masa_backend.servlets.request_managment.AnswerBecomeMentorNavigationServlet;
import com.devlogs.masa_backend.servlets.request_managment.createRequest.CreateRequestServlet;
import com.devlogs.masa_backend.servlets.request_managment.getRequest.GetAllRequestServlet;
import com.devlogs.masa_backend.servlets.request_managment.getRequest.GetRequestByUserIdServlet;
import com.devlogs.masa_backend.servlets.test.TestServlet;

import dagger.Subcomponent;

@Subcomponent (modules = {DataModule.class, RepositoryModule.class, ApiModule.class})
public interface ControllerComponent {
    void inject(GoogleLoginProcessServlet googleLoginProcessServlet);

    void inject(CreateMeetingServlet createMeetingServlet);

    void inject(UpdateMeetingServlet updateMeetingServlet);




    void inject(GetMeetingByHostIdServlet getMeetingByHostIdServlet);

    void inject(GetAllMeetingServlet getAllMeetingServlet);


    void inject(TestServlet testServlet);

    void inject(CreateAppointmentServlet followMeetingServlet);


    void inject(BecomeMentorServlet becomeMentorServlet);

    void inject(AnswerBecomeMentorNavigationServlet answerBecomeMentorNavigationServlet);

    void inject(AuthFilter authFilter);

    void inject(RoleFilter roleFilter);

    void inject(CreateRequestServlet createRequestServlet);

    void inject(GetAllRequestServlet getAllRequestServlet);

    void inject(GetRequestByUserIdServlet getRequestByUserIdServlet);

}
