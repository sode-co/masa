package com.devlogs.masa_backend.servlets.filters;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.helper.MasaLog;
import com.devlogs.masa_backend.domain.entities.UserEntity;
import com.devlogs.masa_backend.servlets.common.ResponseHelper;
import com.devlogs.masa_backend.servlets.common.RoleAndRequestMapper;
import com.devlogs.masa_backend.servlets.common.base.BaseServletFilter;
import com.devlogs.masa_backend.servlets.common.helpers.UrlHelper;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.devlogs.masa_backend.common.Masa.PAGE.AUTH.PERMISSION_MANAGEMENT.DENIED_PAGE;

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
                if (requestedResource.isEmpty()) {
                     switch (currentUser.getRole().getType()) {
                        case ADMIN: {
                            response.sendRedirect(Masa.PAGE.ADMIN.USER_MANAGEMENT_PAGE);
                            break;
                        }
                        case STUDENT: {
                            response.sendRedirect(Masa.PAGE.STUDENT.MEETING_PAGE);
                            break;
                        }
                        case GUEST: {
                            response.sendRedirect(Masa.PAGE.GUEST.WELCOME);
                            break;
                        }
                        case MENTOR: {
                            response.sendRedirect(Masa.PAGE.MENTOR.MEETING_PAGE);
                            break;
                        }
                    }
                    return;
                }
                chain.doFilter(request, response);
            } else {
                MasaLog.normalLog("Request role is: " + currentUser.getRole().getType().name() + " => NOT ALLOWED TO ACCESS: " + requestedResource);
                // go to permission denied page
                if (requestedResource.contains("api")) {
                    // this is request api
                    new ResponseHelper(response).responseMessage(400, "Permission denied");
                } else {
                    // this is page
                    response.sendRedirect(Masa.SERVER_HOST +  "/"+  DENIED_PAGE);
                }
            }
            return;
        }
        MasaLog.normalLog("Request role is: null but user it had been validated by auth filter");

        chain.doFilter(request, response);
    }
}
