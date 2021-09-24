package com.devlogs.masa_backend.servlets.common;

import com.devlogs.masa_backend.common.annotations.AccessRole;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.UserRole;
import com.devlogs.masa_backend.domain.entities.UserRole.TYPE;
import org.reflections.Reflections;

import javax.servlet.annotation.WebServlet;
import java.util.*;

import static com.devlogs.masa_backend.servlets.common.helpers.UrlHelper.minimizeUrl;

public class RoleAndRequestMapper {
    private HashMap<String, List<UserRole.TYPE>> currentMapping = new HashMap();

    public RoleAndRequestMapper () {
        Reflections reflections = new Reflections("com.devlogs.masa_backend");

        Set<Class<?>> servletClazzes = reflections.getTypesAnnotatedWith(AccessRole.class);

        for (Class<?> servletClazz : servletClazzes) {
            WebServlet webServlet = servletClazz.getAnnotation(WebServlet.class);
            AccessRole accessRole = servletClazz.getAnnotation(AccessRole.class);

            if (webServlet == null) {
                throw new RuntimeException(String.format("AccessRole annotation can only use for servlet {%s}", servletClazz.getSimpleName()));
            }

            for (String s : webServlet.urlPatterns()) {
                currentMapping.put(minimizeUrl(s), Arrays.asList(accessRole.roles()));
                for (TYPE role : accessRole.roles()) {
                    MasaLog.normalLog("Mapper: " + minimizeUrl(s) + " , " + role.name());
                }
            }
        }
    }

    public void register (String url, List<UserRole.TYPE> roles) {
        currentMapping.put(url, roles);
    }

    public boolean isAllowToAccess (UserRole role, String url) {
        // minimize url
        List<UserRole.TYPE> allowedType = currentMapping.get(minimizeUrl(url));

        if (allowedType == null) {
            return true;
        }
        for (TYPE type : allowedType) {
            if (type == role.getType()) {
                return true;
            }
        }
        return false;
    }

}
