package com.github.io24m.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:50
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
