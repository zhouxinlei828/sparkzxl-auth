package com.github.sparkzxl.auth.application.service;


import com.github.sparkzxl.auth.domain.model.aggregates.MenuBasicInfo;
import com.github.sparkzxl.auth.infrastructure.entity.AuthMenu;
import com.github.sparkzxl.auth.domain.model.dto.menu.AuthMenuSaveDTO;
import com.github.sparkzxl.database.base.service.SuperService;

import java.util.List;

/**
 * description: 菜单 服务类
 *
 * @author charles.zhou
 * @since 2020-06-07 13:31:12
 */
public interface IMenuService extends SuperService<AuthMenu> {

    /**
     * 查询菜单tree
     *
     * @param label 菜单名称
     * @return List<AuthMenu>
     */
    List<AuthMenu> findMenuTree(String label);

    /**
     * 根据菜单id删除菜单
     *
     * @param ids 菜单ids
     * @return boolean
     */
    boolean deleteMenu(List<Long> ids);

    /**
     * 查询用户路由菜单
     *
     * @param userId 用户id
     * @return List<MenuBasicInfo>
     */
    List<MenuBasicInfo> routers(Long userId);

    /**
     * 保存菜单信息
     *
     * @param authMenuSaveDTO 菜单保存信息
     * @return boolean
     */
    boolean saveMenu(AuthMenuSaveDTO authMenuSaveDTO);
}
