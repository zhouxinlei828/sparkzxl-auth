package com.github.sparkzxl.auth.infrastructure.oauth2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description: token信息
 *
 * @author charles.zhou
 * @date '2021-03-10 17:18:06'
 */
@ApiModel("token信息")
@Data
public class AccessTokenInfo implements Serializable {

    private static final long serialVersionUID = -7651157571646582864L;

    @ApiModelProperty("令牌信息")
    private String accessToken;

    @ApiModelProperty("token类型")
    private String tokenType;

    @ApiModelProperty("刷新令牌")
    private String refreshToken;

    @ApiModelProperty("有效期")
    private Date expiration;

}
