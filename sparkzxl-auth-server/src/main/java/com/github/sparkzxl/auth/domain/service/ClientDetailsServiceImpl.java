package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.domain.repository.IOauthClientDetailsRepository;
import com.github.sparkzxl.auth.infrastructure.entity.OauthClientDetails;
import com.github.sparkzxl.core.jackson.JsonUtil;
import com.github.sparkzxl.core.utils.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * description: oauth 客户端应用管理
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
        OauthClientDetails oauthClientDetails = oauthClientDetailsRepository.findById(clientId);
        BaseClientDetails baseClientDetails = new BaseClientDetails(oauthClientDetails.getClientId(), oauthClientDetails.getResourceIds(),
                oauthClientDetails.getScope(), oauthClientDetails.getAuthorizedGrantTypes(), oauthClientDetails.getAuthorities(),
                oauthClientDetails.getWebServerRedirectUri());
        baseClientDetails.setClientSecret(oauthClientDetails.getClientSecret());
        baseClientDetails.setAccessTokenValiditySeconds(oauthClientDetails.getAccessTokenValidity());
        baseClientDetails.setRefreshTokenValiditySeconds(oauthClientDetails.getRefreshTokenValidity());
        String additionalInformation = oauthClientDetails.getAdditionalInformation();
        if (StringUtils.isNotBlank(additionalInformation)) {
            Map<String, Object> additionalInformationMap = JsonUtil.toMap(additionalInformation,Object.class);
            baseClientDetails.setAdditionalInformation(additionalInformationMap);
        }
        String scopes = oauthClientDetails.getAutoApprove();
        Optional.ofNullable(oauthClientDetails.getAutoApprove()).ifPresent(value -> baseClientDetails.setAutoApproveScopes(ListUtils.stringToList(scopes)));
        return baseClientDetails;
    }
}
