package com.devlogs.auth_server.common.di.application;

import com.devlogs.auth_server.data.common.DbHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideDbHelperFactory implements Factory<DbHelper> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideDbHelperFactory(ApplicationModule module) {
    this.module = module;
  }

  @Override
  public DbHelper get() {
    return provideInstance(module);
  }

  public static DbHelper provideInstance(ApplicationModule module) {
    return proxyProvideDbHelper(module);
  }

  public static ApplicationModule_ProvideDbHelperFactory create(ApplicationModule module) {
    return new ApplicationModule_ProvideDbHelperFactory(module);
  }

  public static DbHelper proxyProvideDbHelper(ApplicationModule instance) {
    return Preconditions.checkNotNull(
        instance.provideDbHelper(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
