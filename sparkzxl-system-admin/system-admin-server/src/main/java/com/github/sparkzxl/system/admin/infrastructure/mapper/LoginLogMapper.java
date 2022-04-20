package com.github.sparkzxl.system.admin.infrastructure.mapper;

import com.github.sparkzxl.system.admin.infrastructure.entity.LoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 登录日志 Mapper 接口
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {

}
