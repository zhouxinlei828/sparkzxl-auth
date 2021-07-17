package com.github.sparkzxl.workflow.domain.repository;

import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;

import java.util.List;

/**
 * description: 流程用户仓储类
 *
 * @author zhouxinlei
 * @date 2021-07-17 19:15
 */
public interface IExtProcessUserRepository {

    /**
     * 根据角色id列表查询用户id列表
     *
     * @param roleIds 角色id
     * @return List<String>
     */
    List<String> findUserIdListByRoleIds(List<String> roleIds);

    /**
     * 根据id查询用户信息
     *
     * @param userId 用户id
     * @return ExtProcessUser
     */
    ExtProcessUser findUserById(String userId);
}
