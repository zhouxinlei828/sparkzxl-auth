package com.github.sparkzxl.workflow.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * description: 业务表结构
 *
 * @author charles.zhou
 * @date 2021-03-26 11:11:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ext_bus_table")
@ApiModel(value = "ExtBusTable对象", description = "业务表结构")
public class ExtBusTable implements Serializable {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "数据源")
    @TableField("data_source_id")
    private String dataSourceId;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "别名")
    @TableField("alias")
    private String alias;

    @ApiModelProperty(value = "数据库表名")
    @TableField("table_name")
    private String tableName;

    @ApiModelProperty(value = "自动生成表结构")
    @TableField("auto_generate")
    private Boolean autoGenerate;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "表结构字段")
    @TableField(exist = false)
    private List<ExtBusTableColumn> columnList;

}
