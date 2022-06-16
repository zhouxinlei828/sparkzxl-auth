package com.github.sparkzxl.auth.domain.model.aggregates;

import lombok.Data;

import java.util.List;

/**
 * description: 角色资源聚合
 *
 * @author charles.zhou
 * @since 2020-12-01 14:06:31
 */
@Data
public class RoleResource {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单列表
     */
    private List<Long> authMenus;

    /**
     * 资源列表
     */
    private List<Long> authResources;
}
