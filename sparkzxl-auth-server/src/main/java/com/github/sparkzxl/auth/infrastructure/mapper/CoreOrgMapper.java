package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: 组织 Mapper 接口
 *
 * @author charles.zhou
 * @since 2020-06-07 13:29:56
 */
@Mapper
public interface CoreOrgMapper extends SuperMapper<CoreOrg> {
}
