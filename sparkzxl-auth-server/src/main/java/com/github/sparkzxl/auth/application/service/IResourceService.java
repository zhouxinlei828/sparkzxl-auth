package com.github.sparkzxl.auth.application.service;


import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.auth.interfaces.dto.resource.ResourceQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.resource.ResourceUpdateDTO;
import com.github.sparkzxl.database.base.service.SuperService;

import java.util.List;

/**
 * description: 资源 服务类
 *
 * @author charles.zhou
 * @date 2020-06-07 13:31:28
 */
public interface IResourceService extends SuperService<AuthResource> {

    /**
     * 查询用户可用的所有资源
     *
     * @param userId           用户id
     * @param resourceQueryDTO 资源查询对象
     * @return List<AuthResource>
     */
    List<AuthResource> findVisibleResource(Long userId, ResourceQueryDTO resourceQueryDTO);

    /**
     * 删除资源
     *
     * @param resourceIds 资源ids
     * @return boolean
     */
    boolean deleteResource(List<Long> resourceIds);

    /**
     * 更新资源
     *
     * @param authResourceUpdateDTO 资源更新对象
     * @return boolean
     */
    boolean updateResource(ResourceUpdateDTO authResourceUpdateDTO);
}
