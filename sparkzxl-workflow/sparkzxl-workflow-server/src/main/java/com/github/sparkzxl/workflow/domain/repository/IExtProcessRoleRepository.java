package com.github.sparkzxl.workflow.domain.repository;

import java.util.List;

/**
 * description: 流程角色 仓储层
 *
 * @author charles.zhou
 * @since 2021-05-17 10:54:30
 */
public interface IExtProcessRoleRepository {

    /**
     * 保存角色用户
     *
     * @param roleId     角色id
     * @param userIdList 用户id列表
     * @return boolean
     */
    boolean saveRoleUser(Long roleId, List<Long> userIdList);
}
