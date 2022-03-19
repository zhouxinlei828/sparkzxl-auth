package com.github.sparkzxl.auth.domain.repository;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;

import java.util.List;

/**
 * description: 角色 仓储类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:31:48
 */
public interface IAuthRoleRepository {

    /**
     * 删除角色以及关联信息
     *
     * @param ids ids
     */
    void deleteAuthRoleRelation(List<Long> ids);

    /**
     * 保存角色
     *
     * @param authRole 角色信息
     * @return boolean
     */
    boolean saveRole(AuthRole authRole);

    /**
     * 更新角色信息
     *
     * @param authRole 角色信息
     * @return boolean
     */
    boolean updateRole(AuthRole authRole);

    /**
     * 分页查询角色列表
     *
     * @param pageNum  当前页
     * @param pageSize 分页大小
     * @param code     角色编码
     * @param name     角色名称
     * @return List<AuthRole>
     */
    Page<AuthRole> getPageList(int pageNum, int pageSize, String code, String name);
}
