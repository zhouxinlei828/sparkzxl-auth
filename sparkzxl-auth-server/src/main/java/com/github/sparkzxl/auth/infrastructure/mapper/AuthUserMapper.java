package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.RoleResourceInfo;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description: 用户 Mapper 接口
 *
 * @author charles.zhou
 * @since 2020-05-24 12:23:50
 */
@Mapper
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
    List<String> getAuthUserRoles(Long id);


    /**
     * 查询角色路径
     *
     * @return List<RoleResourceInfo>
     */
    List<RoleResourceInfo> getRoleResourceList();

    /**
     * 根据请求路径查询角色
     *
     * @param requestUrl 请求路径
     * @return RoleResource
     */
    RoleResourceInfo getRoleResource(@Param("requestUrl") String requestUrl);

    /**
     * 根据id查询用户信息
     *
     * @param id 主键
     * @return AuthUser
     */
    AuthUser getById(@Param("id") Long id);

    /**
     * 根据username查询用户信息
     *
     * @param username 用户名
     * @return AuthUser
     */
    AuthUser getByUsername(@Param("username") String username);
}
