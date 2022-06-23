package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.system.admin.api.model.dto.DictionaryItemDTO;
import com.github.sparkzxl.system.admin.api.model.vo.DictionaryItemVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 字典项 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface DictionaryItemConvert {

    DictionaryItemConvert INSTANCE = Mappers.getMapper(DictionaryItemConvert.class);

    /**
     * dictionaryItemDTO转换为DictionaryItem
     *
     * @param dictionaryItemDTO 字典项DTO对象
     * @return DictionaryItem
     */
    DictionaryItem convertDictionaryItem(DictionaryItemDTO dictionaryItemDTO);

    /**
     * DictionaryItem转换为DictionaryItemVO
     *
     * @param dictionaryItem 字典项DTO对象
     * @return DictionaryItemVO
     */
    DictionaryItemVO convertDictionaryItemVO(DictionaryItem dictionaryItem);

    /**
     * dictionaryItem列表转换为DictionaryItemVO列表
     *
     * @param dictionaryItemList 字典项列表
     * @return List<DictionaryItemVO>
     */
    List<DictionaryItemVO> convertDictionaryItemVOList(List<DictionaryItem> dictionaryItemList);

    /**
     * 字典项分页对象转换为DictionaryItemVO分页对象
     *
     * @param dictionaryItemPage 字典项分页对象
     * @return Page<DictionaryItemVO>
     */
    Page<DictionaryItemVO> convertDictionaryItemPageVO(Page<DictionaryItem> dictionaryItemPage);
}
