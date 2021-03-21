package com.github.sparkzxl.workflow.interfaces.dto.process;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * description: 流程历史显示层对象
 *
 * @author charles.zhou
 * @date   2020-07-23 14:14:49
 */
@Data
@ApiModel(value = "ProcessHistoryDTO显示层对象", description = "")
public class ProcessHistoryDTO {

    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;

    @ApiModelProperty(value = "任务id")
    private String taskId;

    @ApiModelProperty(value = "任务名称")
    private String taskName;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "处理时间")
    private Date endTime;

    @ApiModelProperty(value = "时长，耗时")
    private Long duration;

    @ApiModelProperty(value = "候选人")
    private String candidate;

    @ApiModelProperty(value = "处理人")
    private String assignee;

    @ApiModelProperty(value = "到期时间")
    private Date dueDate;

    @ApiModelProperty(value = "任务处理状态")
    private String taskStatus;

    @ApiModelProperty(value = "备注/意见")
    private String comment;
}
