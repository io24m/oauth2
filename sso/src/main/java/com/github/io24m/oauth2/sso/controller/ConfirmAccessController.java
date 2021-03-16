package com.github.io24m.oauth2.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lk1
 * @description
 * @create 2021-03-16 17:16
 */
@Controller
@SessionAttributes({"authorizationRequest"})
public class ConfirmAccessController {
    @RequestMapping("/oauth/confirm_access")
    public String getAccessConfirmation(Model model, HttpServletRequest request) throws Exception {

//        @SuppressWarnings("unchecked")
//        Map<String, String> scopes = (Map<String, String>) (model.containsKey("scopes") ? model.get("scopes") : request.getAttribute("scopes"));
//        List<String> scopeList = new ArrayList<>();
//        if (scopes != null) {
//            scopeList.addAll(scopes.keySet());
//        }
//        model.put("scopeList", scopeList);
        return "confirm_access";
    }
}
