package com.github.sparkzxl.workflow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description:流程历史查询入参
 *
 * @author charles.zhou
 * @date   2020-10-01 19:52:24
 */
@Data
@ApiModel("流程历史查询入参")
public class ProcessHistoryParam {

    @ApiModelProperty("业务主键")
    private String businessId;

    @ApiModelProperty("流程实例id")
    private String processInstanceId;

    @ApiModelProperty("查询类型：1.业务主键 2. 流程实例id")
    private Integer type;

}
