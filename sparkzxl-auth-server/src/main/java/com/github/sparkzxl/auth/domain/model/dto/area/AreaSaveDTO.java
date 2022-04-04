package com.github.sparkzxl.auth.domain.model.dto.area;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 字典项保存入参
 *
 * @author charles.zhou
 * @date 2020-12-02 10:14:51
 */
@Data
@ApiModel("地区保存入参")
public class AreaSaveDTO {

    @ApiModelProperty(value = "名称")
    protected String label;
    @ApiModelProperty(value = "排序值")
    protected Integer sortNumber;
    @ApiModelProperty(value = "地区id")
    private Long id;
    @ApiModelProperty(value = "上级地区")
    private Long parentId;
    @ApiModelProperty(value = "行政区级")
    private String level;

}
