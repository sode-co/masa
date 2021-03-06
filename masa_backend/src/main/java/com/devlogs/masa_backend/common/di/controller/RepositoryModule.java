package com.devlogs.masa_backend.common.di.controller;


import com.devlogs.masa_backend.domain.ports.*;
import com.devlogs.masa_backend.repository.appointment.AppointmentRepositoryImp;
import com.devlogs.masa_backend.repository.meeting.MeetingRepositoryImp;
import com.devlogs.masa_backend.repository.meeting_platform.MeetingPlatformRepositoryImp;
import com.devlogs.masa_backend.repository.meeting_question.MeetingQuestionRepositoryImp;
import com.devlogs.masa_backend.repository.request.BecomeMentorRequestRepositoryImp;


import com.devlogs.masa_backend.repository.topic.TopicRepositoryImp;
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
    public MeetingRepository provideMeetingRepository (MeetingRepositoryImp meetingRepositoryImp) {
        return meetingRepositoryImp;
    }

    @Provides
    public AppointmentRepository provideAppointmentRepository (AppointmentRepositoryImp appointmentRepositoryImp) {
        return appointmentRepositoryImp;
    }

    @Provides
    public BecomeMentorRequestRepository provideRequestRepository(BecomeMentorRequestRepositoryImp requestRepositoryImp) {
        return requestRepositoryImp;
    }

    @Provides
    public PlatformRepository providePlatformRepository(MeetingPlatformRepositoryImp platformRepositoryImp) {
        return platformRepositoryImp;
    }

    @Provides
    public TopicRepository provideTopicRepository(TopicRepositoryImp topicRepositoryImp) {
        return topicRepositoryImp;
    }

    @Provides
    public MeetingQuestionRepository provideMeetingQuestionRepository(MeetingQuestionRepositoryImp meetingQuestionRepositoryImp) {
        return meetingQuestionRepositoryImp;
    }

}



