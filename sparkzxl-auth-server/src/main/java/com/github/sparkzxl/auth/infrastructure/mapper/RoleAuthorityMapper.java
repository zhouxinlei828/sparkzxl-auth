package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * description: 角色资源 Mapper 接口
 *
 * @author charles.zhou
 * @date   2020-07-19 20:57:42
 */
@Repository
public interface RoleAuthorityMapper extends SuperMapper<RoleAuthority> {

    /**
     * 根据领域池code删除角色资源
     * @param tenantCode 领域池code
     */
    @Delete("delete from auth_role_authority where tenant_code = #{tenantCode}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteRoleAuthority(String tenantCode);
}
