package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.domain.repository.IOauthClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-07-03 15:28:51
*/
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private IOauthClientDetailsRepository oauthClientDetailsRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return oauthClientDetailsRepository.findById(clientId);
    }
}
