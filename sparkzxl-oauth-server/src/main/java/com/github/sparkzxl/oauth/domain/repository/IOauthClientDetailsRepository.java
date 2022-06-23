package com.github.sparkzxl.oauth.domain.repository;


import com.github.sparkzxl.oauth.infrastructure.entity.OauthClientDetails;

import java.util.List;

/**
 * description: 客户端 仓储类
 *
 * @author charles.zhou
 * @since 2021-02-20 09:51:03
 */
public interface IOauthClientDetailsRepository {

    /**
     * 保存客户端
     *
     * @param oauthClientDetails 应用客户端
     */
    void saveOauthClientDetails(OauthClientDetails oauthClientDetails);

    /**
     * 删除客户端
     *
     * @param ids id列表
     */
    void deleteClient(List<String> ids);

    /**
     * 更新客户端信息
     *
     * @param oauthClientDetails 客户端信息
     */
    void updateOauthClientDetails(OauthClientDetails oauthClientDetails);

    /**
     * 查询客户端列表
     *
     * @param ids id列表
     * @return List<OauthClientDetails>
     */
    List<OauthClientDetails> findListByIdList(List<String> ids);

    /**
     * 查询客户端列表
     *
     * @param clientId 客户端id
     * @return List<OauthClientDetails>
     */
    OauthClientDetails findById(String clientId);
}
