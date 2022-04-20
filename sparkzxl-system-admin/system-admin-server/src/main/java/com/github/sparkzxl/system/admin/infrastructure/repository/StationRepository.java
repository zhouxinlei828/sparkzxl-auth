package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.Station;
import com.github.sparkzxl.system.admin.infrastructure.mapper.StationMapper;
import com.github.sparkzxl.system.admin.domain.repository.IStationRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 岗位信息 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class StationRepository extends ServiceImpl<StationMapper, Station> implements IStationRepository {

}
