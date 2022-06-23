package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.OperateLog;
import com.github.sparkzxl.system.admin.infrastructure.mapper.OperateLogMapper;
import com.github.sparkzxl.system.admin.domain.repository.IOperateLogRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统日志 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class OperateLogRepository extends ServiceImpl<OperateLogMapper, OperateLog> implements IOperateLogRepository {

}
