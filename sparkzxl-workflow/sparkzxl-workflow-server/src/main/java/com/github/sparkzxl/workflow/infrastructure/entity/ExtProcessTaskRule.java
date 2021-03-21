package com.github.sparkzxl.workflow.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.sparkzxl.database.constant.EntityConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * description: 流程跳转控制实体类
 *
 * @author charles.zhou
 * @date   2020-07-16 18:35:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ext_process_task_rule")
@ApiModel(value = "ProcessTaskRule对象", description = "")
public class ExtProcessTaskRule {

    private static final long serialVersionUID = -1050730327543899364L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = EntityConstant.COLUMN_ID, type = IdType.INPUT)
    protected Long id;

    @ApiModelProperty(value = "流程详细id")
    @TableField("process_detail_id")
    private String processDetailId;

    @ApiModelProperty(value = "目标任务定义key")
    @TableField("task_def_key")
    private String taskDefKey;

    @ApiModelProperty(value = "目标任务名称")
    @TableField("task_name")
    private String taskName;

    @ApiModelProperty(value = "流程类型")
    @TableField("act_type")
    private Integer actType;

    @ApiModelProperty(value = "流程定义key")
    @TableField(exist = false)
    private String processDefinitionKey;

    @ApiModelProperty(value = "流程名称")
    @TableField(exist = false)
    private String processName;

    @ApiModelProperty(value = "开始任务定义key")
    @TableField(exist = false)
    private String sourceTaskDefKey;

    @ApiModelProperty(value = "开始任务名称")
    @TableField(exist = false)
    private String sourceTaskName;

    @ApiModelProperty(value = "目标任务定义key")
    @TableField(exist = false)
    private String targetTaskDefKey;

    @ApiModelProperty(value = "目标任务名称")
    @TableField(exist = false)
    private String targetTaskName;

    @TableField(value = EntityConstant.COLUMN_UPDATE_TIME, fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime updateTime;

    @TableField(value = EntityConstant.COLUMN_CREATE_TIME, fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime createTime;

}
