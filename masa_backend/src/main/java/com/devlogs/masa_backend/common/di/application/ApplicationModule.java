package com.devlogs.masa_backend.common.di.application;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.data.common.DbHelper;
import com.devlogs.masa_backend.platform.PlatformChecker;
import com.devlogs.masa_backend.platform.PlatformCheckerImp;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.net.URL;

@Module
public class ApplicationModule {
    private ServletContext context;
    private String WEB_INF_PATH;
    public ApplicationModule (ServletContext applicationContext) {
        this.context = applicationContext;
        Masa.init(context);
        WEB_INF_PATH = context.getRealPath("/WEB-INF");
    }

    @Provides
    @Singleton
    public DbHelper provideDbHelper () {
        return new DbHelper(WEB_INF_PATH);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient () {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    public PlatformChecker providePlatformChecker (PlatformCheckerImp platformCheckerImp) {
        return platformCheckerImp;
    }

    @Provides
    @Singleton
    public Validator provideJavaBeanValidator () {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

}
