package com.github.sparkzxl.auth.interfaces.controller.base;


import com.github.sparkzxl.web.annotation.Response;
import com.github.sparkzxl.auth.application.service.IDictionaryService;
import com.github.sparkzxl.auth.infrastructure.entity.Dictionary;
import com.github.sparkzxl.auth.domain.model.dto.dictionary.DictionaryQueryDTO;
import com.github.sparkzxl.auth.domain.model.dto.dictionary.DictionarySaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.dictionary.DictionaryUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperController;
import com.github.sparkzxl.dto.PageParams;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 字典类型管理
 *
 * @author charles.zhou
 * @since 2020-07-28 19:48:00
 */
@RestController
@Response
@HttpRequestLog
@Api(tags = "字典类型管理")
@RequestMapping("/base/dictionary")
public class DictionaryController extends SuperController<IDictionaryService, Long,
        Dictionary, DictionarySaveDTO, DictionaryUpdateDTO, DictionaryQueryDTO, Object> {

    @Override
    public void handlerQueryParams(PageParams<DictionaryQueryDTO> params) {
        DictionaryQueryDTO paramsModel = params.getModel();
        if (StringUtils.isEmpty(paramsModel.getName())) {
            paramsModel.setName(null);
        }
        if (StringUtils.isEmpty(paramsModel.getType())) {
            paramsModel.setType(null);
        }
    }

    @Override
    public boolean handlerSave(DictionarySaveDTO model) {
        String type = StringUtils.toRootUpperCase(model.getType());
        model.setType(type);
        return true;
    }

    @Override
    public boolean handlerUpdate(DictionaryUpdateDTO model) {
        String type = StringUtils.toRootUpperCase(model.getType());
        model.setType(type);
        return true;
    }
}
