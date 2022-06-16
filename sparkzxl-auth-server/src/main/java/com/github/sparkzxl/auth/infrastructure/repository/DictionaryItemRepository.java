package com.github.sparkzxl.auth.infrastructure.repository;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.domain.repository.IDictionaryItemRepository;
import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.auth.infrastructure.mapper.DictionaryItemMapper;
import com.github.sparkzxl.core.util.MapHelper;
import com.github.sparkzxl.database.echo.properties.EchoProperties;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description: 字典项仓储实现类
 *
 * @author charles.zhou
 * @since 2021-03-06 21:02:51
 */
@Repository
public class DictionaryItemRepository implements IDictionaryItemRepository {

    @Autowired
    private DictionaryItemMapper dictionaryItemMapper;

    @Autowired
    private EchoProperties echoProperties;


    @Override
    public Map<String, DictionaryItem> findDictionaryItemList(String dictionaryType, Set<String> codes) {
        LambdaQueryWrapper<DictionaryItem> dictionaryItemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dictionaryItemLambdaQueryWrapper.eq(DictionaryItem::getDictionaryType, dictionaryType)
                .in(DictionaryItem::getCode, codes)
                .eq(DictionaryItem::getStatus, true)
                .orderByAsc(DictionaryItem::getSortNumber);
        List<DictionaryItem> dictionaryItems = dictionaryItemMapper.selectList(dictionaryItemLambdaQueryWrapper);
        Map<String, DictionaryItem> commonDictionaryItemMap = Maps.newHashMap();
        if (CollectionUtils.isNotEmpty(dictionaryItems)) {
            commonDictionaryItemMap = dictionaryItems.stream().collect(Collectors.toMap(DictionaryItem::getCode, k -> k));
        }
        return commonDictionaryItemMap;
    }


    @Override
    public Map<Serializable, Object> findByIds(Set<Serializable> types) {
        if (types.isEmpty()) {
            return Collections.emptyMap();
        }

        // 1. 根据 字典编码查询可用的字典列表
        LambdaQueryWrapper<DictionaryItem> dictionaryItemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dictionaryItemLambdaQueryWrapper.in(DictionaryItem::getDictionaryType, types)
                .eq(DictionaryItem::getStatus, true)
                .orderByAsc(DictionaryItem::getSortNumber);
        List<DictionaryItem> list = dictionaryItemMapper.selectList(dictionaryItemLambdaQueryWrapper);

        // 2. 将 list 转换成 Map，Map的key是字典编码，value是字典名称
        ImmutableMap<String, String> typeMap = MapHelper.uniqueIndex(list,
                (item) -> StrUtil.join(echoProperties.getDictSeparator(), item.getDictionaryType(), item.getCode())
                , DictionaryItem::getName);

        // 3. 将 Map<String, String> 转换成 Map<Serializable, Object>
        Map<Serializable, Object> typeCodeNameMap = new HashMap<>(typeMap.size());
        typeMap.forEach(typeCodeNameMap::put);
        return typeCodeNameMap;
    }
}
