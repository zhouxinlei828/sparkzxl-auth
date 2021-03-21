package com.github.sparkzxl.workflow.interfaces.dto.process;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * description: 流程驱动入参
 *
 * @author charles.zhou
 * @date   2020-07-20 16:00:12
 */
@Getter
@Setter
@ToString
@ApiModel("下一步任务查询入参")
public class ProcessNextTaskDTO {

    @ApiModelProperty(value = "流程实例id", required = true)
    private String processInstanceId;

    @ApiModelProperty(value = "业务数据")
    private Map<String, Object> variables;

}
