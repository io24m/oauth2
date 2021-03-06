package com.github.io24m.oauth2.config.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:29
 */
@Component
@Slf4j
public class CustomAuthExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Throwable cause = e.getCause();
//        response.setContentType("application/json;charset=UTF-8");
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        // CORS "pre-flight" request
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Cache-Control", "no-cache");
//        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        response.addHeader("Access-Control-Max-Age", "1800");
        if (cause instanceof InvalidTokenException) {
            //log.error("InvalidTokenException : {}", cause.getMessage());
            //Token无效
            response.getWriter().write("Token无效");
        } else {
            //log.error("AuthenticationException : NoAuthentication");
            //资源未授权
            response.getWriter().write("NoAuthentication");
        }
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        //访问资源的用户权限不足
        //log.error("AccessDeniedException : {}", e.getMessage());
        response.getWriter().write("NoAuthentication");
    }
}
