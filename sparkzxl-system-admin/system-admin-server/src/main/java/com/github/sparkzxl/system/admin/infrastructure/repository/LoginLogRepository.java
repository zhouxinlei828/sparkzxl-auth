package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.LoginLog;
import com.github.sparkzxl.system.admin.infrastructure.mapper.LoginLogMapper;
import com.github.sparkzxl.system.admin.domain.repository.ILoginLogRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 登录日志 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class LoginLogRepository extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogRepository {

}
