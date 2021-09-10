package com.devlogs.masa_backend.common.di.controller;

import com.devlogs.masa_backend.servlets.login_by_email.LoginByEmailServlet;
import dagger.Subcomponent;

@Subcomponent (modules = {DataModule.class, RepositoryModule.class})
public interface ControllerComponent {
    void inject (LoginByEmailServlet servlet);
}
