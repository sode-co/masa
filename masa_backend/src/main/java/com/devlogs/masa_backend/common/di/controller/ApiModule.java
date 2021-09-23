package com.devlogs.masa_backend.common.di.controller;

import com.devlogs.masa_backend.api.google.GetGoogleUserImp;
import com.devlogs.masa_backend.api.sendmail.MailSenderApi;
import com.devlogs.masa_backend.domain.ports.google_api.GetGoogleUser;
import com.devlogs.masa_backend.domain.ports.sendmail.SendMailGateway;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    GetGoogleUser provideLoginWithGoogleApi (GetGoogleUserImp loginWithGoogleApiImp) {
        return loginWithGoogleApiImp;
    }

    @Provides
    SendMailGateway provideSendMailGateway (MailSenderApi mailSenderApi) {
        return mailSenderApi;
    }
}
