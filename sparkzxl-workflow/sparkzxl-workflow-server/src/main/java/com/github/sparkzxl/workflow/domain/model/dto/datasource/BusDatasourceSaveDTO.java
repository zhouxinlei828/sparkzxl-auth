package com.github.sparkzxl.workflow.domain.model.dto.datasource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 业务数据源保存对象
 *
 * @author charles.zhou
 * @date 2020-08-15 18:05:09
 */
@Data
@ApiModel(value = "业务数据源保存对象")
public class BusDatasourceSaveDTO {

    @ApiModelProperty(value = "数据源名称")
    private String name;

    @ApiModelProperty(value = "数据源连接地址")
    private String jdbcUrl;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

}
