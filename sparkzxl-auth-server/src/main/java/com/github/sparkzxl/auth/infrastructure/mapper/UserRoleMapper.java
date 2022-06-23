package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.UserRole;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: 账号角色绑定 Mapper 接口
 *
 * @author charles.zhou
 * @since 2020-07-19 20:58:18
 */
@Mapper
public interface UserRoleMapper extends SuperMapper<UserRole> {

}
