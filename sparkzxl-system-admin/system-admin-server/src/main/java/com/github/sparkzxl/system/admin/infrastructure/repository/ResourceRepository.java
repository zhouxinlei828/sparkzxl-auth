package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.Resource;
import com.github.sparkzxl.system.admin.infrastructure.mapper.ResourceMapper;
import com.github.sparkzxl.system.admin.domain.repository.IResourceRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 资源信息 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class ResourceRepository extends ServiceImpl<ResourceMapper, Resource> implements IResourceRepository {

}
