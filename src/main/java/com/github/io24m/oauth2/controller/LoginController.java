package com.github.io24m.oauth2.controller;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:50
 */
@Controller
public class LoginController {
    @GetMapping({"/login"})
    public String login(Model model, HttpServletRequest request) {
        AuthenticationException exception = (AuthenticationException) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if (exception != null) {
            String message = exception.getMessage();
            model.addAttribute("errorMessage", "用户名或密码错误");
//            if (ClassUtils.isAssignable(exception.getClass(), AccountExpiredException.class)) {
//                request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//                return "update_pwd";
//            }
        }
        return "login";
    }
}
