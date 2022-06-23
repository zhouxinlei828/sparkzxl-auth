package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.application.service.IResourceService;
import com.github.sparkzxl.auth.domain.repository.IAuthResourceRepository;
import com.github.sparkzxl.auth.infrastructure.convert.AuthResourceConvert;
import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthResourceMapper;
import com.github.sparkzxl.auth.domain.model.dto.resource.ResourceQueryDTO;
import com.github.sparkzxl.auth.domain.model.dto.resource.ResourceUpdateDTO;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 资源 服务实现类
 *
 * @author charles.zhou
 * @since 2020-06-07 13:36:15
 */
@Service
public class ResourceServiceImpl extends SuperServiceImpl<AuthResourceMapper, AuthResource> implements IResourceService {

    private final IAuthResourceRepository authResourceRepository;

    public ResourceServiceImpl(IAuthResourceRepository authResourceRepository) {
        this.authResourceRepository = authResourceRepository;
    }

    @Override
    public List<AuthResource> findVisibleResource(Long userId, ResourceQueryDTO resourceQueryDTO) {
        if (ObjectUtils.isNotEmpty(resourceQueryDTO.getUserId())) {
            userId = resourceQueryDTO.getUserId();
        }
        List<AuthResource> visibleResource = Lists.newArrayList();
        visibleResource.addAll(authResourceRepository.findVisibleResource(userId, resourceQueryDTO.getMenuId()));
        return visibleResource;
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
