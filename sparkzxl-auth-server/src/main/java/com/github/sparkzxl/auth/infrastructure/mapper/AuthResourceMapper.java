package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.AuthResource;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 资源 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-06-07 13:29:12
 */
@Repository
public interface AuthResourceMapper extends SuperMapper<AuthResource> {

    /**
     * 查询用户可用的所有资源
     *
     * @param userId
     * @param menuId
     * @return
     */
    @Select("SELECT id, create_user, create_time, update_user, update_time, code, name, menu_id, describe"
            + " from auth_resource where "
            + " id in (SELECT authority_id FROM auth_role_authority ra INNER JOIN auth_user_role ur on ra.role_id = ur.role_id "
            + " INNER JOIN auth_role r on r.id = ra.role_id "
            + " where ur.user_id = #{userId, jdbcType=BIGINT} and r.`status` = true "
            + " and ra.authority_type = 'RESOURCE')")
    List<AuthResource> findVisibleResource(Long userId, Long menuId);

    /**
     * 根据领域池code删除资源
     *
     * @param RealmCode 领域池code
     */
    @Delete("delete from auth_resource where realm_code = #{RealmCode}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteTenantResource(String RealmCode);
}
