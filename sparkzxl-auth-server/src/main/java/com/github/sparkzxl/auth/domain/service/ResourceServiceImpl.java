package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.IResourceService;
import com.github.sparkzxl.auth.domain.repository.IAuthResourceRepository;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.auth.infrastructure.convert.AuthResourceConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthResourceMapper;
import com.github.sparkzxl.auth.interfaces.dto.resource.ResourceQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.resource.ResourceUpdateDTO;
import com.github.sparkzxl.core.util.BuildKeyUtil;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description: 资源 服务实现类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:36:15
 */
@Service
public class ResourceServiceImpl extends SuperCacheServiceImpl<AuthResourceMapper, AuthResource> implements IResourceService {

    private final IAuthResourceRepository authResourceRepository;

    public ResourceServiceImpl(IAuthResourceRepository authResourceRepository) {
        this.authResourceRepository = authResourceRepository;
    }

    @Override
    protected String getRegion() {
        return BizConstant.RESOURCE;
    }

    @Override
    public List<AuthResource> findVisibleResource(Long userId, ResourceQueryDTO resourceQueryDTO) {
        if (ObjectUtils.isNotEmpty(resourceQueryDTO.getUserId())) {
            userId = resourceQueryDTO.getUserId();
        }
        String userResourceKey = BuildKeyUtil.generateKey(getRegion(), userId);
        List<AuthResource> visibleResource = Lists.newArrayList();
        Long finalUserId = userId;
        generalCacheService.get(userResourceKey, (key) -> {
            visibleResource.addAll(authResourceRepository.findVisibleResource(finalUserId, resourceQueryDTO.getMenuId()));
            return visibleResource.stream().mapToLong(AuthResource::getId).boxed().collect(Collectors.toList());
        });
        return null;
    }

    @Override
    public boolean deleteResource(List<Long> resourceIds) {
        return authResourceRepository.deleteResource(resourceIds);
    }

    @Override
    public boolean updateResource(ResourceUpdateDTO authResourceUpdateDTO) {
        AuthResource authResource = AuthResourceConvert.INSTANCE.convertAuthResourceDTO(authResourceUpdateDTO);
        return authResourceRepository.updateResource(authResource);
    }
}
