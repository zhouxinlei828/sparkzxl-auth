package com.github.sparkzxl.auth.domain.repository;


import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;

import java.util.List;

/**
 * description: 组织 仓储类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:32:24
 */
public interface ICoreOrgRepository {


    /**
     * 保存组织机构
     *
     * @param coreOrg 组织机构
     * @return boolean
     */
    boolean saveCoreOrg(CoreOrg coreOrg);

    /**
     * 更新组织架构
     *
     * @param coreOrg 组织信息
     * @return boolean
     */
    boolean updateCoreOrg(CoreOrg coreOrg);

    /**
     * 批量删除组织信息
     * @param ids 组织信息ids
     * @return boolean
     */
    boolean deleteBatchCoreOrg(List<Long> ids);

    /**
     * 获取组织信息列表
     * @param name 组织名称
     * @param status 状态
     * @return List<CoreOrg>
     */
    List<CoreOrg> getCoreOrgList(String name, Boolean status);
}
