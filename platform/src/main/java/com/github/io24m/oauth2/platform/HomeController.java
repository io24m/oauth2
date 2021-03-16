package com.github.io24m.oauth2.platform;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2021-03-16 10:50
 */
@RestController
@RequestMapping
public class HomeController {
    @GetMapping("")
    public boolean index() {
//        org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2SsoDefaultConfiguration
        return true;
    }
}
