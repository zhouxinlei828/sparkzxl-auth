package com.github.sparkzxl.auth.application.service;

import com.github.sparkzxl.auth.api.dto.DictionaryItemDTO;
import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.auth.interfaces.dto.dictionary.DictionaryItemQueryDTO;
import com.github.sparkzxl.database.base.service.SuperCacheService;
import com.github.sparkzxl.database.echo.core.LoadService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * description: 字典项 服务类
 *
 * @author charles.zhou
 * @date 2020-07-28 19:42:04
 */
public interface IDictionaryItemService extends SuperCacheService<DictionaryItem>, LoadService {

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictionaryItemQueryDTO 字典项查询入参
     * @return List<DictionaryItem>
     */
    List<DictionaryItem> findDictionaryItemList(DictionaryItemQueryDTO dictionaryItemQueryDTO);

    /**
     * 根据名称查询字典项信息
     *
     * @param name 名称
     * @return DictionaryItem
     */
    DictionaryItem getDictionaryItemByName(String name);

    /**
     * 查询字典项列表
     *
     * @param dictionaryType 字典类型
     * @param codes          字典code
     * @return Map<String, DictionaryItemDTO>
     */
    Map<String, DictionaryItemDTO> findDictionaryItemMap(String dictionaryType, Set<String> codes);
}
