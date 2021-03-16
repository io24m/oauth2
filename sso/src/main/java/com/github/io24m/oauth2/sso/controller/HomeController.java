package com.github.io24m.oauth2.sso.controller;

import com.github.io24m.oauth2.sso.config.Io24mProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:55
 */
@Controller
public class HomeController {
    @Autowired
    private Io24mProperties io24mProperties;

    @GetMapping("")
    public String index(HttpServletRequest request) {
        if (null == io24mProperties.getIndexPage() || "".equals(io24mProperties.getIndexPage()))
            return "index";
        return "redirect:" + io24mProperties.getIndexPage();
    }

}
