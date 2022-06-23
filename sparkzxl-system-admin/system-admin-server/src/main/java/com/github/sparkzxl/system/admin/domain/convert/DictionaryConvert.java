package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.Dictionary;
import com.github.sparkzxl.system.admin.api.model.dto.DictionaryDTO;
import com.github.sparkzxl.system.admin.api.model.vo.DictionaryVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 字典类型 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface DictionaryConvert {

    DictionaryConvert INSTANCE = Mappers.getMapper(DictionaryConvert.class);

    /**
     * dictionaryDTO转换为Dictionary
     *
     * @param dictionaryDTO 字典类型DTO对象
     * @return Dictionary
     */
    Dictionary convertDictionary(DictionaryDTO dictionaryDTO);

    /**
     * Dictionary转换为DictionaryVO
     *
     * @param dictionary 字典类型DTO对象
     * @return DictionaryVO
     */
    DictionaryVO convertDictionaryVO(Dictionary dictionary);

    /**
     * dictionary列表转换为DictionaryVO列表
     *
     * @param dictionaryList 字典类型列表
     * @return List<DictionaryVO>
     */
    List<DictionaryVO> convertDictionaryVOList(List<Dictionary> dictionaryList);

    /**
     * 字典类型分页对象转换为DictionaryVO分页对象
     *
     * @param dictionaryPage 字典类型分页对象
     * @return Page<DictionaryVO>
     */
    Page<DictionaryVO> convertDictionaryPageVO(Page<Dictionary> dictionaryPage);
}
