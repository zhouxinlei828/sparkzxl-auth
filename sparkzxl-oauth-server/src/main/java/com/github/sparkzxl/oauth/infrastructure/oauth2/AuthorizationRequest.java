package com.github.sparkzxl.oauth.infrastructure.oauth2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * description:
 *
 * @author charles.zhou
 * @date 2020-08-04 15:26:10
 */
@Data
@ApiModel(value = "授权请求参数")
public class AuthorizationRequest {

    @ApiModelProperty(value = "授权类型：password，authorization_code，refresh_token", required = true, example = "password")
    @NotEmpty(message = "授权类型不能为空")
    private String grantType;

    @ApiModelProperty(value = "客户端id")
    @NotEmpty(message = "客户端id不能为空")
    private String clientId;

    @ApiModelProperty(value = "刷新token，授权类型为refresh_token,参数必传", allowEmptyValue = true)
    private String refreshToken;

    @ApiModelProperty(value = "用户名，授权类型为password,参数必传", allowEmptyValue = true)
    private String username;

    @ApiModelProperty(value = "密码，授权类型为password,参数必传", allowEmptyValue = true)
    private String password;

    @ApiModelProperty(value = "验证码key")
    private String captchaKey;

    @ApiModelProperty(value = "验证码")
    private String captchaCode;

}
