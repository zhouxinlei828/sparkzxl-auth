package com.github.sparkzxl.auth.interfaces.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 资源分页对象
 *
 * @author charles.zhou
 * @date 2020-06-07 13:24:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "资源分页对象", description = "资源分页对象")
public class ResourceQueryDTO {

    private static final long serialVersionUID = -6295580114270886981L;

    @ApiModelProperty(value = "编码规则： 链接： 数据列： 按钮：")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

    /**
     * 登录人用户id
     */
    @ApiModelProperty(value = "指定用户id", notes = "指定用户id，前端不传则自动获取")
    private Long userId;
}
