package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * description: 组织 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-06-07 13:29:56
 */
@Repository
public interface CoreOrgMapper extends SuperMapper<CoreOrg> {

    /**
     * 根据租户池code删除组织信息
     *
     * @param tenantId 租户池code
     */
    @Delete("delete from core_org where tenant_code = #{tenantId}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteTenantOrg(String tenantId);
}
