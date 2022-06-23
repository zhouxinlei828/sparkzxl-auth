package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.AuthMenu;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: 菜单 Mapper 接口
 *
 * @author charles.zhou
 * @since 2020-06-07 13:28:51
 */
@Mapper
public interface AuthMenuMapper extends SuperMapper<AuthMenu> {

}
