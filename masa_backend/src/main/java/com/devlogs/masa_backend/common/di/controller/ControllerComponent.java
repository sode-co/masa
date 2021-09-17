package com.devlogs.masa_backend.common.di.controller;

import com.devlogs.masa_backend.servlets.login.GoogleLoginProcessServlet;
import com.devlogs.masa_backend.servlets.user.GetUserByEmailServlet;
import dagger.Subcomponent;

@Subcomponent (modules = {DataModule.class, RepositoryModule.class, ApiModule.class})
public interface ControllerComponent {
    void inject (GetUserByEmailServlet servlet);
    void inject(GoogleLoginProcessServlet googleLoginProcessServlet);
}
