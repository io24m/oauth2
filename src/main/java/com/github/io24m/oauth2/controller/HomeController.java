package com.github.io24m.oauth2.controller;

import com.github.io24m.oauth2.config.Io24mProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:55
 */
@RestController
public class HomeController {
    @Autowired
    private Io24mProperties io24mProperties;

    @GetMapping("")
    public String index() {
        return io24mProperties.getName();
    }

}
