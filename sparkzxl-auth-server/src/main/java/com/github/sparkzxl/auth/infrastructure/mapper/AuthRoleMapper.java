package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * description: 角色 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-06-07 13:29:38
 */
@Repository
public interface AuthRoleMapper extends SuperMapper<AuthRole> {

    /**
     * 根据租户池code删除角色
     *
     * @param tenantId 租户池code
     */
    @Delete("delete from auth_role where tenant_code = #{tenantId}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteAuthRole(String tenantId);
}
