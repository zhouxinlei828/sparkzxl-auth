package com.github.sparkzxl.workflow.interfaces.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 流程用户更新DTO
 *
 * @author charles.zhou
 * @date 2021-05-17 09:39:35
 */
@Data
@ApiModel("流程用户更新DTO")
public class ProcessUserUpdateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户账户")
    private String account;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "状态 1启用 0禁用")
    private Boolean status;

}
