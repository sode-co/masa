package com.devlogs.masa_backend.common.di.servlet;

import com.devlogs.masa_backend.common.di.controller.ControllerComponent;
import com.devlogs.masa_backend.common.di.controller.DataModule;
import com.devlogs.masa_backend.common.di.controller.RepositoryModule;
import com.devlogs.masa_backend.common.di.request.RequestComponent;
import com.devlogs.masa_backend.common.di.request.RequestModule;
import dagger.Subcomponent;

/**This component is inherited from ApplicationComponent
 * @see com.devlogs.masa_backend.common.di.application.ApplicationComponent @ApplicationComponent
 * */
@ServletScope
@Subcomponent(modules = ServletModule.class)
public interface ServletComponent {
    ControllerComponent newControllerComponent (DataModule dataModule, RepositoryModule repositoryModule);
    RequestComponent newRequestComponent (RequestModule requestModule);
}