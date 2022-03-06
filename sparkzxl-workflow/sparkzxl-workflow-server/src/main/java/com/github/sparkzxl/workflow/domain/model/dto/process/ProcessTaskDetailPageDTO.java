package com.github.sparkzxl.workflow.domain.model.dto.process;

import com.github.sparkzxl.database.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description:ProcessTaskDetail显示层对象
 *
 * @author charles.zhou
 * @date 2020-07-21 14:56:57
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ProcessTaskDetail显示层对象", description = "")
public class ProcessTaskDetailPageDTO extends PageDTO {

    @ApiModelProperty(value = "主键")
    protected Long id;

    @ApiModelProperty(value = "流程定义key")
    private String processDefinitionKey;

    @ApiModelProperty(value = "流程名称")
    private String processName;

}
