package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.api.dto.DictionaryItemDTO;
import com.github.sparkzxl.auth.application.service.IDictionaryItemService;
import com.github.sparkzxl.auth.domain.repository.IDictionaryItemRepository;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.auth.infrastructure.convert.DictionaryItemConvert;
import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.auth.infrastructure.mapper.DictionaryItemMapper;
import com.github.sparkzxl.auth.interfaces.dto.dictionary.DictionaryItemQueryDTO;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * description: 字典项 服务实现类
 *
 * @author charles.zhou
 * @date 2020-07-28 19:43:58
 */
@Service
public class DictionaryItemServiceImpl extends SuperCacheServiceImpl<DictionaryItemMapper, DictionaryItem> implements IDictionaryItemService {

    @Autowired
    private IDictionaryItemRepository dictionaryItemRepository;

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
                .orderByAsc(DictionaryItem::getSortNumber);
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
