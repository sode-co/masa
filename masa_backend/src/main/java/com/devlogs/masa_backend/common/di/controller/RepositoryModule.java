package com.devlogs.masa_backend.common.di.controller;


import com.devlogs.masa_backend.domain.ports.AppointmentRepository;
import com.devlogs.masa_backend.domain.ports.MeetingRepository;
import com.devlogs.masa_backend.domain.ports.UserRepository;
import com.devlogs.masa_backend.repository.meeting.MeetingRepositoryImp;
import com.devlogs.masa_backend.repository.mock.MockAppointmentRepositoryImp;
import com.devlogs.masa_backend.repository.mock.MockMeetingRepositoryImp;
import com.devlogs.masa_backend.repository.appointment.AppointmentRepositoryImp;
import com.devlogs.masa_backend.repository.meeting.MeetingRepositoryImp;
import com.devlogs.masa_backend.repository.mock.MockAppointmentRepositoryImp;
import com.devlogs.masa_backend.repository.mock.MockUserRepositoryImp;
import com.devlogs.masa_backend.repository.user.UserRepositoryImp;
import dagger.Module;
import dagger.Provides;
@Module
public class RepositoryModule {

    @Provides
    public UserRepository provideUserRepository (UserRepositoryImp userRepositoryImp) {
        return userRepositoryImp;
    }

    @Provides
    public MeetingRepository provideMeetingRepository (MockMeetingRepositoryImp meetingRepositoryImp) {
        return meetingRepositoryImp;
    }

    @Provides
    public AppointmentRepository provideAppointmentRepository (MockAppointmentRepositoryImp appointmentRepositoryImp) {
        return appointmentRepositoryImp;
    }


}



