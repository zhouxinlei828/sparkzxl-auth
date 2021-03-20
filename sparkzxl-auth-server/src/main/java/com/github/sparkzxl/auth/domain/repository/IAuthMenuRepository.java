package com.github.sparkzxl.auth.domain.repository;


import com.github.sparkzxl.auth.domain.model.aggregates.MenuBasicInfo;
import com.github.sparkzxl.auth.infrastructure.entity.AuthMenu;

import java.util.List;

/**
 * description: 菜单 仓储类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:31:12
 */
public interface IAuthMenuRepository {

    /**
     * 获取菜单列表
     *
     * @param userId    用户id
     * @param realmCode 领域code
     * @return List<MenuBasicInfo>
     */
    List<MenuBasicInfo> getAuthMenuList(Long userId, String realmCode);

    /**
     * 保存菜单信息
     *
     * @param authMenus 菜单集合
     * @param realmCode 领域池code
     */
    void saveAuthMenus(List<AuthMenu> authMenus, String realmCode);

    /**
     * 查询菜单列表
     *
     * @return List<AuthMenu>
     */
    List<AuthMenu> findAuthMenuList();

    /**
     * 根据领域池code删除菜单
     *
     * @param realmCode 领域池code
     */
    void deleteTenantMenu(String realmCode);

    /**
     * 保存菜单信息
     *
     * @param authMenu 菜单
     * @return boolean
     */
    boolean saveMenu(AuthMenu authMenu);

    /**
     * 删除菜单
     *
     * @param ids 菜单id列表
     * @return boolean
     */
    boolean deleteMenu(List<Long> ids);

    /**
     * 查询菜单tree
     *
     * @param label 菜单名称
     * @return List<AuthMenu>
     */
    List<AuthMenu> findMenuTree(String label);
}
