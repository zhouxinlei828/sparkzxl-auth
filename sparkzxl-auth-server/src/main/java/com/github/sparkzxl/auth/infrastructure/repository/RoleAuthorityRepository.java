package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.application.event.RoleResourceEvent;
import com.github.sparkzxl.auth.domain.model.aggregates.ResourceSource;
import com.github.sparkzxl.auth.domain.model.aggregates.RoleResource;
import com.github.sparkzxl.auth.domain.repository.IRoleAuthorityRepository;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.enums.OperationEnum;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthUserMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.core.context.BaseContextHandler;
import com.github.sparkzxl.core.spring.SpringContextUtils;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description: 角色资源绑定 仓储实现类
 *
 * @author charles.zhou
 * @date   2020-08-15 11:14:18
 */
@Repository
public class RoleAuthorityRepository implements IRoleAuthorityRepository {

    private RoleAuthorityMapper roleAuthorityMapper;
    private AuthUserMapper authUserMapper;
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRoleAuthorityMapper(RoleAuthorityMapper roleAuthorityMapper) {
        this.roleAuthorityMapper = roleAuthorityMapper;
    }

    @Autowired
    public void setAuthUserMapper(AuthUserMapper authUserMapper) {
        this.authUserMapper = authUserMapper;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean saveRoleAuthorityBatch(Long roleId, Set<Long> resourceIds, Set<Long> menuIds) {
        String tenantCode = BaseContextHandler.getTenant();
        List<RoleAuthority> roleAuthorities = Lists.newLinkedList();
        roleAuthorityMapper.delete(new LambdaUpdateWrapper<RoleAuthority>()
                .eq(RoleAuthority::getRoleId, roleId));
        if (CollectionUtils.isNotEmpty(resourceIds)) {
            resourceIds.forEach(authorityId -> {
                RoleAuthority roleAuthority = new RoleAuthority();
                roleAuthority.setRoleId(roleId);
                roleAuthority.setAuthorityId(authorityId);
                roleAuthority.setAuthorityType("RESOURCE");
                roleAuthority.setTenantCode(tenantCode);
                roleAuthorities.add(roleAuthority);
            });
        }
        if (CollectionUtils.isNotEmpty(menuIds)) {
            menuIds.forEach(menuId -> {
                RoleAuthority roleAuthority = new RoleAuthority();
                roleAuthority.setRoleId(roleId);
                roleAuthority.setAuthorityId(menuId);
                roleAuthority.setAuthorityType("MENU");
                roleAuthority.setTenantCode(tenantCode);
                roleAuthorities.add(roleAuthority);
            });
        }
        if (CollectionUtils.isNotEmpty(roleAuthorities)) {
            roleAuthorityMapper.insertBatchSomeColumn(roleAuthorities);
        }
        SpringContextUtils.publishEvent(new RoleResourceEvent(new ResourceSource(OperationEnum.SAVE, null, null)));
        return true;
    }

    @Override
    public RoleResource getRoleResource(Long roleId) {
        RoleResource roleResource = new RoleResource();
        roleResource.setRoleId(roleId);
        List<RoleAuthority> roleAuthorities = roleAuthorityMapper.selectList(new LambdaQueryWrapper<RoleAuthority>()
                .eq(RoleAuthority::getRoleId, roleId));
        List<Long> authMenus = Lists.newArrayList();
        List<Long> authResources = Lists.newArrayList();
        Map<String, List<RoleAuthority>> roleAuthorityMap = roleAuthorities.stream().collect(Collectors.groupingBy(RoleAuthority::getAuthorityType));
        List<RoleAuthority> resourceList = roleAuthorityMap.get("RESOURCE");
        if (CollectionUtils.isNotEmpty(resourceList)) {
            authResources = resourceList.stream().map(RoleAuthority::getAuthorityId).collect(Collectors.toList());
        }
        roleResource.setAuthResources(authResources);
        List<RoleAuthority> menuList = roleAuthorityMap.get("MENU");
        if (CollectionUtils.isNotEmpty(menuList)) {
            authMenus = menuList.stream().map(RoleAuthority::getAuthorityId).collect(Collectors.toList());
        }
        roleResource.setAuthMenus(authMenus);
        return roleResource;
    }

    @Override
    public boolean refreshAuthority() {
        redisTemplate.delete(CacheConstant.RESOURCE_ROLES_MAP);
        List<com.github.sparkzxl.auth.infrastructure.entity.RoleResource> roleResources = authUserMapper.getRoleResourceList();
        Map<String, Object> roleResourceMap = roleResources.stream().collect(Collectors.toMap(com.github.sparkzxl.auth.infrastructure.entity.RoleResource::getPath, com.github.sparkzxl.auth.infrastructure.entity.RoleResource::getRoleCode));
        redisTemplate.opsForHash().putAll(CacheConstant.RESOURCE_ROLES_MAP, roleResourceMap);
        return true;
    }
}
