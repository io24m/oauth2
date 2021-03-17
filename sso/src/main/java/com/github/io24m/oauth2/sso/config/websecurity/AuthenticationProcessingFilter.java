package com.github.io24m.oauth2.sso.config.websecurity;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 16:10
 */
public class AuthenticationProcessingFilter extends UsernamePasswordAuthenticationFilter {
    public static String USERNAME = "AUTHENTICATION_PROCESSING_FILTER_USERNAME";

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        String username = super.obtainUsername(request);
        request.setAttribute(USERNAME, username);
        return username;
    }
}
