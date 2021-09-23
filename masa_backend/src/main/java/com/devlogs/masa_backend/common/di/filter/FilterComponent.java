package com.devlogs.masa_backend.common.di.filter;

import com.devlogs.masa_backend.common.di.controller.ControllerComponent;
import com.devlogs.masa_backend.common.di.controller.DataModule;
import com.devlogs.masa_backend.common.di.controller.RepositoryModule;
import com.devlogs.masa_backend.common.di.request.RequestComponent;
import com.devlogs.masa_backend.common.di.request.RequestModule;
import dagger.Subcomponent;

import javax.validation.Validator;

/**This component is inherited from ApplicationComponent
 * @see com.devlogs.masa_backend.common.di.application.ApplicationComponent @ApplicationComponent
 * */
@FilterScope
@Subcomponent(modules = FilterModule.class)
public interface FilterComponent {
    ControllerComponent newControllerComponent (DataModule dataModule, RepositoryModule repositoryModule);
    Validator getValidator ();
}