package com.github.sparkzxl.workflow.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description: 业务表字段
 *
 * @author charles.zhou
 * @date 2021-03-26 11:11:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ext_bus_table_column")
@ApiModel(value = "ExtBusTableColumn对象", description = "业务表字段")
public class ExtBusTableColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "表结构id")
    @TableField("table_id")
    private Long tableId;

    @ApiModelProperty(value = "属性名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "数据库字段名")
    @TableField("field")
    private String field;

    @ApiModelProperty(value = "字段类型")
    @TableField("field_type")
    private String fieldType;

    @ApiModelProperty(value = "是否是主键")
    @TableField("primary_key")
    private Boolean primaryKey;

    @ApiModelProperty(value = "字段长度")
    @TableField("field_length")
    private Integer fieldLength;

    @ApiModelProperty(value = "是否必填")
    @TableField("required")
    private Boolean required;

    @ApiModelProperty(value = "默认值")
    @TableField("default_value")
    private String defaultValue;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
