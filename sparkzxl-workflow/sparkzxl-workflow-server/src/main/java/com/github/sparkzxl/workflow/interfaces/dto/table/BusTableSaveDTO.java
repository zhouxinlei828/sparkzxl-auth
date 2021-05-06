package com.github.sparkzxl.workflow.interfaces.dto.table;

import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTableColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * description: 业务表结构保存对象
 *
 * @author charles.zhou
 * @date 2020-08-15 18:05:09
 */
@Data
@ApiModel(value = "业务表结构保存对象")
public class BusTableSaveDTO {

    @ApiModelProperty(value = "数据源")
    private String dataSourceId;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "别名")
    private String alias;

    @ApiModelProperty(value = "数据库表名")
    private String tableName;

    @ApiModelProperty(value = "自动生成表结构")
    private Boolean autoGenerate;

    @ApiModelProperty(value = "表结构字段")
    private List<ExtBusTableColumn> columnList;

}
