package com.github.sparkzxl.auth.interfaces.controller.base;


import com.github.sparkzxl.web.annotation.Response;
import com.github.sparkzxl.auth.application.service.ISysParameterService;
import com.github.sparkzxl.auth.infrastructure.entity.SysParameter;
import com.github.sparkzxl.auth.domain.model.dto.parameter.SysParameterQueryDTO;
import com.github.sparkzxl.auth.domain.model.dto.parameter.SysParameterSaveDTO;
import com.github.sparkzxl.auth.domain.model.dto.parameter.SysParameterUpdateDTO;
import com.github.sparkzxl.database.base.controller.SuperController;
import com.github.sparkzxl.log.annotation.HttpRequestLog;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 系统参数 前端控制器
 *
 * @author zhoux
 * @since 2021-06-13 12:09:34
 */
@AllArgsConstructor
@RestController
@Response
@HttpRequestLog
@Api(tags = "系统参数管理")
@RequestMapping("/base/parameter")
public class SysParameterController extends SuperController<ISysParameterService, Long,
        SysParameter, SysParameterSaveDTO, SysParameterUpdateDTO, SysParameterQueryDTO, Object> {


    @GetMapping("getByCode")
    public SysParameter getSysParameterByCode(@RequestParam("code") String code) {
        return baseService.getSysParameterByCode(code);
    }
}
