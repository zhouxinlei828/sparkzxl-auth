package com.github.sparkzxl.auth.interfaces.controller.base;


import com.github.sparkzxl.auth.application.service.ISysParameterService;
import com.github.sparkzxl.auth.infrastructure.entity.DictionaryItem;
import com.github.sparkzxl.auth.infrastructure.entity.SysParameter;
import com.github.sparkzxl.auth.interfaces.dto.dictionary.DictionaryItemQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.dictionary.DictionaryItemSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.dictionary.DictionaryItemUpdateDTO;
import com.github.sparkzxl.auth.interfaces.dto.parameter.SysParameterQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.parameter.SysParameterSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.parameter.SysParameterUpdateDTO;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.github.sparkzxl.database.base.controller.SuperCacheController;

/**
 * description: 系统参数 前端控制器
 *
 * @author zhoux
 * @date 2021-06-13 12:09:34
 */
@AllArgsConstructor
@RestController
@ResponseResult
@WebLog
@Api(tags = "系统参数管理")
@RequestMapping("/base/sys")
public class SysParameterController extends SuperCacheController<ISysParameterService, Long,
        SysParameter, SysParameterSaveDTO, SysParameterUpdateDTO, SysParameterQueryDTO, Object> {

}
