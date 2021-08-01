package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 租户信息客户端Mapper 接口
 *
 * @author charles.zhou
 * @date 2021-02-20 09:43:16
 */
@Repository
public interface AuthApplicationMapper extends SuperMapper<AuthApplication> {

    /**
     * 查询应用列表
     *
     * @return List<AuthApplication>
     */
    @Select("select * from auth_application")
    List<AuthApplication> applicationList();

}
