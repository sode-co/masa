package com.devlogs.auth_server.common.di.servlet;

import com.devlogs.auth_server.common.di.controller.ControllerComponent;
import com.devlogs.auth_server.common.di.controller.DataModule;
import com.devlogs.auth_server.common.di.controller.RepositoryModule;
import dagger.Subcomponent;

/**This component is inherited from ApplicationComponent
 * @see com.devlogs.auth_server.common.di.application.ApplicationComponent @ApplicationComponent
 * */
@ServletScope
@Subcomponent(modules = ServletModule.class)
public interface ServletComponent {
    ControllerComponent newControllerComponent (DataModule dataModule, RepositoryModule repositoryModule);
}