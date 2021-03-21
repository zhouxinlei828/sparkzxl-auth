package com.github.sparkzxl.workflow.interfaces.dto.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * description:创建模型入参
 *
 * @author charles.zhou
 * @date   2020-07-21 09:19:11
 */
@Data
@ApiModel("创建模型入参")
public class ModelSaveDTO {

    @ApiModelProperty(value = "模型key", required = true)
    @NotEmpty(message = "模型key不能为空")
    private String key;

    @ApiModelProperty(value = "模型名称", required = true)
    @NotEmpty(message = "模型名称不能为空")
    private String name;

}
