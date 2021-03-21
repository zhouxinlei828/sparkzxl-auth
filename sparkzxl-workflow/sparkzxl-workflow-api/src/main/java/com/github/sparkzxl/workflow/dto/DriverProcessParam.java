package com.github.sparkzxl.workflow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * description:流程驱动入参
 *
 * @author charles.zhou
 * @date   2020-10-01 19:52:24
 */
@Data
@ApiModel("流程驱动入参")
public class DriverProcessParam {

    @ApiModelProperty(value = "流程定义key", required = true)
    @NotEmpty(message = "流程定义key不能为空")
    private String processDefinitionKey;

    @ApiModelProperty(value = "业务主键", required = true)
    @NotEmpty(message = "业务主键不能为空")
    protected String businessId;

    @ApiModelProperty(value = "流程动作类型", required = true)
    @NotNull(message = "流程动作类型不能为空")
    private Integer actType;

    @ApiModelProperty(value = "评论")
    private String comment;

    @ApiModelProperty(value = "任务代理人")
    private String applyUserId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "是否需要跳转")
    private Boolean needJump;

}
