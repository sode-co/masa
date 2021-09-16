package com.devlogs.masa_backend.common.di.application;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.data.common.DbHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import javax.servlet.ServletContext;

@Module
public class ApplicationModule {
    private ServletContext context;
    private final String WEB_INF_PATH;
    public ApplicationModule (ServletContext applicationContext) {
        this.context = applicationContext;
        WEB_INF_PATH = context.getRealPath("/WEB-INF");
        Masa.init(context.getRealPath(WEB_INF_PATH));
    }

    @Provides
    @Singleton
    public DbHelper provideDbHelper () {
        return new DbHelper(WEB_INF_PATH);
    }
}
