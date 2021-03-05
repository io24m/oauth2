package com.github.io24m.oauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:55
 */
@RestController
@RequestMapping("")
public class HomeController {
    @RequestMapping("")
    public boolean index() {
        return true;
    }
}
