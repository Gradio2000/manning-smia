package com.optimagrowth.license.utils;

import laskin.UserContext;
import laskin.UserContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



@Component
public class UserContextFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        UserContext context = UserContextHolder.getContext();
        context.setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
        context.setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
        context.setAuthToken(httpServletRequest.getHeader("Authorization"));
        context.setOrganizationId(httpServletRequest.getHeader(UserContext.ORGANIZATION_ID));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
