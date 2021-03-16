package com.github.io24m.oauth2.sso.domain;

import lombok.Data;

/**
 * oauth_client_details
 *
 * @author
 */
@Data
public class OauthClientDetails {
    private String clientId;

    private String resourceIds;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;

    private String webServerRedirectUri;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;

    private String autoapprove;
}