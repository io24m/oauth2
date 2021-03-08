package com.github.io24m.oauth2.service.client;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 15:21
 */
public class Client implements ClientDetails {
    @Override
    public String getClientId() {
        return "testclient";
    }

    @Override
    public String getClientSecret() {
        return "testclient";
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<>(Arrays.asList("read"));
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return new HashSet<>(Arrays.asList("authorization_code", "refresh_token", "client_credentials"));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return new HashSet<>(Arrays.asList(
                "http://localhost:9001/test",
                "http://localhost:8091/login",
                "http://localhost:30170/login",
                "http://localhost:2790/AccountSso/JavaLogin"
        ));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("AUTHENTICATION_SERVICE"));
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 3600;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 3600;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
