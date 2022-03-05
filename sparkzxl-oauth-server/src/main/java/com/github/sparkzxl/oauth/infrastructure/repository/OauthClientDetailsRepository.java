package com.github.sparkzxl.oauth.infrastructure.repository;

import com.github.sparkzxl.core.util.ArgumentAssert;
import com.github.sparkzxl.oauth.domain.repository.IOauthClientDetailsRepository;
import com.github.sparkzxl.oauth.infrastructure.entity.OauthClientDetails;
import com.github.sparkzxl.oauth.infrastructure.mapper.OauthClientDetailsMapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description: 客户端 仓储实现类
 *
 * @author charles.zhou
 * @date 2021-02-20 09:54:44
 */
@Repository
public class OauthClientDetailsRepository implements IOauthClientDetailsRepository {

    @Autowired
    private OauthClientDetailsMapper clientDetailsMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOauthClientDetails(OauthClientDetails oauthClientDetails) {
        ArgumentAssert.notEmpty(oauthClientDetails.getClientId(), "客户端id不能为空");
        ArgumentAssert.notEmpty(oauthClientDetails.getClientSecret(), "客户端密钥不能为空");
        ArgumentAssert.notEmpty(oauthClientDetails.getAuthorizedGrantTypes(), "授权类型不能为空");
        ArgumentAssert.isNull(oauthClientDetails.getAccessTokenValidity(), "令牌时效不能为空");
        ArgumentAssert.isNull(oauthClientDetails.getRefreshTokenValidity(), "令牌刷新时效不能为空");
        oauthClientDetails.setClientSecret(passwordEncoder.encode(oauthClientDetails.getClientSecret()));
        clientDetailsMapper.insert(oauthClientDetails);
    }

    @Override
    public void deleteClient(List<String> ids) {
        clientDetailsMapper.deleteBatchIds(ids);
    }


    @Override
    public List<OauthClientDetails> findListByIdList(List<String> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            return clientDetailsMapper.selectBatchIds(ids);
        }
        return Lists.newArrayList();
    }

    @Override
    public void updateOauthClientDetails(OauthClientDetails oauthClientDetails) {
        ArgumentAssert.notEmpty(oauthClientDetails.getClientId(), "客户端id不能为空");
        OauthClientDetails clientDetails = clientDetailsMapper.selectById(oauthClientDetails.getClientId());
        String clientSecret = oauthClientDetails.getClientSecret();
        String encryptClientSecret = passwordEncoder.encode(clientSecret);
        oauthClientDetails.setClientSecret(encryptClientSecret);
        if (ObjectUtils.isEmpty(clientDetails)) {
            clientDetailsMapper.insert(oauthClientDetails);
        } else {
            clientDetailsMapper.updateById(oauthClientDetails);
        }
    }

    @Override
    public OauthClientDetails findById(String clientId) {
        return clientDetailsMapper.selectById(clientId);
    }
}
