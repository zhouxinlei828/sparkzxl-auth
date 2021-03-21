package com.github.sparkzxl.workflow.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 流程统计总览
 *
 * @author charles.zhou
 * @date   2020-12-18 09:05:39
*/
@Data
@ApiModel("流程统计总览")
public class InstanceOverview {

    @ApiModelProperty("今日新增流程实例")
    private int todayCount;

    @ApiModelProperty("本周新增流程实例")
    private int weekCount;

    @ApiModelProperty("已完成流程实例")
    private int finishCount;

    @ApiModelProperty("未完成流程实例")
    private int unFinishCount;

    @ApiModelProperty("本月新增流程实例")
    private int monthCount;

    @ApiModelProperty("流程实例总数量")
    private int totalCount;

}
