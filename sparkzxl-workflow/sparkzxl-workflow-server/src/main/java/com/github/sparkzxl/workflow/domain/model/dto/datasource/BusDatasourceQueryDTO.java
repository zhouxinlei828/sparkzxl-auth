package com.github.sparkzxl.workflow.domain.model.dto.datasource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 业务数据源查询对象
 *
 * @author charles.zhou
 * @date 2020-08-15 18:05:09
 */
@Data
@ApiModel(value = "业务数据源查询对象")
public class BusDatasourceQueryDTO {

    @ApiModelProperty(value = "数据源名称")
    private String name;

    @ApiModelProperty(value = "数据源连接地址")
    private String jdbcUrl;


}
