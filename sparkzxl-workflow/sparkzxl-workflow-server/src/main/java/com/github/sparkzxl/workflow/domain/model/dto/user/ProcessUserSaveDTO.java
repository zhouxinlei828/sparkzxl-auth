package com.github.sparkzxl.workflow.domain.model.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 流程用户保存DTO
 *
 * @author charles.zhou
 * @date 2021-05-17 09:39:35
 */
@Data
@ApiModel("流程用户保存DTO")
public class ProcessUserSaveDTO {

    @ApiModelProperty(value = "用户账户")
    private String account;

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "状态 1启用 0禁用")
    private Boolean status;

}
