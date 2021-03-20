package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.application.event.RoleResourceEvent;
import com.github.sparkzxl.auth.domain.model.aggregates.ResourceSource;
import com.github.sparkzxl.auth.domain.model.aggregates.RoleResource;
import com.github.sparkzxl.auth.domain.repository.IRoleAuthorityRepository;
import com.github.sparkzxl.auth.infrastructure.constant.CacheConstant;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.entity.RoleResourceInfo;
import com.github.sparkzxl.auth.infrastructure.enums.OperationEnum;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthUserMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.core.context.BaseContextHandler;
import com.github.sparkzxl.core.spring.SpringContextUtils;
import com.github.sparkzxl.core.utils.BuildKeyUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
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
 * @date 2020-08-15 11:14:18
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
        String realmCode = BaseContextHandler.getRealm();
        List<RoleAuthority> roleAuthorities = Lists.newLinkedList();
        roleAuthorityMapper.delete(new LambdaUpdateWrapper<RoleAuthority>()
                .eq(RoleAuthority::getRoleId, roleId));
        if (CollectionUtils.isNotEmpty(resourceIds)) {
            resourceIds.forEach(authorityId -> {
                RoleAuthority roleAuthority = new RoleAuthority();
                roleAuthority.setRoleId(roleId);
                roleAuthority.setAuthorityId(authorityId);
                roleAuthority.setAuthorityType("RESOURCE");
                roleAuthority.setRealmCode(realmCode);
                roleAuthorities.add(roleAuthority);
            });
        }
        if (CollectionUtils.isNotEmpty(menuIds)) {
            menuIds.forEach(menuId -> {
                RoleAuthority roleAuthority = new RoleAuthority();
                roleAuthority.setRoleId(roleId);
                roleAuthority.setAuthorityId(menuId);
                roleAuthority.setAuthorityType("MENU");
                roleAuthority.setRealmCode(realmCode);
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
        List<RoleResourceInfo> roleResources = authUserMapper.getRoleResourceList();
        Map<String, List<RoleResourceInfo>> roleResourceInfoMap =
                roleResources.stream().collect(Collectors.groupingBy(RoleResourceInfo::getRealmCode));
        if (MapUtils.isNotEmpty(roleResourceInfoMap)) {
            for (String realmCode : roleResourceInfoMap.keySet()) {
                List<RoleResourceInfo> roleResourceInfos = roleResourceInfoMap.get(realmCode);
                if (CollectionUtils.isNotEmpty(roleResourceInfos)) {
                    Map<String, Object> roleResourceMap = Maps.newHashMap();
                    roleResourceInfos.forEach(roleResourceInfo -> roleResourceMap.put(roleResourceInfo.getPath(),
                            roleResourceInfo.getRoleCode().concat(",").concat("REALM_MANAGER")));
                    redisTemplate.opsForHash().putAll(BuildKeyUtils.generateKey(CacheConstant.RESOURCE_ROLES_MAP, realmCode), roleResourceMap);
                }
            }
        }
        return true;
    }

    @Override
    public void refreshAuthority(String oldVal, String newVal) {
        String realmCode = BaseContextHandler.getRealm();
        String cacheKey = BuildKeyUtils.generateKey(CacheConstant.RESOURCE_ROLES_MAP, realmCode);
        redisTemplate.opsForHash().delete(cacheKey, oldVal);
        RoleResourceInfo roleResource = authUserMapper.getRoleResource(newVal);
        redisTemplate.opsForHash().put(cacheKey, roleResource.getPath(), roleResource.getRoleCode());
    }

    @Override
    public void refreshAuthority(String oldVal) {
        String realmCode = BaseContextHandler.getRealm();
        String cacheKey = BuildKeyUtils.generateKey(CacheConstant.RESOURCE_ROLES_MAP, realmCode);
        redisTemplate.opsForHash().delete(cacheKey, oldVal);
    }
}
