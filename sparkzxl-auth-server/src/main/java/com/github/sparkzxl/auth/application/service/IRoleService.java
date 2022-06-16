package com.github.sparkzxl.auth.application.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.domain.model.dto.role.RoleQueryDTO;
import com.github.sparkzxl.auth.domain.model.dto.role.RoleSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.role.RoleUpdateDTO;
import com.github.sparkzxl.database.base.service.SuperService;
import com.github.sparkzxl.dto.PageParams;

import java.util.List;

/**
 * description: 角色 服务类
 *
 * @author charles.zhou
 * @since 2020-06-07 13:31:48
 */
public interface IRoleService extends SuperService<AuthRole> {

    /**
     * 分页查询角色信息
     *
     * @param params 分页查询
     * @return Page<AuthRole>
     */
    Page<AuthRole> getPageList(PageParams<RoleQueryDTO> params);

    /**
     * 删除角色信息
     *
     * @param ids ids
     */
    void deleteAuthRoleRelation(List<Long> ids);

    /**
     * 更新角色状态
     *
     * @param roleId 角色id
     * @param status 状态
     * @return boolean
     */
    boolean updateAuthRoleStatus(Long roleId, Boolean status);

    /**
     * 保存角色信息
     *
     * @param roleSaveDTO 角色保存
     * @return boolean
     */
    boolean saveRole(RoleSaveDTO roleSaveDTO);

    /**
     * 更新角色
     *
     * @param roleUpdateDTO 角色更新
     * @return boolean
     */
    boolean updateRole(RoleUpdateDTO roleUpdateDTO);
}
