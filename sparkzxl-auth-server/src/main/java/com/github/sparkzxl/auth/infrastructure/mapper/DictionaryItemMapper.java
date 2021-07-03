package com.github.sparkzxl.auth.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.database.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

/**
 * description: 字典项 Mapper 接口
 *
 * @author charles.zhou
 * @date   2020-07-28 19:39:58
 */
@Repository
public interface DictionaryItemMapper extends SuperMapper<DictionaryItem> {

}
