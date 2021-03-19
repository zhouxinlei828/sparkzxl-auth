package com.github.sparkzxl.auth.interfaces.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description：
 *
 * @author charles.zhou
 * @date 2020/6/16 0016
 */

@Data
@ApiModel("角色分页查询对象")
public class RoleQueryDTO {

    @ApiModelProperty(value = "角色编码")
    private String code;

    @ApiModelProperty(value = "角色名称")
    private String name;
}
