package com.github.io24m.oauth2.sso.service.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 14:14
 */
public class User implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return "lky";
    }

    @Override
    public String getPassword() {
        //lky123
        return "$2a$10$65oVg7lO3WJi7wi2OFD2jOmCiyYcF94nymvCcHGTB/3V89KuGw2S.";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
