package com.github.sparkzxl.oauth.domain.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * description: 应用更新DTO
 *
 * @author charles.zhou
 * @date 2021-02-02 14:53:04
 */
@Data
@ApiModel("应用更新DTO")
public class AuthApplicationUpdateDTO {

    @ApiModelProperty(value = "主键")
    @NotNull(message = "主键不能为空")
    private Long id;

    @ApiModelProperty(value = "应用名称")
    @NotEmpty(message = "应用名称不能为空")
    private String name;

    @ApiModelProperty(value = "应用访问地址")
    @NotEmpty(message = "应用访问地址不能为空")
    private String website;

    @ApiModelProperty(value = "应用图标地址")
    private String icon;

    @ApiModelProperty(value = "类型 SERVER:服务应用;APP:手机应用;PC:PC网页应用;WAP:手机网页应用")

    @NotEmpty(message = "应用类型不能为空")
    private String appType;

    @ApiModelProperty(value = "应用简介")
    private String describe;

    @ApiModelProperty(value = "健康检查路径")
    private String healthCheck;

    @ApiModelProperty("应用客户端")
    private OauthClientDTO oauthClientDetail;

}
