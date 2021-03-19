package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.RoleResource;
import com.github.sparkzxl.database.annonation.InjectionResult;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 用户 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-05-24 12:23:50
 */
@Repository
public interface AuthUserMapper extends SuperMapper<AuthUser> {

    /**
     * 查询用户所拥有的资源权限
     *
     * @param id 主键
     * @return List<String>
     */
    List<String> getAuthUserPermissions(Long id);

    /**
     * 查询角色路径
     *
     * @param id 用户id
     * @return List<String>
     */
    @InterceptorIgnore(tenantLine = "true")
    List<String> getAuthUserRoles(Long id);


    /**
     * 查询角色路径
     *
     * @return List<RoleResource>
     */
    @InterceptorIgnore(tenantLine = "true")
    List<RoleResource> getRoleResourceList();

    /**
     * 根据请求路径查询角色
     *
     * @param requestUrl 请求路径
     * @return RoleResource
     */
    @InterceptorIgnore(tenantLine = "true")
    RoleResource getRoleResource(@Param("requestUrl") String requestUrl);

    /**
     * 根据id查询用户信息
     *
     * @param id 主键
     * @return AuthUser
     */
    @InjectionResult
    AuthUser getById(@Param("id") Long id);

    /**
     * 根据领域池code删除用户
     *
     * @param tenantCode 领域池code
     */
    @Delete("delete from auth_user where tenant_code = #{tenantCode}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteTenantUser(String tenantCode);
}
