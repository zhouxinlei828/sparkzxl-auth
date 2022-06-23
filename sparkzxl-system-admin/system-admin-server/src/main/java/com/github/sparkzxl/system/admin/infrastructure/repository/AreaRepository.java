package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.Area;
import com.github.sparkzxl.system.admin.infrastructure.mapper.AreaMapper;
import com.github.sparkzxl.system.admin.domain.repository.IAreaRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 地区表 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class AreaRepository extends ServiceImpl<AreaMapper, Area> implements IAreaRepository {

}
