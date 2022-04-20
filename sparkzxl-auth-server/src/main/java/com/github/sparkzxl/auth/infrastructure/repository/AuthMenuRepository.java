package com.github.sparkzxl.auth.infrastructure.repository;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.domain.model.aggregates.MenuBasicInfo;
import com.github.sparkzxl.auth.domain.repository.IAuthMenuRepository;
import com.github.sparkzxl.auth.domain.repository.ISegmentIdRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthMenu;
import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.entity.UserRole;
import com.github.sparkzxl.auth.domain.model.enums.AuthorityTypeEnum;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthMenuMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.UserRoleMapper;
import com.github.sparkzxl.core.tree.TreeUtils;
import com.github.sparkzxl.entity.data.SuperEntity;
import com.github.sparkzxl.entity.data.TreeEntity;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: 菜单 仓储层实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:31:12
 */
@Repository
public class AuthMenuRepository implements IAuthMenuRepository {

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private AuthMenuMapper authMenuMapper;
    @Autowired
    private ISegmentIdRepository segmentRepository;
    @Autowired
    private AuthResourceRepository authResourceRepository;


    @Override
    public List<MenuBasicInfo> getAuthMenuList(Long userId) {
        List<MenuBasicInfo> menuBasicInfoList = Lists.newArrayList();
        List<Long> roleIds = userRoleMapper.selectList(new LambdaUpdateWrapper<UserRole>()
                        .eq(UserRole::getUserId, userId)).stream().map(UserRole::getRoleId)
                .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(roleIds)) {
            List<RoleAuthority> roleAuthorities =
                    roleAuthorityMapper.selectList(new LambdaQueryWrapper<RoleAuthority>().in(RoleAuthority::getRoleId, roleIds));
            List<Long> menuIds = roleAuthorities.stream().filter(x -> AuthorityTypeEnum.MENU.name().equals(x.getAuthorityType()))
                    .distinct()
                    .map(RoleAuthority::getAuthorityId).collect(Collectors.toList());

            if (CollectionUtils.isNotEmpty(menuIds)) {
                List<AuthMenu> menuList = authMenuMapper.selectBatchIds(menuIds);
                buildMenuBasicInfo(menuBasicInfoList, menuList);
            }
        }
        return TreeUtils.buildTree(menuBasicInfoList);
    }

    private void buildMenuBasicInfo(List<MenuBasicInfo> menuBasicInfoList, List<AuthMenu> menuList) {
        menuList = menuList.stream().sorted(Comparator.comparing(AuthMenu::getSortNumber)).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(menuList)) {
            menuList.forEach(menu -> {
                MenuBasicInfo menuBasicInfo = new MenuBasicInfo();
                menuBasicInfo.setId(menu.getId());
                menuBasicInfo.setLabel(menu.getLabel());
                menuBasicInfo.setIcon(menu.getIcon());
                menuBasicInfo.setPath(menu.getPath());
                menuBasicInfo.setRedirect(menu.getRedirect());
                menuBasicInfo.setComponent(menu.getComponent());
                menuBasicInfo.setComponentName(menu.getComponentName());
                menuBasicInfo.setHidden(menu.isHidden());
                menuBasicInfo.setNoKeepAlive(menu.isNoKeepAlive());
                menuBasicInfo.setParentId(menu.getParentId());
                menuBasicInfo.setSortNumber(menu.getSortNumber());
                menuBasicInfoList.add(menuBasicInfo);
            });
        }
    }

    @Override
    public boolean saveMenu(AuthMenu authMenu) {
        long id = segmentRepository.getSegmentId("auth_menu").longValue();
        authMenu.setId(id);
        return authMenuMapper.insert(authMenu) == 1;
    }

    @Override
    public boolean deleteMenu(List<Long> ids) {
        List<Long> authorityIds = Lists.newArrayList();
        authorityIds.addAll(ids);
        List<AuthResource> authResources = authResourceRepository.authResourceList(ids);
        List<Long> resourceIds = authResources.stream().map(SuperEntity::getId).collect(Collectors.toList());
        authResourceRepository.deleteResource(resourceIds);
        authorityIds.addAll(resourceIds);
        roleAuthorityMapper.delete(new LambdaQueryWrapper<RoleAuthority>().in(RoleAuthority::getAuthorityId, authorityIds));
        return authMenuMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public List<AuthMenu> findMenuTree(String label) {
        LambdaQueryWrapper<AuthMenu> menuLambdaQueryWrapper = new LambdaQueryWrapper<>();
        menuLambdaQueryWrapper.likeLeft(StringUtils.isNotEmpty(label), TreeEntity::getLabel, label)
                .orderByAsc(TreeEntity::getSortNumber);
        List<AuthMenu> authMenuList = authMenuMapper.selectList(menuLambdaQueryWrapper);
        if (CollectionUtils.isNotEmpty(authMenuList)) {
            List<Long> menuIdList = authMenuList.stream().map(SuperEntity::getId).collect(Collectors.toList());
            List<AuthResource> authResources = authResourceRepository.authResourceList(menuIdList);
            Map<Long, List<AuthResource>> resourceMap = authResources.stream().collect(Collectors.groupingBy(AuthResource::getMenuId));
            authMenuList.forEach(authMenu -> {
                List<AuthResource> resourceList = resourceMap.get(authMenu.getId());
                if (CollectionUtils.isNotEmpty(resourceList)) {
                    authMenu.setResourceList(resourceList);
                }
            });
        }
        return authMenuList;
    }
}
