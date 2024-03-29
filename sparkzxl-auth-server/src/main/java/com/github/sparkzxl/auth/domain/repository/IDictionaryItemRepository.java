package com.github.sparkzxl.auth.domain.repository;

import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.database.echo.core.LoadService;

import java.util.Map;
import java.util.Set;

/**
 * description: 字典项仓储类
 *
 * @author charles.zhou
 * @since 2021-03-06 20:55:19
 */
public interface IDictionaryItemRepository extends LoadService {

    /**
     * 查询字典项列表
     *
     * @param dictionaryType 字典类型
     * @param codes          字典code
     * @return Map<String, DictionaryItem>
     */
    Map<String, DictionaryItem> findDictionaryItemList(String dictionaryType, Set<String> codes);

}
