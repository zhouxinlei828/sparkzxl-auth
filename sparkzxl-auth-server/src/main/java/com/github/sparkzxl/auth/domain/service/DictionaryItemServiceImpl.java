package com.github.sparkzxl.auth.domain.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.api.dto.DictionaryItemDTO;
import com.github.sparkzxl.auth.application.service.IDictionaryItemService;
import com.github.sparkzxl.auth.domain.repository.IDictionaryItemRepository;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.auth.infrastructure.convert.DictionaryItemConvert;
import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.auth.infrastructure.mapper.DictionaryItemMapper;
import com.github.sparkzxl.auth.interfaces.dto.dictionary.DictionaryItemQueryDTO;
import com.github.sparkzxl.core.utils.MapHelper;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.database.properties.CustomMybatisProperties;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * description: 字典项 服务实现类
 *
 * @author charles.zhou
 * @date 2020-07-28 19:43:58
 */
@Service
public class DictionaryItemServiceImpl extends SuperCacheServiceImpl<DictionaryItemMapper, DictionaryItem> implements IDictionaryItemService {

    @Autowired
    private CustomMybatisProperties customMybatisProperties;

    @Autowired
    private IDictionaryItemRepository dictionaryItemRepository;


    @Override
    public Map<Serializable, Object> findNameByIds(Set<Serializable> codes) {
        Set<String> types = codes.stream().filter(Objects::nonNull)
                .map((item) -> StrUtil.split(String.valueOf(item), customMybatisProperties.getEcho().getDictSeparator()).get(0)).collect(Collectors.toSet());

        // 1. 根据 字典编码查询可用的字典列表
        LambdaQueryWrapper<DictionaryItem> dictionaryItemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dictionaryItemLambdaQueryWrapper.in(DictionaryItem::getDictionaryType, types)
                .eq(DictionaryItem::getStatus, true)
                .orderByAsc(DictionaryItem::getSortValue);
        List<DictionaryItem> list = super.list(dictionaryItemLambdaQueryWrapper);

        // 2. 将 list 转换成 Map，Map的key是字典编码，value是字典名称
        ImmutableMap<String, String> typeMap = MapHelper.uniqueIndex(list,
                (item) -> StrUtil.join(customMybatisProperties.getEcho().getDictSeparator(), item.getDictionaryType(), item.getCode())
                , DictionaryItem::getName);

        // 3. 将 Map<String, String> 转换成 Map<Serializable, Object>
        Map<Serializable, Object> typeCodeNameMap = new HashMap<>(typeMap.size());
        typeMap.forEach(typeCodeNameMap::put);
        return typeCodeNameMap;
    }

    @Override
    public Map<Serializable, Object> findByIds(Set<Serializable> ids) {
        return Collections.emptyMap();
    }


    @Override
    public List<DictionaryItem> findDictionaryItemList(DictionaryItemQueryDTO dictionaryItemQueryDTO) {
        LambdaQueryWrapper<DictionaryItem> dictionaryItemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtils.isNotEmpty(dictionaryItemQueryDTO.getDictionaryId())) {
            dictionaryItemLambdaQueryWrapper.eq(DictionaryItem::getDictionaryId, dictionaryItemQueryDTO.getDictionaryId());
        }
        if (StringUtils.isNotEmpty(dictionaryItemQueryDTO.getDictionaryType())) {
            dictionaryItemLambdaQueryWrapper.eq(DictionaryItem::getDictionaryType, dictionaryItemQueryDTO.getDictionaryType());
        }
        if (StringUtils.isNotEmpty(dictionaryItemQueryDTO.getCode())) {
            dictionaryItemLambdaQueryWrapper.eq(DictionaryItem::getCode, dictionaryItemQueryDTO.getCode());
        }
        if (StringUtils.isNotEmpty(dictionaryItemQueryDTO.getName())) {
            dictionaryItemLambdaQueryWrapper.likeRight(DictionaryItem::getName, dictionaryItemQueryDTO.getName());
        }
        dictionaryItemLambdaQueryWrapper.eq(DictionaryItem::getStatus, true)
                .orderByAsc(DictionaryItem::getSortValue);
        return super.list(dictionaryItemLambdaQueryWrapper);
    }

    @Override
    public DictionaryItem getDictionaryItemByName(String name) {
        LambdaQueryWrapper<DictionaryItem> dictionaryItemLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dictionaryItemLambdaQueryWrapper.eq(DictionaryItem::getName, name);
        dictionaryItemLambdaQueryWrapper.eq(DictionaryItem::getStatus, true)
                .last("limit 1");
        return getOne(dictionaryItemLambdaQueryWrapper);
    }

    @Override
    public Map<String, DictionaryItemDTO> findDictionaryItemMap(String dictionaryType, Set<String> codes) {
        Map<String, DictionaryItemDTO> dictionaryItemDtoMap = Maps.newHashMap();
        Map<String, DictionaryItem> dictionaryItemMap = dictionaryItemRepository.findDictionaryItemList(dictionaryType, codes);
        if (MapUtils.isNotEmpty(dictionaryItemMap)) {
            dictionaryItemMap.forEach((key, value) -> dictionaryItemDtoMap.put(key, DictionaryItemConvert.INSTANCE.convertDictionaryItemDTO(value)));
        }
        return dictionaryItemDtoMap;
    }

    @Override
    protected String getRegion() {
        return BizConstant.DICTIONARY_ITEM;
    }
}
