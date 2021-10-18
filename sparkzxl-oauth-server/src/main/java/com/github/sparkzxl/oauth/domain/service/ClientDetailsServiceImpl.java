package com.github.sparkzxl.oauth.domain.service;

import com.github.sparkzxl.constant.AppContextConstants;
import com.github.sparkzxl.core.context.AppContextHolder;
import com.github.sparkzxl.core.jackson.JsonUtil;
import com.github.sparkzxl.core.utils.RequestContextHolderUtils;
import com.github.sparkzxl.oauth.domain.repository.IOauthClientDetailsRepository;
import com.github.sparkzxl.oauth.infrastructure.entity.OauthClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    private IOauthClientDetailsRepository clientDetailsRepository;

    @Autowired
    public void setClientDetailsRepository(IOauthClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        String tenant = AppContextHolder.getTenant();
        if (StringUtils.isEmpty(tenant)) {
            AppContextHolder.setTenant(RequestContextHolderUtils.getRequest().getHeader(AppContextConstants.TENANT_ID));
        }
        OauthClientDetails oauthClientDetails = clientDetailsRepository.findById(clientId);
        BaseClientDetails baseClientDetails = new BaseClientDetails(oauthClientDetails.getClientId(), oauthClientDetails.getResourceIds(),
                oauthClientDetails.getScope(), oauthClientDetails.getAuthorizedGrantTypes(), oauthClientDetails.getAuthorities(),
                oauthClientDetails.getWebServerRedirectUri());
        baseClientDetails.setClientSecret(oauthClientDetails.getClientSecret());
        baseClientDetails.setAccessTokenValiditySeconds(oauthClientDetails.getAccessTokenValidity());
        baseClientDetails.setRefreshTokenValiditySeconds(oauthClientDetails.getRefreshTokenValidity());
        String additionalInformation = oauthClientDetails.getAdditionalInformation();
        if (!StringUtils.isEmpty(additionalInformation)) {
            Map<String, Object> additionalInformationMap = JsonUtil.toMap(additionalInformation, Object.class);
            baseClientDetails.setAdditionalInformation(additionalInformationMap);
        }
        String autoApproveScopes = oauthClientDetails.getAutoApprove();
        Optional.ofNullable(oauthClientDetails.getAutoApprove()).ifPresent(value -> baseClientDetails.setAutoApproveScopes(StringUtils.commaDelimitedListToSet(autoApproveScopes)));
        return baseClientDetails;
    }
}
