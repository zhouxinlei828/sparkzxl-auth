package com.github.sparkzxl.workflow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * description: 用户任务详情
 *
 * @author charles.zhou
 * @date 2020-07-22 18:14:38
 */
@Data
@ApiModel("用户任务详情")
public class UserNextTask {

    @ApiModelProperty("任务id")
    protected String taskId;
    @ApiModelProperty("任务代理人")
    protected String assignee;
    @ApiModelProperty("任务拥有者")
    protected String owner;
    @ApiModelProperty("任务优先级")
    protected String priority;
    @ApiModelProperty("任务到期日")
    protected Date dueDate;
    protected String businessCalendarName;
    @ApiModelProperty("任务候选人信息")
    protected List<WorkflowUserInfo> candidateUserInfos;
    @ApiModelProperty("任务候选人姓名")
    protected String candidateUserNames;
    @ApiModelProperty("任务候选人")
    protected List<String> candidateUsers;
    @ApiModelProperty("任务候选人组")
    protected List<String> candidateGroups;
    @ApiModelProperty("任务定义key")
    private String taskDefKey;
    @ApiModelProperty("任务名称")
    private String taskName;

}
