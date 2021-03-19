package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.AuthApplication;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 领域池客户端Mapper 接口
 *
 * @author charles.zhou
 * @date   2021-02-20 09:43:16
 */
@Repository
public interface AuthApplicationMapper extends SuperMapper<AuthApplication> {

    /**
     * 根据领域池code删除领域池客户端
     *
     * @param tenantCode 领域池code
     */
    @InterceptorIgnore(tenantLine = "true")
    @Delete("delete from auth_application where tenant_code = #{tenantCode}")
    void deleteTenantClient(String tenantCode);


    /**
     * 获取客户端分页信息
     *
     * @param tenantCode 领域池code
     * @param clientId   客户端id
     * @param appName    应用名称
     * @return List<OauthClientDetails>
     */
    @Select("<script> " +
            "SELECT " +
            "app.*, " +
            "ti.NAME realmName " +
            "FROM auth_application app " +
            "LEFT JOIN realm_pool ti ON ti.CODE = app.tenant_code" +
            "<where>" +
            " <if test=\"tenantCode != null and tenantCode != ''\">" +
            "    and ti.code = #{tenantCode}" +
            " </if>" +
            " <if test=\"clientId != null and clientId != ''\">" +
            "    and app.client_id = #{clientId}" +
            " </if>" +
            " <if test=\"appName != null and appName != ''\">" +
            "    and app.name like concat('%',#{appName},'%')" +
            " </if>" +
            "</where>" +
            "</script>")
    @InterceptorIgnore(tenantLine = "true")
    List<AuthApplication> listPage(@Param("tenantCode") String tenantCode, @Param("clientId") String clientId,
                                   @Param("appName") String appName);

    /**
     * 查询应用列表
     * @return List<AuthApplication>
     */
    @Select("select * from auth_application")
    @InterceptorIgnore(tenantLine = "true")
    List<AuthApplication> applicationList();

}
