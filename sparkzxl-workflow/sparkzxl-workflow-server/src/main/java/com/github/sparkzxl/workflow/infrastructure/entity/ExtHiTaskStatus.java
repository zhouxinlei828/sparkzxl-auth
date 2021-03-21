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
 * description: 任务历史状态记录（新加表）
 *
 * @author charles.zhou
 * @date   2020-07-16 18:39:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ext_hi_task_status")
@ApiModel(value = "ActHiTaskStatus对象", description = "")
public class ExtHiTaskStatus {

    private static final long serialVersionUID = 7233248562949888216L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = EntityConstant.COLUMN_ID, type = IdType.INPUT)
    protected Long id;

    @ApiModelProperty(value = "流程实例id")
    @TableField("process_instance_id")
    private String processInstanceId;

    @ApiModelProperty(value = "任务id")
    @TableField("task_id")
    private String taskId;

    @ApiModelProperty(value = "任务定义key")
    @TableField("task_def_key")
    private String taskDefKey;

    @ApiModelProperty(value = "任务状态")
    @TableField("task_status")
    private String taskStatus;

    @TableField(value = EntityConstant.COLUMN_UPDATE_TIME, fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime updateTime;

    @TableField(value = EntityConstant.COLUMN_CREATE_TIME, fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime createTime;

}
