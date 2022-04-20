package com.github.sparkzxl.system.admin.infrastructure.repository;

import com.github.sparkzxl.system.admin.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.system.admin.infrastructure.mapper.DictionaryItemMapper;
import com.github.sparkzxl.system.admin.domain.repository.IDictionaryItemRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 字典项 仓储实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Repository
public class DictionaryItemRepository extends ServiceImpl<DictionaryItemMapper, DictionaryItem> implements IDictionaryItemRepository {

}
