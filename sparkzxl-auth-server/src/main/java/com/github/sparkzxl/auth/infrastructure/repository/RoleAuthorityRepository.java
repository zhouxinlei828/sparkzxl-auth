package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.application.event.RoleResourceEvent;
import com.github.sparkzxl.auth.domain.model.aggregates.ResourceSource;
import com.github.sparkzxl.auth.domain.model.aggregates.RoleResource;
import com.github.sparkzxl.auth.domain.repository.IAuthResourceRepository;
import com.github.sparkzxl.auth.domain.repository.IRoleAuthorityRepository;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.entity.RoleResourceInfo;
import com.github.sparkzxl.auth.infrastructure.enums.OperationEnum;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthUserMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.core.spring.SpringContextUtils;
import com.github.sparkzxl.core.utils.BuildKeyUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
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
    private IAuthResourceRepository resourceRepository;

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

    @Autowired
    public void setResourceRepository(IAuthResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public boolean saveRoleAuthorityBatch(Long roleId, Set<Long> resourceIds, Set<Long> menuIds) {
        String tenantId = BaseContextHolder.getTenant();
        List<RoleAuthority> roleAuthorities = Lists.newLinkedList();
        roleAuthorityMapper.delete(new LambdaUpdateWrapper<RoleAuthority>()
                .eq(RoleAuthority::getRoleId, roleId));
        if (CollectionUtils.isNotEmpty(resourceIds)) {
            resourceIds.forEach(authorityId -> {
                RoleAuthority roleAuthority = new RoleAuthority();
                roleAuthority.setRoleId(roleId);
                roleAuthority.setAuthorityId(authorityId);
                roleAuthority.setAuthorityType("RESOURCE");
                roleAuthorities.add(roleAuthority);
            });
        }
        if (CollectionUtils.isNotEmpty(menuIds)) {
            menuIds.forEach(menuId -> {
                RoleAuthority roleAuthority = new RoleAuthority();
                roleAuthority.setRoleId(roleId);
                roleAuthority.setAuthorityId(menuId);
                roleAuthority.setAuthorityType("MENU");
                roleAuthorities.add(roleAuthority);
            });
        }
        if (CollectionUtils.isNotEmpty(roleAuthorities)) {
            roleAuthorityMapper.insertBatchSomeColumn(roleAuthorities);
        }
        SpringContextUtils.publishEvent(new RoleResourceEvent(new ResourceSource(OperationEnum.SAVE, null, null, tenantId)));
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
    public boolean refreshAuthorityList(String tenantId) {
        List<AuthResource> authResourceList = resourceRepository.getResourceList();
        if (CollectionUtils.isNotEmpty(authResourceList)) {
            String generateCacheKey = BuildKeyUtils.generateKey(BizConstant.RESOURCE_ROLES_MAP, tenantId);
            Map<String, String> resourceMap = Maps.newHashMap();
            authResourceList.forEach(authResource -> {
                String roleCodeStr = "";
                if (BizConstant.USER_PATH.equals(authResource.getRequestUrl()) || BizConstant.USER_ROUTER_PATH.equals(authResource.getRequestUrl())) {
                    roleCodeStr = roleCodeStr.concat(BizConstant.USER_CODE);
                }
                resourceMap.put(authResource.getRequestUrl(), roleCodeStr);
            });
            redisTemplate.delete(generateCacheKey);
            List<RoleResourceInfo> roleResources = authUserMapper.getRoleResourceList();
            Map<String, String> roleResourceMap = roleResources.stream().collect(Collectors.toMap(RoleResourceInfo::getPath,
                    RoleResourceInfo::getRoleCode));
            if (MapUtils.isNotEmpty(roleResourceMap)) {
                for (String path : resourceMap.keySet()) {
                    String code = resourceMap.get(path);
                    String roleCode = roleResourceMap.get(path);
                    if (StringUtils.isNotEmpty(roleCode)) {
                        final String finalRoleCode = StringUtils.isBlank(code) ?
                                roleCode : code.concat(",").concat(roleCode);
                        resourceMap.replace(path, finalRoleCode);
                    }
                }
            }
            redisTemplate.opsForHash().putAll(generateCacheKey, resourceMap);
        }
        return true;
    }

    @Override
    public void refreshAuthority(String oldVal, String newVal) {
        String tenantId = BaseContextHolder.getTenant();
        String cacheKey = BuildKeyUtils.generateKey(BizConstant.RESOURCE_ROLES_MAP, tenantId);
        redisTemplate.opsForHash().delete(cacheKey, oldVal);
        RoleResourceInfo roleResource = authUserMapper.getRoleResource(newVal);
        redisTemplate.opsForHash().put(cacheKey, roleResource.getPath(), roleResource.getRoleCode());
    }

    @Override
    public void refreshAuthority(String oldVal) {
        String tenantId = BaseContextHolder.getTenant();
        String cacheKey = BuildKeyUtils.generateKey(BizConstant.RESOURCE_ROLES_MAP, tenantId);
        redisTemplate.opsForHash().delete(cacheKey, oldVal);
    }
}
