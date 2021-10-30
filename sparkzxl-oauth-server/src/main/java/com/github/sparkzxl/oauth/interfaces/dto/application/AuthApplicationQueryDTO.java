package com.github.sparkzxl.oauth.interfaces.dto.application;

import com.github.sparkzxl.database.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 应用分页DTO
 *
 * @author charles.zhou
 * @date 2021-02-02 14:53:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("应用客户端分页DTO")
public class AuthApplicationQueryDTO extends PageDTO {


    @ApiModelProperty("应用名称")
    private String appName;

    @ApiModelProperty("客户端id")
    private String clientId;

}
