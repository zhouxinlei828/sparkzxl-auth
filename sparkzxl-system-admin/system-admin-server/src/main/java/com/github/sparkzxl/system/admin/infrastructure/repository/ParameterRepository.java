package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.Parameter;
import com.github.sparkzxl.system.admin.infrastructure.mapper.ParameterMapper;
import com.github.sparkzxl.system.admin.domain.repository.IParameterRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统参数 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class ParameterRepository extends ServiceImpl<ParameterMapper, Parameter> implements IParameterRepository {

}
