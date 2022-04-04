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
@ApiModel(value = "SysParameter查询对象", description = "系统参数")
public class SysParameterQueryDTO {

    @ApiModelProperty(value = "参数code")
    private String code;

    @ApiModelProperty(value = "参数名称")
    private String name;

}
