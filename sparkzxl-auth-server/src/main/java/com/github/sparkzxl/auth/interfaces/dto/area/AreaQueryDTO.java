package com.github.sparkzxl.auth.interfaces.dto.area;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 地区分页查询入参
 *
 * @author charles.zhou
 * @date   2020-12-02 10:13:57
*/
@Data
@ApiModel("地区分页查询入参")
public class AreaQueryDTO {

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "名称")
    protected String label;

}
