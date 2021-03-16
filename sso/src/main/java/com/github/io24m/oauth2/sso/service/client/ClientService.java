package com.github.io24m.oauth2.sso.service.client;

import com.github.io24m.oauth2.sso.domain.OauthClientDetails;
import com.github.io24m.oauth2.sso.mapper.OauthClientDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * @author lk1
 * @description
 * @create 2021-03-05 15:20
 */
@Service
public class ClientService implements ClientDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OauthClientDetails oauthClientDetails = oauthClientDetailsMapper.selectByPrimaryKey(clientId);
        if (oauthClientDetails == null) {
            throw new ClientRegistrationException("clientId not register");
        }
        oauthClientDetails.setClientSecret(passwordEncoder.encode(oauthClientDetails.getClientSecret()));
        return new Client(oauthClientDetails);
    }
}
