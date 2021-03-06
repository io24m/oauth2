package com.github.io24m.oauth2.service.client;

import org.springframework.security.core.GrantedAuthority;
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
        return "test-client";
    }

    @Override
    public String getClientSecret() {
        return "test-client";
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
        return true;
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<>(Arrays.asList("read"));
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return new HashSet<>(Arrays.asList("authorization_code", "client_credentials"));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return new HashSet<>(Collections.singletonList("http://localhost:9001/test"));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return null;
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
