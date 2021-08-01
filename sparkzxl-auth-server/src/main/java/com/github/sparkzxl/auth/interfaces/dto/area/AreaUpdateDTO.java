package com.github.sparkzxl.auth.interfaces.dto.area;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 字典项更新入参
 *
 * @author charles.zhou
 * @date 2020-12-02 10:15:37
 */
@Data
@ApiModel("字典项更新入参")
public class AreaUpdateDTO {

    @ApiModelProperty(value = "名称")
    protected String label;
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "上级地区")
    private Long parentId;
    @ApiModelProperty(value = "编码")
    private String code;
    @ApiModelProperty(value = "行政区级")
    private String level;

}
