package com.github.sparkzxl.auth.domain.model.dto.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 菜单更新对象
 *
 * @author charles.zhou
 * @since 2020-08-15 18:05:09
 */
@Data
@ApiModel(value = "菜单更新对象")
public class AuthMenuUpdateDTO {

    @ApiModelProperty(value = "上级菜单id", example = "0")
    protected Long parentId;
    @ApiModelProperty(value = "排序值", example = "1")
    protected Integer sortNumber;
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "菜单是否可见")
    private Boolean hidden;
    @ApiModelProperty(value = "自动进行重定向")
    private String redirect;
    @ApiModelProperty(value = "菜单缓存")
    private Boolean noKeepAlive;
    @ApiModelProperty(value = "名称")
    private String label;
    @ApiModelProperty(value = "描述")
    private String describe;
    @ApiModelProperty(value = "路径")
    private String path;
    @ApiModelProperty(value = "组件名称")
    private String componentName;
    @ApiModelProperty(value = "组件路径")
    private String component;
    @ApiModelProperty(value = "状态")
    private Boolean isEnable;
    @ApiModelProperty(value = "菜单图标")
    private String icon;

}
