package com.github.sparkzxl.auth.interfaces.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * description：角色分页查询对象
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

    @ApiModelProperty(value = "角色属性")
    private Map<String, Object> attribute;

}
