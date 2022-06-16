package com.github.sparkzxl.workflow.domain.model.dto.datasource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * description: 业务数据源更新对象
 *
 * @author charles.zhou
 * @since 2020-08-15 18:05:09
 */
@Data
@ApiModel(value = "业务数据源更新对象")
public class BusDatasourceUpdateDTO {

    @ApiModelProperty(value = "主键")
    @NotNull(message = "业务数据源id不能为空")
    private Long id;

    @ApiModelProperty(value = "数据源名称")
    private String name;

    @ApiModelProperty(value = "数据源连接地址")
    private String jdbcUrl;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

}
