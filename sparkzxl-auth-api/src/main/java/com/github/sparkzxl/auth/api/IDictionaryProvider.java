package com.github.sparkzxl.auth.api;

import com.github.sparkzxl.auth.api.dto.DictionaryItemDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

/**
 * description: 字典API
 *
 * @author zhouxinlei
 * @date 2021-07-03 10:39:53
 */
public interface IDictionaryProvider {

    /**
     * 查询字典项列表
     *
     * @param dictionaryType 字典类型
     * @param codes          字典code
     * @return Map<String, DictionaryItem>
     */
    @GetMapping("/findDictionaryItemMap")
    Map<String, DictionaryItemDTO> findDictionaryItemMap(@RequestParam("dictionaryType") String dictionaryType, @RequestParam("codes") Set<String> codes);

}
