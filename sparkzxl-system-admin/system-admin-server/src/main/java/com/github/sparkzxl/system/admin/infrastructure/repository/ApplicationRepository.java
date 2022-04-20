package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.Application;
import com.github.sparkzxl.system.admin.infrastructure.mapper.ApplicationMapper;
import com.github.sparkzxl.system.admin.domain.repository.IApplicationRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 应用 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class ApplicationRepository extends ServiceImpl<ApplicationMapper, Application> implements IApplicationRepository {

}
