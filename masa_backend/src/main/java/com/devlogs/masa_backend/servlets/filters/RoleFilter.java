package com.devlogs.masa_backend.servlets.filters;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.Masa.PAGE;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.servlets.common.RoleAndRequestMapper;
import com.devlogs.masa_backend.servlets.common.base.BaseServletFilter;
import com.devlogs.masa_backend.servlets.common.helpers.UrlHelper;
import com.devlogs.masa_backend.servlets.login.GoogleLoginState;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class RoleFilter extends BaseServletFilter {

    @Inject
    protected RoleAndRequestMapper roleAndRequestMapper;

    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
        MasaLog.normalLog("Auth Filter Init");
        getControllerComponent().inject(this);
    }

    public void doFilter(ServletRequest r,
                         ServletResponse rs,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) r;
        HttpServletResponse response = (HttpServletResponse) rs;
        request.setCharacterEncoding("UTF-8");
        MasaLog.normalLog("role check nha");
        Masa.onServerName(request.getProtocol(),request.getServerName(),request.getServerPort());

        UserEntity currentUser = (UserEntity) request.getSession(true).getAttribute(Masa.SESSION_KEY.USER);
        String requestedResource = UrlHelper.getResourceUrl(request.getRequestURI());
        if (currentUser != null) {
            // check role
            boolean isAllowed = roleAndRequestMapper.isAllowToAccess(currentUser.getRole(), requestedResource);
            if (isAllowed) {
                MasaLog.normalLog("Request role is: " + currentUser.getRole().getType().name() + " => ALLOWED");
                chain.doFilter(request, response);
            } else {
                MasaLog.normalLog("Request role is: " + currentUser.getRole().getType().name() + " => NOT ALLOWED TO ACCESS: " + requestedResource);
                // go to permission denied page
                response.sendRedirect(PAGE.AUTH.PERMISSION_MANAGEMENT.DENIED_PAGE);
            }
            return;
        }
        MasaLog.normalLog("Request role is: null but user it had been validated by auth filter");

        chain.doFilter(request, response);
    }
}
