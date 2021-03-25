package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRoleAttribute;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * description: 角色属性 Mapper 接口
 *
 * @author charles.zhou
 * @date 2021-03-24 15:50:55
 */
@Repository
public interface AuthRoleAttributeMapper extends BaseMapper<AuthRoleAttribute> {

    /**
     * 根据领域池code删除角色属性
     *
     * @param realmCode 领域池code
     */
    @Delete("delete from auth_role_attribute where realm_code = #{realmCode}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteAuthRoleAttribute(String realmCode);
}
