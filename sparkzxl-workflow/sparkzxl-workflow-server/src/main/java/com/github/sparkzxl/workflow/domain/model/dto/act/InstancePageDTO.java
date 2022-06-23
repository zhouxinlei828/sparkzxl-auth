package com.github.sparkzxl.workflow.domain.model.dto.act;

import com.github.sparkzxl.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 模型分页查询
 *
 * @author charles.zhou
 * @since 2020-07-25 11:20:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "流程实例分页查询")
public class InstancePageDTO extends PageDTO {

    @ApiModelProperty("流程实例id")
    private String processInstanceId;
}
