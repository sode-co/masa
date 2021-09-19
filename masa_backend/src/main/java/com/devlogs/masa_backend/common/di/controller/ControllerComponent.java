package com.devlogs.masa_backend.common.di.controller;

import com.devlogs.masa_backend.servlets.appointments.CreateAppointmentServlet;
import com.devlogs.masa_backend.servlets.login.GoogleLoginProcessServlet;
import com.devlogs.masa_backend.servlets.meeting.createmeeting.CreateMeetingServlet;
import com.devlogs.masa_backend.servlets.meeting.getmeeting.GetAllMeetingServlet;
import com.devlogs.masa_backend.servlets.meeting.getmeeting.GetMeetingByHostIdServlet;
import com.devlogs.masa_backend.servlets.meeting.updatemeeting.UpdateMeetingServlet;
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

}
