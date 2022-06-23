package com.github.sparkzxl.auth.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 岗位基本信息
 *
 * @author charles.zhou
 * @since 2020-12-27 11:21:33
 */
@Data
@ApiModel("岗位基本信息")
public class StationBasicInfo {

    @ApiModelProperty(value = "岗位id")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

}
