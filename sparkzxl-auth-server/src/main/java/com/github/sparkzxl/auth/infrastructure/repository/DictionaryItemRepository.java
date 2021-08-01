package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.domain.repository.IDictionaryItemRepository;
import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.auth.infrastructure.mapper.DictionaryItemMapper;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description: 字典项仓储实现类
 *
 * @author charles.zhou
 * @date 2021-03-06 21:02:51
 */
@Repository
public class DictionaryItemRepository implements IDictionaryItemRepository {

    @Autowired
    private DictionaryItemMapper dictionaryItemMapper;

    @Override
    public Map<String, DictionaryItem> findDictionaryItemList(String dictionaryType, Set<String> codes) {
        LambdaQueryWrapper<DictionaryItem> dictionaryItemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dictionaryItemLambdaQueryWrapper.eq(DictionaryItem::getDictionaryType, dictionaryType)
                .in(DictionaryItem::getCode, codes)
                .eq(DictionaryItem::getStatus, true)
                .orderByAsc(DictionaryItem::getSortValue);
        List<DictionaryItem> dictionaryItems = dictionaryItemMapper.selectList(dictionaryItemLambdaQueryWrapper);
        Map<String, DictionaryItem> commonDictionaryItemMap = Maps.newHashMap();
        if (CollectionUtils.isNotEmpty(dictionaryItems)) {
            commonDictionaryItemMap = dictionaryItems.stream().collect(Collectors.toMap(DictionaryItem::getCode, k -> k));
        }
        return commonDictionaryItemMap;
    }
}
