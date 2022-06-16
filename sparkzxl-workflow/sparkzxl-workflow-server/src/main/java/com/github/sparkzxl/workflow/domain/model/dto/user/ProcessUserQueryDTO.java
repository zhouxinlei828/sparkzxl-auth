package com.github.sparkzxl.workflow.domain.model.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 流程用户查询DTO
 *
 * @author charles.zhou
 * @since 2021-05-17 09:39:35
 */
@Data
@ApiModel("流程用户查询DTO")
public class ProcessUserQueryDTO {

    @ApiModelProperty(value = "用户账户")
    private String account;

    @ApiModelProperty(value = "用户姓名")
    private String name;
}
