package com.github.sparkzxl.workflow.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * description:删除流程实例入参
 *
 * @author charles.zhou
 * @since 2020-10-01 19:52:24
 */
@Data
@ApiModel("删除流程实例入参")
public class ProcessInstanceDeleteDTO {

    @ApiModelProperty("业务主键")
    List<String> businessIds;

    @ApiModelProperty("流程实例id")
    List<String> processInstanceIds;

    @ApiModelProperty(value = "删除类型：1.业务删除 2. 实例删除", example = "1")
    @NotNull(message = "流程删除类型不能为空")
    Integer type;

    @ApiModelProperty("删除原因")
    private String deleteReason;

}
