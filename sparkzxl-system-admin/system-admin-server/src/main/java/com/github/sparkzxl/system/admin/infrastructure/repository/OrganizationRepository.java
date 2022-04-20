package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.Organization;
import com.github.sparkzxl.system.admin.infrastructure.mapper.OrganizationMapper;
import com.github.sparkzxl.system.admin.domain.repository.IOrganizationRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 组织 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class OrganizationRepository extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationRepository {

}
