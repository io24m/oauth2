package com.github.io24m.oauth2.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2021-03-16 13:16
 */
@RestController
@RequestMapping
public class HomeController {
    @GetMapping("")
    public boolean index() {
        return true;
    }
}
