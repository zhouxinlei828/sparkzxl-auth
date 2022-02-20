package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: 角色 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-06-07 13:29:38
 */
@Mapper
public interface AuthRoleMapper extends SuperMapper<AuthRole> {

}
