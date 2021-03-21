package com.github.sparkzxl.workflow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * description: 业务任务数据
 *
 * @author charles.zhou
 * @date   2020-10-01 19:56:14
 */
@Data
@ApiModel("业务任务数据")
public class BusTaskInfo {

    @ApiModelProperty(value = "流程定义key")
    private String processDefinitionKey;

    @ApiModelProperty(value = "业务主键")
    protected String businessId;

    @ApiModelProperty(value = "流程动作类型")
    private Map<Object, Object> actTypeMap;

    @ApiModelProperty(value = "下一步任务")
    private UserNextTask userNextTask;

    @ApiModelProperty(value = "当前用户是否有审批权限")
    private boolean approvalAuthority;
}
