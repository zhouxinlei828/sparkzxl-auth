package com.github.sparkzxl.auth.infrastructure.mapper;

import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * description: 字典项 Mapper 接口
 *
 * @author charles.zhou
 * @date 2020-07-28 19:39:58
 */
@Mapper
public interface DictionaryItemMapper extends SuperMapper<DictionaryItem> {

}
