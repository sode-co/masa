package com.devlogs.masa_backend.servlets.listeners;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.common.di.application.ApplicationComponent;
import com.devlogs.masa_backend.common.di.application.ApplicationModule;
import com.devlogs.masa_backend.common.di.application.DaggerApplicationComponent;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.servlets.common.RoleAndRequestMapper;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import static com.devlogs.masa_backend.common.Masa.PAGE.*;
import javax.servlet.ServletContextListener;
import java.util.Arrays;

public class ApplicationContextListener implements ServletContextListener {
    @Inject
    protected RoleAndRequestMapper roleAndRequestMapper;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(sce.getServletContext())).build();
        sce.getServletContext().log("The real real path: " + sce.getServletContext().getRealPath("/WEB-INF"));
        sce.getServletContext().setAttribute(Masa.Component.APPLICATION_COMPONENT,
               applicationComponent );

        applicationComponent.inject(this);
        registerResourcePage();
    }

    public void registerResourcePage () {
        roleAndRequestMapper.register(STUDENT.MEETING_PAGE, Arrays.asList(UserRole.TYPE.STUDENT));
        roleAndRequestMapper.register(ADMIN.USER_MANAGEMENT_PAGE, Arrays.asList(UserRole.TYPE.ADMIN));
        roleAndRequestMapper.register(MENTOR.MEETING_PAGE, Arrays.asList(UserRole.TYPE.MENTOR));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }


}
