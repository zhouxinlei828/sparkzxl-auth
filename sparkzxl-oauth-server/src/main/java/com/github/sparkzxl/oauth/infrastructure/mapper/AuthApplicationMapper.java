package com.github.sparkzxl.oauth.infrastructure.mapper;

import com.github.sparkzxl.database.base.mapper.SuperMapper;
import com.github.sparkzxl.oauth.infrastructure.entity.AuthApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * description: 租户信息客户端Mapper 接口
 *
 * @author charles.zhou
 * @since 2021-02-20 09:43:16
 */
@Mapper
public interface AuthApplicationMapper extends SuperMapper<AuthApplication> {

    /**
     * 查询应用列表
     *
     * @return List<AuthApplication>
     */
    @Select("select * from auth_application")
    List<AuthApplication> applicationList();

}
