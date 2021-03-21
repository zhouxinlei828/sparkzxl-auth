package com.github.sparkzxl.workflow.interfaces.dto.process;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * description:
 *
 * @author charles.zhou
 * @date   2020-07-21 14:56:57
 */
@Data
@ApiModel(value = "TaskRule保存对象", description = "")
public class TaskRuleSaveDTO {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty(value = "流程详细id")
    @NotNull(message = "流程详细id不能为空")
    private Long processDetailId;

    @ApiModelProperty(value = "目标任务定义key")
    @NotNull(message = "目标任务不能为空")
    private String taskDefKey;

    @ApiModelProperty(value = "目标任务名称")
    private String taskName;

    @ApiModelProperty(value = "流程类型")
    @NotNull(message = "流程类型不能为空")
    private Integer actType;

}
