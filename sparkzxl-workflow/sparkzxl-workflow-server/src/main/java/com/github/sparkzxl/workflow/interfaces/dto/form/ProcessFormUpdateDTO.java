package com.github.sparkzxl.workflow.interfaces.dto.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * description: 流程表单更新对象
 *
 * @author charles.zhou
 * @date 2020-08-15 18:05:09
 */
@Data
@ApiModel(value = "流程表单更新对象")
public class ProcessFormUpdateDTO {

    @ApiModelProperty(value = "主键")
    @NotNull(message = "流程表单id不能为空")
    private Long id;

    @ApiModelProperty(value = "模板名称")
    private String name;

    @ApiModelProperty(value = "表单类型")
    private String formType;

    @ApiModelProperty(value = "模板json")
    private String formJson;

}
