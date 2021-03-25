package com.github.sparkzxl.workflow.interfaces.controller.ext;


import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.database.base.controller.SuperCacheController;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessFormService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessForm;
import com.github.sparkzxl.workflow.interfaces.dto.form.ProcessFormQueryDTO;
import com.github.sparkzxl.workflow.interfaces.dto.form.ProcessFormSaveDTO;
import com.github.sparkzxl.workflow.interfaces.dto.form.ProcessFormUpdateDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 流程表单管理
 *
 * @author charles.zhou
 * @date 2021-03-25 18:03:38
 */
@ResponseResult
@RestController
@RequestMapping("/process/form")
@WebLog
@Api(tags = "流程表单管理")
public class ExtProcessFormController extends SuperCacheController<IExtProcessFormService, Long,
        ExtProcessForm, ProcessFormSaveDTO, ProcessFormUpdateDTO, ProcessFormQueryDTO, Object> {

}
