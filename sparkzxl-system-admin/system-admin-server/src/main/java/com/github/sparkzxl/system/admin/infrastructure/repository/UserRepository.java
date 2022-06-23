package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.User;
import com.github.sparkzxl.system.admin.infrastructure.mapper.UserMapper;
import com.github.sparkzxl.system.admin.domain.repository.IUserRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class UserRepository extends ServiceImpl<UserMapper, User> implements IUserRepository {

}
