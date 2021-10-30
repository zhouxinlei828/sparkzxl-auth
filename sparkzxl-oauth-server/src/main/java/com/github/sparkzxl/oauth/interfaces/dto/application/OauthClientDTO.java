package com.github.sparkzxl.oauth.interfaces.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * description: 应用客户端DTO
 *
 * @author charles.zhou
 * @date 2021-02-02 14:53:04
 */
@Data
@ApiModel("应用客户端DTO")
public class OauthClientDTO {

    @ApiModelProperty("客户端id")
    private String clientId;

    @ApiModelProperty("资源保护id列表")
    private String resourceIds;

    @ApiModelProperty("客户端密钥")
    private String clientSecret;

    @ApiModelProperty("授权范围")
    private String scope;

    @ApiModelProperty("授权认证类型")
    private String authorizedGrantTypes;

    @ApiModelProperty("授权回调地址")
    private String webServerRedirectUri;

    @ApiModelProperty("权限列表")
    private String authorities;

    @ApiModelProperty("token有效期")
    private Integer accessTokenValidity;

    @ApiModelProperty("刷新token有效期")
    private Integer refreshTokenValidity;

    @ApiModelProperty("自定义信息")
    private String additionalInformation;

    @ApiModelProperty("自动授权")
    private String autoApprove;

}
