package com.devlogs.masa_backend.common.di.controller;

import com.devlogs.masa_backend.api.google.LoginWithGoogleApiImp;
import com.devlogs.masa_backend.domain.ports.google_api.LoginWithGoogleApi;
import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    LoginWithGoogleApi provideLoginWithGoogleApi (LoginWithGoogleApiImp loginWithGoogleApiImp) {
        return loginWithGoogleApiImp;
    }
}
