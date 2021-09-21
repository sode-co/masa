package com.devlogs.masa_backend.servlets.filters;

import com.devlogs.masa_backend.common.Masa;
import com.devlogs.masa_backend.common.helper.MasaLog;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "InitFilter", urlPatterns = "/*")
public class InitFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        MasaLog.normalLog("Init nha");
        Masa.onServerName(request.getProtocol(),request.getServerName(),request.getServerPort());
        chain.doFilter(request, response);
    }
}
