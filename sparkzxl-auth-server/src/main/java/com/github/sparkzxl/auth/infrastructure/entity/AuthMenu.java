package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.database.entity.TreeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * description: 菜单
 *
 * @author charles.zhou
 * @date 2020-06-07 13:24:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("auth_menu")
@ApiModel(value = "CAuthMenuDO对象", description = "菜单")
public class AuthMenu extends TreeEntity<AuthMenu, Long> {

    private static final long serialVersionUID = -5664444970808472308L;

    @ApiModelProperty(value = "菜单是否可见")
    @TableField("hidden")
    private boolean hidden;

    @ApiModelProperty(value = "自动进行重定向")
    @TableField("redirect")
    private String redirect;

    @ApiModelProperty(value = "菜单缓存")
    @TableField("no_keep_alive")
    private boolean noKeepAlive;

    @ApiModelProperty(value = "菜单图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "路由路径")
    @TableField("path")
    private String path;

    @ApiModelProperty(value = "组件名称")
    @TableField("component_name")
    private String componentName;

    @ApiModelProperty(value = "组件路径")
    @TableField("component")
    private String component;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "状态")
    @TableField("is_enable")
    private Boolean isEnable;

    @ApiModelProperty(value = "租户池code")
    @TableField("tenant_code")
    private String tenantId;

    @ApiModelProperty(value = "资源列表")
    @TableField(exist = false)
    private List<AuthResource> resourceList;

}
