package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.Dictionary;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * description: 字典类型 Mapper 接口
 *
 * @author charles.zhou
 * @date   2020-07-28 19:40:29
 */
@Repository
public interface DictionaryMapper extends SuperMapper<Dictionary> {

    /**
     * 根据领域池code删除字典类型
     *
     * @param realmCode 领域池code
     */
    @Delete("delete from dictionary where realm_code = #{realmCode}")
    @InterceptorIgnore(tenantLine = "true")
    void deleteTenantDictionary(String realmCode);
}
