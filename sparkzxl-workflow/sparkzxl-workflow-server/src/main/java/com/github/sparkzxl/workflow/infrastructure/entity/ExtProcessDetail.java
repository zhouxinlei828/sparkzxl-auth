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
 * description: 流程详细节点
 *
 * @author charles.zhou
 * @date   2020-07-21 14:20:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ext_process_detail")
@ApiModel(value = "ProcessDetail对象", description = "")
public class ExtProcessDetail {

    private static final long serialVersionUID = -8334040441264344916L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = EntityConstant.COLUMN_ID, type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "模型id")
    @TableField("model_id")
    private String modelId;

    @ApiModelProperty(value = "流程定义key")
    @TableField("process_definition_key")
    private String processDefinitionKey;

    @ApiModelProperty(value = "流程名称")
    @TableField("process_name")
    private String processName;

    @ApiModelProperty(value = "任务定义key")
    @TableField("task_def_key")
    private String taskDefKey;

    @ApiModelProperty(value = "任务名称")
    @TableField("task_name")
    private String taskName;

    @ApiModelProperty(value = "任务类型")
    @TableField("type")
    private String type;

    @TableField(value = EntityConstant.COLUMN_UPDATE_TIME, fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime updateTime;

    @TableField(value = EntityConstant.COLUMN_CREATE_TIME, fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime createTime;

}
