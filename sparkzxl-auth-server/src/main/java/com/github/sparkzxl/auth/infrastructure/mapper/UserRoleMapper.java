package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.UserRole;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * description: 账号角色绑定 Mapper 接口
 *
 * @author charles.zhou
 * @date   2020-07-19 20:58:18
 */
@Repository
public interface UserRoleMapper extends SuperMapper<UserRole> {

    /**
     * 根据租户池code删除用户角色关系
     *
     * @param tenantId 租户池code
     */
    @Delete("delete from auth_user_role where tenant_code = #{tenantId}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteUserRole(@Param("tenantId") String tenantId);
}
