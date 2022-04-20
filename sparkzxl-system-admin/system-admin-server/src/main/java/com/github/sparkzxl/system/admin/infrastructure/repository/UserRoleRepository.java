package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.UserRole;
import com.github.sparkzxl.system.admin.infrastructure.mapper.UserRoleMapper;
import com.github.sparkzxl.system.admin.domain.repository.IUserRoleRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色分配	账号角色绑定 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class UserRoleRepository extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleRepository {

}
