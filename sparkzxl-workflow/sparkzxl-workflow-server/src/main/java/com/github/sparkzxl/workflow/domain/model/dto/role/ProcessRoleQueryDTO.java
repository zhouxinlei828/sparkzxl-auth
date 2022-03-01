package com.github.sparkzxl.workflow.domain.model.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 流程角色查询DTO
 *
 * @author charles.zhou
 * @date 2021-05-17 09:39:35
 */
@Data
@ApiModel("流程角色查询DTO")
public class ProcessRoleQueryDTO {

    @ApiModelProperty(value = "角色code")
    private String code;

    @ApiModelProperty(value = "角色名称")
    private String name;

}
