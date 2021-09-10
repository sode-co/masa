package com.devlogs.masa_backend.common.di.application;

import com.devlogs.masa_backend.data.common.DbHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import javax.servlet.ServletContext;

@Module
public class ApplicationModule {
    private ServletContext context;

    public ApplicationModule (ServletContext applicationContext) {
        this.context = applicationContext;
    }

    @Provides
    @Singleton
    public DbHelper provideDbHelper () {
        return new DbHelper(context.getRealPath("/WEB-INF"));
    }

}
