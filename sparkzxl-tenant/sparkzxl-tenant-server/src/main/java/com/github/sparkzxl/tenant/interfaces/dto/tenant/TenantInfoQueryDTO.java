package com.github.sparkzxl.tenant.interfaces.dto.tenant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * description: 租户信息分页查询对象
 *
 * @author charles.zhou
 * @date 2020-07-27 19:49:46
 */
@Data
@ApiModel(value = "租户信息分页查询对象")
public class TenantInfoQueryDTO {

    @ApiModelProperty(value = "租户用户id")
    @NotNull(message = "租户用户id不能为空")
    private Long tenantUserId;

    @ApiModelProperty(value = "租户信息编码")
    private String code;

    @ApiModelProperty(value = "租户信息名称")
    private String name;

}
