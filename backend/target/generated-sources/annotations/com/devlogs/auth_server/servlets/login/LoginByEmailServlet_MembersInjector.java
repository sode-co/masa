package com.devlogs.auth_server.servlets.login;

import com.devlogs.auth_server.data.common.DbHelper;
import com.devlogs.auth_server.servlets.login_by_email.LoginByEmailServlet;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginByEmailServlet_MembersInjector
    implements MembersInjector<LoginByEmailServlet> {
  private final Provider<DbHelper> dbHelperProvider;

  public LoginByEmailServlet_MembersInjector(Provider<DbHelper> dbHelperProvider) {
    this.dbHelperProvider = dbHelperProvider;
  }

  public static MembersInjector<LoginByEmailServlet> create(Provider<DbHelper> dbHelperProvider) {
    return new LoginByEmailServlet_MembersInjector(dbHelperProvider);
  }

  @Override
  public void injectMembers(LoginByEmailServlet instance) {
    injectDbHelper(instance, dbHelperProvider.get());
  }

  public static void injectDbHelper(LoginByEmailServlet instance, DbHelper dbHelper) {
    instance.dbHelper = dbHelper;
  }
}
