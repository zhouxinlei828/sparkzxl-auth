package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.SysParameter;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: 系统参数 Mapper 接口
 *
 * @author zhoux
 * @date 2021-06-13 12:06:01
 */
@Mapper
public interface SysParameterMapper extends SuperMapper<SysParameter> {

}
