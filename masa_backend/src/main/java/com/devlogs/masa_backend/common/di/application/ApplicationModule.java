package com.devlogs.masa_backend.common.di.application;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.data.common.DbHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import javax.servlet.ServletContext;
import java.net.URL;

@Module
public class ApplicationModule {
    private ServletContext context;
    private URL WEB_INF_PATH;
    public ApplicationModule (ServletContext applicationContext) {
        this.context = applicationContext;
        Masa.init(context);
    }

    @Provides
    @Singleton
    public DbHelper provideDbHelper () {
        return new DbHelper(WEB_INF_PATH.toString());
    }
}
