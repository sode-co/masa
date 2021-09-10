package com.devlogs.auth_server.common.di.servlet;

import com.devlogs.auth_server.common.di.controller.ControllerComponent;
import com.devlogs.auth_server.common.di.controller.DataModule;
import com.devlogs.auth_server.common.di.controller.RepositoryModule;
import com.devlogs.auth_server.servlets.login_by_email.LoginByEmailServlet;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerServletComponent implements ServletComponent {
  private DaggerServletComponent(Builder builder) {}

  public static Builder builder() {
    return new Builder();
  }

  public static ServletComponent create() {
    return new Builder().build();
  }

  @Override
  public ControllerComponent newControllerComponent(
      DataModule dataModule, RepositoryModule repositoryModule) {
    return new ControllerComponentImpl(dataModule, repositoryModule);
  }

  public static final class Builder {
    private Builder() {}

    public ServletComponent build() {
      return new DaggerServletComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This
     *     method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder servletModule(ServletModule servletModule) {
      Preconditions.checkNotNull(servletModule);
      return this;
    }
  }

  private final class ControllerComponentImpl implements ControllerComponent {
    private ControllerComponentImpl(DataModule dataModule, RepositoryModule repositoryModule) {}

    @Override
    public void inject(LoginByEmailServlet servlet) {}
  }
}
