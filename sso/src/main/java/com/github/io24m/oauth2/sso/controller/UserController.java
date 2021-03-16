package com.github.io24m.oauth2.sso.controller;

import com.github.io24m.oauth2.sso.service.user.User;
import com.github.io24m.oauth2.sso.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public Principal getCurrentUser(Principal principal) {
        OAuth2Authentication auth = (OAuth2Authentication) principal;
        if (auth.getUserAuthentication() == null) {
            return principal;
        }
        User user;
        if (ClassUtils.isAssignable(auth.getUserAuthentication().getPrincipal().getClass(), User.class)) {
            user = (User) (auth.getUserAuthentication().getPrincipal());
        } else {
            user = (User) userService.loadUserByUsername(auth.getUserAuthentication().getPrincipal().toString());
        }
//        user.setUserPassword(null);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(x.getValidateCode()));

        Principal token = new UsernamePasswordAuthenticationToken(user, auth.getUserAuthentication().getCredentials(), authorities);

//        if (ClassUtils.isAssignable(auth.getDetails().getClass(), OAuth2AuthenticationDetails.class)) {
//            String msg = "ip=" + ((OAuth2AuthenticationDetails) auth.getDetails()).getRemoteAddress() + ";clientId=" + auth.getOAuth2Request().getClientId();
//
//        }
        return token;
    }

}
