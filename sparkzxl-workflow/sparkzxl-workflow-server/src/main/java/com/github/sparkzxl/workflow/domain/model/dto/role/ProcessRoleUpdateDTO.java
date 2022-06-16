package com.github.sparkzxl.workflow.domain.model.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 流程角色更新DTO
 *
 * @author charles.zhou
 * @since 2021-05-17 09:39:35
 */
@Data
@ApiModel("流程角色更新DTO")
public class ProcessRoleUpdateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "角色code")
    private String code;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "状态 1启用 0禁用")
    private Boolean status;

}
