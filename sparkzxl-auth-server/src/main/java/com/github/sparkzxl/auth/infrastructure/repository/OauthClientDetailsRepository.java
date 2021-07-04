package com.github.sparkzxl.auth.infrastructure.repository;

import com.github.sparkzxl.auth.domain.repository.IOauthClientDetailsRepository;
import com.github.sparkzxl.auth.infrastructure.entity.OauthClientDetails;
import com.github.sparkzxl.auth.infrastructure.mapper.OauthClientDetailsMapper;
import com.github.sparkzxl.core.support.BizExceptionAssert;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description: 客户端 仓储实现类
 *
 * @author charles.zhou
 * @date   2021-02-20 09:54:44
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
        if (StringUtils.isEmpty(oauthClientDetails.getClientId())) {
            BizExceptionAssert.businessFail(400, "客户端id不能为空");
        }
        if (StringUtils.isEmpty(oauthClientDetails.getClientSecret())) {
            BizExceptionAssert.businessFail(400, "客户端id不能为空");
        }
        if (StringUtils.isEmpty(oauthClientDetails.getAuthorizedGrantTypes())) {
            BizExceptionAssert.businessFail(400, "授权类型不能为空");
        }
        if (ObjectUtils.isEmpty(oauthClientDetails.getAccessTokenValidity())) {
            BizExceptionAssert.businessFail(400, "令牌时效不能为空");
        }
        if (ObjectUtils.isEmpty(oauthClientDetails.getRefreshTokenValidity())) {
            BizExceptionAssert.businessFail(400, "令牌刷新时效不能为空");
        }
        String clientSecret = oauthClientDetails.getClientSecret();
        String encryptClientSecret = passwordEncoder.encode(clientSecret);
        oauthClientDetails.setClientSecret(encryptClientSecret);
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
        if (StringUtils.isEmpty(oauthClientDetails.getClientId())) {
            BizExceptionAssert.businessFail(400, "客户端id不能为空");
        }
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
