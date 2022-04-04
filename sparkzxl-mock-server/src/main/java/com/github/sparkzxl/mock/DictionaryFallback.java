package com.github.sparkzxl.mock;

import com.github.sparkzxl.auth.api.dto.DictionaryItemDTO;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * description: 字典降级处理
 *
 * @author zhoux
 * @date 2021-08-22 12:12:28
 */
@Component
public class DictionaryFallback implements DictionaryProvider {
    @Override
    public Map<String, DictionaryItemDTO> findDictionaryItemMap(String dictionaryType, Set<String> codes) {
        return null;
    }
}
