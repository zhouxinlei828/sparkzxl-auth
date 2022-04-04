package com.github.sparkzxl.auth.domain.model.dto.parameter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 系统参数
 *
 * @author zhoux
 * @date 2021-06-13 12:05:27
 */
@Data
@ApiModel(value = "SysParameter更新对象", description = "系统参数")
public class SysParameterUpdateDTO {

    @ApiModelProperty(value = "主键")
    protected Long id;

    @ApiModelProperty(value = "参数code")
    private String code;

    @ApiModelProperty(value = "参数名称")
    private String name;

    @ApiModelProperty(value = "参数值")
    private String value;

    @ApiModelProperty(value = "描述")
    private String des;

    @ApiModelProperty(value = "状态0 禁用 1 启用")
    private Boolean status;

    @ApiModelProperty(value = "只读")
    private Boolean readonly;

}
