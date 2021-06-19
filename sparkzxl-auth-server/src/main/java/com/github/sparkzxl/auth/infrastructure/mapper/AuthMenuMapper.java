package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.AuthMenu;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 菜单 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-06-07 13:28:51
 */
@Repository
public interface AuthMenuMapper extends SuperMapper<AuthMenu> {

    /**
     * 根据租户池code删除菜单
     *
     * @param tenantId 租户池code
     */
    @Delete("delete from auth_menu where tenant_code = #{tenantId}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteTenantPoolMenu(String tenantId);

    /**
     * 根据租户池code菜单列表
     *
     * @param tenantId 租户池code
     * @return List<AuthMenu>
     */
    @Select("select * from auth_menu where tenant_code = #{tenantId}")
    @InterceptorIgnore(tenantLine = "true")
    List<AuthMenu> selectListBytenant(String tenantId);
}
