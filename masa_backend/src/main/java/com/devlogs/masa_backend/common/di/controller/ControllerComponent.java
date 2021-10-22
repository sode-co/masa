package com.devlogs.masa_backend.common.di.controller;

import com.devlogs.masa_backend.servlets.appointments.CreateAppointmentServlet;
import com.devlogs.masa_backend.servlets.appointments.RemoveAppointmentServlet;
import com.devlogs.masa_backend.servlets.become_mentor.BecomeMentorServlet;
import com.devlogs.masa_backend.servlets.filters.AuthFilter;
import com.devlogs.masa_backend.servlets.filters.RoleFilter;
import com.devlogs.masa_backend.servlets.login.GoogleLoginProcessServlet;
import com.devlogs.masa_backend.servlets.login.LoginServlet;
import com.devlogs.masa_backend.servlets.meeting.createmeeting.CreateMeetingServlet;

import com.devlogs.masa_backend.servlets.meeting.deletemeeting.DeleteMeetingServlet;
import com.devlogs.masa_backend.servlets.meeting.getmeeting.*;
import com.devlogs.masa_backend.servlets.meeting.updatemeeting.UpdateMeetingServlet;
import com.devlogs.masa_backend.servlets.meeting_question.createMeetingQuestion.CreateMeetingQuestionServlet;
import com.devlogs.masa_backend.servlets.meeting_question.getMeetingQuestion.GetAllMeetingQuestionByMeetingIdServlet;
import com.devlogs.masa_backend.servlets.request_managment.AnswerRequestServlet;
import com.devlogs.masa_backend.servlets.request_managment.getRequest.GetAllRequestServlet;
import com.devlogs.masa_backend.servlets.request_managment.getRequest.GetRequestByUserIdServlet;


import com.devlogs.masa_backend.servlets.topics.GetAllTopicsServlet;


import com.devlogs.masa_backend.servlets.request_managment.AnswerRequestServlet;



import com.devlogs.masa_backend.servlets.topics.GetAllTopicsServlet;
import com.devlogs.masa_backend.servlets.usermanagement.*;

//import com.devlogs.masa_backend.servlets.usermanagement.UpdateUserRoleServlet;

import com.devlogs.masa_backend.servlets.usermanagement.get_user_from_request.GetUserFromRequestProcessingServlet;
import dagger.Subcomponent;

@Subcomponent (modules = {DataModule.class, RepositoryModule.class, ApiModule.class})
public interface ControllerComponent {
    void inject(GoogleLoginProcessServlet googleLoginProcessServlet);

    void inject(CreateMeetingServlet createMeetingServlet);

    void inject(UpdateMeetingServlet updateMeetingServlet);

    void inject(GetMeetingByHostIdServlet getMeetingByHostIdServlet);

    void inject(GetAllMeetingServlet getAllMeetingServlet);

    void inject(CreateAppointmentServlet followMeetingServlet);

    void inject(BecomeMentorServlet becomeMentorServlet);

    void inject(ShowAllUserServlet showAllUserServlet);

    void inject(AuthFilter authFilter);

    void inject(RoleFilter roleFilter);

    void inject(GetAllRequestServlet getAllRequestServlet);

    void inject(GetRequestByUserIdServlet getRequestByUserIdServlet);

    void inject(LoginServlet loginServlet);

    void inject(AnswerRequestServlet answerRequestServlet);

    void inject(UpdateUserRoleServlet updateUserRoleServlet);

    void inject(GetAllUserFollowedMeetingServlet getAllUserFollowedMeetingServlet);

    void inject(GetAllUserNotFollowedMeetingServlet getAllUserNotFollowedMeetingServlet);

    void inject(RemoveAppointmentServlet removeAppointmentServlet);


    void inject(GetUserByRoleServlet getUserByRoleServlet);



    void inject(GetAllMeetingQuestionByMeetingIdServlet getAllMeetingQuestionByMeetingIdServlet);

    void inject(GetNewMeetingsServlet getNewMeetingsServlet);

    void inject(GetMeetingsByTopicServlet getMeetingsByTopicServlet);

    void inject(GetMeetingsByMultipleTopicsServlet getMeetingsByMultipleTopicsServlet);


    void inject(GetAllTopicsServlet getAllTopicsServlet);

    void inject(CreateMeetingQuestionServlet createMeetingQuestionServlet);

    void inject(GetUserByNameServlet getUserByNameServlet);

    void inject(UpdateUserStatusServlet updateUserStatusServlet);

    void inject(GetMeetingsByTopicNameServlet getMeetingsByTopicNameServlet);

    void inject(GetUserFromRequestProcessingServlet getUserFromRequestProcessingServlet);

    void inject(GetAllMeetingsByHostNameServlet getAllMeetingsByHostNameServlet);

    void inject(GetAllMeetingsByTitleServlet getAllMeetingsByTitleServlet);

    void inject(DeleteMeetingServlet deleteMeetingServlet);

    void inject(GetAllActiveMeetingServlet getAllActiveMeetingServlet);
}


