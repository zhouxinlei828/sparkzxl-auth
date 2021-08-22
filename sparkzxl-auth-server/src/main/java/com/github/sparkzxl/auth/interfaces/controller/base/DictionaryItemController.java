package com.github.sparkzxl.auth.interfaces.controller.base;


import com.github.sparkzxl.annotation.result.ResponseResult;
import com.github.sparkzxl.auth.api.IDictionaryApi;
import com.github.sparkzxl.auth.api.dto.DictionaryItemDTO;
import com.github.sparkzxl.auth.application.service.IDictionaryItemService;
import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.auth.interfaces.dto.dictionary.DictionaryItemQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.dictionary.DictionaryItemSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.dictionary.DictionaryItemUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.database.dto.PageParams;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * description: 字典项管理
 *
 * @author charles.zhou
 * @date 2020-07-28 19:48:30
 */
@AllArgsConstructor
@RestController
@ResponseResult
@WebLog
@Api(tags = "字典项管理")
@RequestMapping("/base/dictionaryItem")
public class DictionaryItemController extends SuperCacheController<IDictionaryItemService, Long,
        DictionaryItem, DictionaryItemSaveDTO, DictionaryItemUpdateDTO, DictionaryItemQueryDTO, Object> implements IDictionaryApi {

    @Override
    public List<DictionaryItem> query(DictionaryItemQueryDTO dictionaryItemQueryDTO) {
        return baseService.findDictionaryItemList(dictionaryItemQueryDTO);
    }

    @Override
    public void handlerQueryParams(PageParams<DictionaryItemQueryDTO> params) {
        DictionaryItemQueryDTO paramsModel = params.getModel();
        if (ObjectUtils.isNotEmpty(paramsModel.getDictionaryId()) && paramsModel.getDictionaryId() == 0L) {
            paramsModel.setDictionaryId(null);
        }
        if (StringUtils.isEmpty(paramsModel.getCode())) {
            paramsModel.setCode(null);
        }
        if (StringUtils.isEmpty(paramsModel.getName())) {
            paramsModel.setName(null);
        }
    }

    @Override
    public Map<String, DictionaryItemDTO> findDictionaryItemMap(String dictionaryType, Set<String> codes) {
        return baseService.findDictionaryItemMap(dictionaryType,codes);
    }
}
