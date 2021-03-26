package com.github.sparkzxl.workflow.interfaces.dto.table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 业务表结构查询对象
 *
 * @author charles.zhou
 * @date 2020-08-15 18:05:09
 */
@Data
@ApiModel(value = "业务表结构查询对象")
public class BusTableQueryDTO {

    @ApiModelProperty(value = "数据源")
    private String dataSourceId;

    @ApiModelProperty(value = "别名")
    private String alias;

    @ApiModelProperty(value = "数据库表名")
    private String tableName;


}
