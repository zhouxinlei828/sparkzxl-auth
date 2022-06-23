package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.Role;
import com.github.sparkzxl.system.admin.infrastructure.mapper.RoleMapper;
import com.github.sparkzxl.system.admin.domain.repository.IRoleRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色信息 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class RoleRepository extends ServiceImpl<RoleMapper, Role> implements IRoleRepository {

}
