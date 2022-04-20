package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.system.admin.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.system.admin.domain.repository.IRoleAuthorityRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色的资源 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class RoleAuthorityRepository extends ServiceImpl<RoleAuthorityMapper, RoleAuthority> implements IRoleAuthorityRepository {

}
