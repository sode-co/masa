package com.devlogs.masa_backend.servlets.listeners;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.di.application.ApplicationComponent;
import com.devlogs.masa_backend.common.di.application.ApplicationModule;
import com.devlogs.masa_backend.common.di.application.DaggerApplicationComponent;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.servlets.common.RoleAndRequestMapper;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Arrays;
import static com.devlogs.masa_backend.common.Masa.*;

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
        roleAndRequestMapper.register(PAGE.MEMBER.HOME, Arrays.asList(UserRole.TYPE.STUDENT, UserRole.TYPE.MEMBER, UserRole.TYPE.MENTOR));
        roleAndRequestMapper.register(PAGE.ADMIN.MANAGEMENT, Arrays.asList(UserRole.TYPE.ADMIN));
        roleAndRequestMapper.register(PAGE.MEMBER.MENTOR_REQUEST, Arrays.asList( UserRole.TYPE.MEMBER));
        roleAndRequestMapper.register(PAGE.MEMBER.QUESTION, Arrays.asList(UserRole.TYPE.STUDENT, UserRole.TYPE.MEMBER));
        roleAndRequestMapper.register(PAGE.ADMIN.MEMBER_MANAGEMENT, Arrays.asList(UserRole.TYPE.ADMIN));
        roleAndRequestMapper.register(PAGE.ADMIN.MEETING_MANAGEMENT, Arrays.asList(UserRole.TYPE.ADMIN));
        roleAndRequestMapper.register(PAGE.ADMIN.REQUEST_MANAGEMENT.RESPONSE, Arrays.asList(UserRole.TYPE.ADMIN));
        roleAndRequestMapper.register(PAGE.MENTOR.MEETING_PAGE, Arrays.asList(UserRole.TYPE.MENTOR));
        roleAndRequestMapper.register(PAGE.MENTOR.MEETING_CREATE, Arrays.asList(UserRole.TYPE.MENTOR));
        roleAndRequestMapper.register(PAGE.MENTOR.MEETING_UPDATE, Arrays.asList(UserRole.TYPE.MENTOR));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }


}
