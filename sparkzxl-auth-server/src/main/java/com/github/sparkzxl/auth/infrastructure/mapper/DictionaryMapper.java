package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.Dictionary;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: 字典类型 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-07-28 19:40:29
 */
@Mapper
public interface DictionaryMapper extends SuperMapper<Dictionary> {

}
