package com.devlogs.auth_server.common.di.controller;

import com.devlogs.auth_server.servlets.login_by_email.LoginByEmailServlet;
import dagger.Subcomponent;

@Subcomponent (modules = {DataModule.class, RepositoryModule.class})
public interface ControllerComponent {
    void inject (LoginByEmailServlet servlet);
}
