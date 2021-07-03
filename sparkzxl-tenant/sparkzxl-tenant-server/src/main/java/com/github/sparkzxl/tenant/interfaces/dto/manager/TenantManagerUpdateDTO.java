package com.github.sparkzxl.tenant.interfaces.dto.manager;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 * description: 领域管理员更新对象
 *
 * @author charles.zhou
 * @date 2021-03-14 13:28:08
 */
@Data
@ApiModel(value = "领域管理员更新对象")
public class TenantManagerUpdateDTO {

    @ApiModelProperty(value = "领域管理员主键")
    @NotNull(message = "主键不能为空")
    private Long id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "状态 1启用 0禁用")
    private Boolean status;

}
