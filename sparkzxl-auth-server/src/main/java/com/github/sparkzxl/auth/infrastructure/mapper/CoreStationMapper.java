package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * description: 岗位 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-06-07 13:30:19
 */
@Repository
public interface CoreStationMapper extends SuperMapper<CoreStation> {

    /**
     * 根据租户池code删除岗位
     *
     * @param tenantId 租户池code
     */
    @Delete("delete from core_station where tenant_code = #{tenantId}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteTenantStation(String tenantId);
}
