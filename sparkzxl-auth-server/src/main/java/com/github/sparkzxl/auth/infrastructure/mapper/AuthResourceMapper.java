package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * description: 资源 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-06-07 13:29:12
 */
@Mapper
public interface AuthResourceMapper extends SuperMapper<AuthResource> {

    /**
     * 查询用户可用的所有资源
     *
     * @param userId 用户id
     * @param menuId 菜单id
     * @return List<AuthResource>
     */
    @Select("SELECT id, create_user, create_time, update_user, update_time, code, name, menu_id, describe"
            + " from auth_resource where "
            + " id in (SELECT authority_id FROM auth_role_authority ra INNER JOIN auth_user_role ur on ra.role_id = ur.role_id "
            + " INNER JOIN auth_role r on r.id = ra.role_id "
            + " where ur.user_id = #{userId, jdbcType=BIGINT} and r.`status` = true "
            + " and ra.authority_type = 'RESOURCE')")
    List<AuthResource> findVisibleResource(Long userId, Long menuId);


    /**
     * 查询资源列表
     *
     * @return List<AuthResource>
     */
    @Select("SELECT * from auth_resource where request_url IS NOT NULL")
    List<AuthResource> selectResourceList();
}
