package com.github.sparkzxl.system.admin.infrastructure.mapper;

import com.github.sparkzxl.system.admin.infrastructure.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色分配	账号角色绑定 Mapper 接口
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
