package com.github.sparkzxl.workflow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * description:删除流程实例入参
 *
 * @author charles.zhou
 * @date   2020-10-01 19:52:24
 */
@Data
@ApiModel("删除流程实例入参")
public class ProcessInstanceDeleteDTO {

    @ApiModelProperty("业务主键")
    List<String> businessIds;

    @ApiModelProperty("流程实例id")
    List<String> processInstanceIds;

    @ApiModelProperty("挂起类型：1.业务挂起 2. 实例挂起")
    Integer type;

    @ApiModelProperty("删除原因")
    private String deleteReason;

}
