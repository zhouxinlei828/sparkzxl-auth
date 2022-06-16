package com.github.sparkzxl.workflow.infrastructure.entity;

import com.github.sparkzxl.workflow.dto.BusTaskInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description: 流程实例实体类
 *
 * @author charles.zhou
 * @since 2020-07-27 10:04:02
 */
@Data
@ApiModel(value = "ProcessInstance对象", description = "流程实例对象")
public class ProcessInstance implements Serializable {

    private static final long serialVersionUID = -960121899283253114L;

    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;

    @ApiModelProperty(value = "业务主键")
    private String businessKey;

    @ApiModelProperty(value = "流程名称")
    private String processName;

    @ApiModelProperty(value = "流程key")
    private String processKey;

    @ApiModelProperty(value = "是否挂起")
    private Integer suspensionState;

    @ApiModelProperty(value = "流程状态")
    private String status;

    @ApiModelProperty(value = "开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "业务发起人")
    private String originator;

    @ApiModelProperty(value = "业务发起人姓名")
    private String originatorName;

    @ApiModelProperty(value = "完成时间")
    private LocalDateTime finishTime;

    @ApiModelProperty(value = "持续时长")
    private Long duration;

    @ApiModelProperty(value = "持续时间")
    private String dueTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "当前任务")
    private BusTaskInfo busTaskInfo;

    @ApiModelProperty(value = "任务节点")
    private String taskName;

    @ApiModelProperty(value = "任务候选人")
    private String candidateUserNames;
}
