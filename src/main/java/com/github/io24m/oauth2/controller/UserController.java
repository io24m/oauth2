package com.github.io24m.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("")
public class UserController {

    @RequestMapping({"/user/me", "/user/me/{appKey}", "/user/{appKey}"})
    public Principal info(Principal principal) {
        return principal;
    }

    @GetMapping("/user")
    public Principal getCurrentUser(Principal principal) {
        return principal;
    }

}
