package com.github.sparkzxl.workflow.interfaces.dto.process;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * description:流程动作类型
 *
 * @author charles.zhou
 * @date   2020-07-28 11:40:39
 */
@Data
@Builder
@ApiModel("流程动作类型")
public class ProcessActionDTO {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;
}
