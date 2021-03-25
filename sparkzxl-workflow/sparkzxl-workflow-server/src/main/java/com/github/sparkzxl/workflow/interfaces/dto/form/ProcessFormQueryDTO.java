package com.github.sparkzxl.workflow.interfaces.dto.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 流程表单查询对象
 *
 * @author charles.zhou
 * @date 2020-08-15 18:05:09
 */
@Data
@ApiModel(value = "流程表单查询对象")
public class ProcessFormQueryDTO {

    @ApiModelProperty(value = "模板名称")
    private String name;

    @ApiModelProperty(value = "表单类型")
    private String formType;

}
