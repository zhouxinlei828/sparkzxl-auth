package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: 角色资源 Mapper 接口
 *
 * @author charles.zhou
 * @since 2020-07-19 20:57:42
 */
@Mapper
public interface RoleAuthorityMapper extends SuperMapper<RoleAuthority> {

}
