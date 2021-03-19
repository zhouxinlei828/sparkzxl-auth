package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.domain.repository.IDictionaryItemRepository;
import com.github.sparkzxl.auth.infrastructure.entity.CommonDictionaryItem;
import com.github.sparkzxl.auth.infrastructure.mapper.CommonDictionaryItemMapper;
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
 * @date   2021-03-06 21:02:51
 */
@Repository
public class DictionaryItemRepository implements IDictionaryItemRepository {

    @Autowired
    private CommonDictionaryItemMapper dictionaryItemMapper;

    @Override
    public Map<String, CommonDictionaryItem> findDictionaryItemList(String dictionaryType, Set<String> codes) {
        LambdaQueryWrapper<CommonDictionaryItem> dictionaryItemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dictionaryItemLambdaQueryWrapper.eq(CommonDictionaryItem::getDictionaryType, dictionaryType)
                .in(CommonDictionaryItem::getCode, codes)
                .eq(CommonDictionaryItem::getStatus, true)
                .orderByAsc(CommonDictionaryItem::getSortValue);
        List<CommonDictionaryItem> commonDictionaryItems = dictionaryItemMapper.selectList(dictionaryItemLambdaQueryWrapper);
        Map<String, CommonDictionaryItem> commonDictionaryItemMap = Maps.newHashMap();
        if (CollectionUtils.isNotEmpty(commonDictionaryItems)) {
            commonDictionaryItemMap = commonDictionaryItems.stream().collect(Collectors.toMap(CommonDictionaryItem::getCode, k -> k));
        }
        return commonDictionaryItemMap;
    }
}
