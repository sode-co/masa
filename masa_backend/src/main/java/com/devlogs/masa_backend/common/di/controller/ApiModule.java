package com.devlogs.masa_backend.common.di.controller;

import com.devlogs.masa_backend.api.google.GoogleGetUserInfoEndpointImp;
import com.devlogs.masa_backend.api.sendmail.MailSenderApi;
import com.devlogs.masa_backend.domain.ports.google_api.GoogleGetUserEndpoint;
import com.devlogs.masa_backend.domain.ports.sendmail.SendMailGateway;
import com.devlogs.masa_backend.login_convention.EmailValidator;
import com.devlogs.masa_backend.login_convention.EmailValidatorImp;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    GoogleGetUserEndpoint provideLoginWithGoogleApi (GoogleGetUserInfoEndpointImp loginWithGoogleApiImp) {
        return loginWithGoogleApiImp;
    }

    @Provides
    SendMailGateway provideSendMailGateway (MailSenderApi mailSenderApi) {
        return mailSenderApi;
    }

    @Provides
    EmailValidator provideEmailValidator (EmailValidatorImp emailValidatorImp) {
        return emailValidatorImp;
    }
}
