package com.github.sparkzxl.workflow.domain.model.dto.process;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description:ProcessTaskDetail显示层对象
 *
 * @author charles.zhou
 * @since 2020-07-21 14:56:57
 */
@Data
@ApiModel(value = "ProcessTaskDetail显示层对象", description = "")
public class ProcessTaskDetailDTO {

    @ApiModelProperty(value = "主键")
    protected Long id;

    @ApiModelProperty(value = "模型id")
    private String modelId;

    @ApiModelProperty(value = "流程定义key")
    private String processDefinitionKey;

    @ApiModelProperty(value = "流程名称")
    private String processName;

    @ApiModelProperty(value = "任务定义key")
    private String taskDefKey;

    @ApiModelProperty(value = "任务名称")
    private String taskName;
}
