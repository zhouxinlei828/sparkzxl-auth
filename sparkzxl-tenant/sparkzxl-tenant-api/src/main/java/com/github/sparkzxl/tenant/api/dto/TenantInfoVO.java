package com.github.sparkzxl.tenant.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * description: 租户信息
 *
 * @author charles.zhou
 * @date 2021-02-02 16:08:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "TenantInfoVO对象", description = "租户信息")
public class TenantInfoVO implements Serializable {

    private static final long serialVersionUID = -6822251163986817811L;

    private Long id;

    @ApiModelProperty(value = "租户用户id")
    private Long tenantUserId;

    @ApiModelProperty(value = "租户信息编码")
    private String code;

    @ApiModelProperty(value = "租户信息名称")
    private String name;

    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "内置租户信息")
    private Boolean readonly;

    @ApiModelProperty(value = "logo地址")
    private String logo;

    @ApiModelProperty(value = "租户信息简介")
    private String describe;

    @ApiModelProperty(value = "用户数")
    private int userCount;

}
