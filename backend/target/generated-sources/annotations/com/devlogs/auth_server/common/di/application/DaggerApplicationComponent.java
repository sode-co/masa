package com.devlogs.auth_server.common.di.application;

import com.devlogs.auth_server.common.di.controller.ControllerComponent;
import com.devlogs.auth_server.common.di.controller.DataModule;
import com.devlogs.auth_server.common.di.controller.RepositoryModule;
import com.devlogs.auth_server.common.di.servlet.ServletComponent;
import com.devlogs.auth_server.common.di.servlet.ServletModule;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private DaggerApplicationComponent(Builder builder) {}

  public static Builder builder() {
    return new Builder();
  }

  public static ApplicationComponent create() {
    return new Builder().build();
  }

  @Override
  public ServletComponent newServletComponent(ServletModule servletModule) {
    return new ServletComponentImpl(servletModule);
  }

  public static final class Builder {
    private Builder() {}

    public ApplicationComponent build() {
      return new DaggerApplicationComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This
     *     method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder applicationModule(ApplicationModule applicationModule) {
      Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }

  private final class ServletComponentImpl implements ServletComponent {
    private ServletComponentImpl(ServletModule servletModule) {}

    @Override
    public ControllerComponent newControllerComponent(
        DataModule dataModule, RepositoryModule repositoryModule) {
      return new ControllerComponentImpl(dataModule, repositoryModule);
    }

    private final class ControllerComponentImpl implements ControllerComponent {
      private ControllerComponentImpl(DataModule dataModule, RepositoryModule repositoryModule) {}
    }
  }
}
