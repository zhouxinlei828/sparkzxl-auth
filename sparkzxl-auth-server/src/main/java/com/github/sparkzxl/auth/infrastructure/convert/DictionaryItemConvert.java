package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.api.dto.DictionaryItemDTO;
import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: AuthClientDetails 对象Convert
 *
 * @author charles.zhou
 * @since 2020-06-05 21:28:06
 */
@Mapper
public interface DictionaryItemConvert {

    DictionaryItemConvert INSTANCE = Mappers.getMapper(DictionaryItemConvert.class);

    /**
     * DictionaryItem转换DictionaryItemDTO
     *
     * @param dictionaryItem 字典项
     * @return DictionaryItemDTO
     */
    DictionaryItemDTO convertDictionaryItemDTO(DictionaryItem dictionaryItem);
}
