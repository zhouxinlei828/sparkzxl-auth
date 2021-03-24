package com.github.sparkzxl.auth.interfaces.dto.user;

import com.github.sparkzxl.database.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * description: 用户信息
 *
 * @author charles.zhou
 * @date 2020-05-24 12:24:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "AuthUserDTO分页查询对象", description = "AuthUserDTO分页查询对象")
public class UserQueryDTO extends PageDTO {

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "状态 1启用 0禁用")
    private Boolean status;

    @ApiModelProperty(value = "民族")
    private String nation;

    @ApiModelProperty(value = "组织id")
    private Long orgId;

}
