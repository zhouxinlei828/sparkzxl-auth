package com.github.sparkzxl.auth.infrastructure.repository;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.application.event.RoleResourceEvent;
import com.github.sparkzxl.auth.domain.model.aggregates.ResourceSource;
import com.github.sparkzxl.auth.domain.repository.IAuthResourceRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.enums.OperationEnum;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthResourceMapper;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.core.context.RequestLocalContextHolder;
import com.github.sparkzxl.core.spring.SpringContextUtils;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 资源 仓储层实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:31:28
 */
@AllArgsConstructor
@Repository
public class AuthResourceRepository implements IAuthResourceRepository {

    private final AuthResourceMapper authResourceMapper;
    private final RoleAuthorityMapper roleAuthorityMapper;

    @Override
    public List<AuthResource> getResourceList() {
        return authResourceMapper.selectResourceList();
    }

    @Override
    public List<AuthResource> authResourceList(List<Long> menuIds) {
        if (CollectionUtils.isNotEmpty(menuIds)) {
            return authResourceMapper.selectList(new LambdaQueryWrapper<AuthResource>().in(AuthResource::getMenuId, menuIds));
        }
        return Lists.newArrayList();
    }

    @Override
    public List<AuthResource> findVisibleResource(Long userId, Long menuId) {
        return authResourceMapper.findVisibleResource(userId, menuId);
    }

    @Override
    public boolean deleteResource(List<Long> resourceIds) {
        if (CollectionUtils.isNotEmpty(resourceIds)) {
            roleAuthorityMapper.delete(new LambdaQueryWrapper<RoleAuthority>().in(RoleAuthority::getAuthorityId, resourceIds));
            List<AuthResource> authResources = authResourceMapper.selectBatchIds(resourceIds);
            String tenantId = RequestLocalContextHolder.getTenant();
            authResources.forEach(authResource -> SpringContextUtils.publishEvent(
                    new RoleResourceEvent(new ResourceSource(OperationEnum.DELETE, null, authResource.getRequestUrl(), tenantId))));
            return authResourceMapper.deleteBatchIds(resourceIds) > 0;
        }
        return true;
    }

    @Override
    public void saveResourceList(List<AuthResource> resourceList) {
        authResourceMapper.insertBatchSomeColumn(resourceList);
    }

    @Override
    public boolean updateResource(AuthResource authResource) {
        if (StringUtils.isNotEmpty(authResource.getRequestUrl())) {
            Long resourceId = authResource.getId();
            AuthResource oldResource = authResourceMapper.selectById(resourceId);
            String oldRequestUrl = oldResource.getRequestUrl();
            String tenantId = RequestLocalContextHolder.getTenant();
            authResourceMapper.updateById(authResource);
            SpringContextUtils.publishEvent(new RoleResourceEvent(new ResourceSource(OperationEnum.UPDATE,
                    authResource.getRequestUrl(), oldRequestUrl, tenantId)));
        } else {
            authResourceMapper.updateById(authResource);
        }
        return true;
    }
}
