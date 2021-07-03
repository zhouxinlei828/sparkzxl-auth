package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * description: 岗位 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-06-07 13:30:19
 */
@Repository
public interface CoreStationMapper extends SuperMapper<CoreStation> {

}
