package com.devlogs.masa_backend.common.di.controller;

import dagger.Subcomponent;

@Subcomponent (modules = {DataModule.class, RepositoryModule.class})
public interface ControllerComponent {
//    void inject (GetUserByEmailServlet servlet);
}
