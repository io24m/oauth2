package com.github.io24m.oauth2.sso.service.client;

import com.github.io24m.oauth2.sso.domain.OauthClientDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 15:21
 */
public class Client implements ClientDetails {

    private OauthClientDetails oauthClientDetails;

    public Client(OauthClientDetails oauthClientDetails) {
        this.oauthClientDetails = oauthClientDetails;
    }

    @Override
    public String getClientId() {
        return oauthClientDetails.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        if (StringUtils.isEmpty(oauthClientDetails.getResourceIds())) {
            return new HashSet<>();
        }
        return new HashSet<>(Arrays.asList(oauthClientDetails.getResourceIds().split(",")));
    }

    @Override
    public boolean isSecretRequired() {

        return false;
    }

    @Override
    public String getClientSecret() {
        return oauthClientDetails.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return !CollectionUtils.isEmpty(getScope());
    }

    @Override
    public Set<String> getScope() {
        if (StringUtils.isEmpty(oauthClientDetails.getScope())) {
            return new HashSet<>();
        }
        return new HashSet<>(Arrays.asList(oauthClientDetails.getScope().split(",")));
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        if (StringUtils.isEmpty(oauthClientDetails.getAuthorizedGrantTypes())) {
            return new HashSet<>();
        }
        return new HashSet<>(Arrays.asList(oauthClientDetails.getAuthorizedGrantTypes().split(",")));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        if (StringUtils.isEmpty(oauthClientDetails.getWebServerRedirectUri())) {
            return new HashSet<>();
        }
        return new HashSet<>(Arrays.asList(oauthClientDetails.getWebServerRedirectUri().split(",")));

    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        if (StringUtils.isEmpty(oauthClientDetails.getAuthorities())) {
            return new HashSet<>();
        }
        Set<GrantedAuthority> a = new HashSet<>();
        for (String authority : oauthClientDetails.getAuthorities().split(",")) {
            a.add(new SimpleGrantedAuthority(authority));
        }
        return a;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return oauthClientDetails.getAccessTokenValidity();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return oauthClientDetails.getRefreshTokenValidity();
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return "1".equals(oauthClientDetails.getAutoapprove());
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
