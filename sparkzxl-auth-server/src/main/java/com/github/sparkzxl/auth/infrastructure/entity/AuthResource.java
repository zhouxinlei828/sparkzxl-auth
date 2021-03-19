package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.database.entity.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * description: 资源
 *
 * @author charles.zhou
 * @date 2020-06-07 13:24:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("auth_resource")
@ApiModel(value = "CAuthResourceDO对象", description = "资源")
public class AuthResource extends Entity<Long> {

    private static final long serialVersionUID = -6295580114270886981L;

    @ApiModelProperty(value = "编码规则： 链接： 数据列： 按钮：")
    @TableField(value = "code",condition = SqlCondition.LIKE)
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField(value = "name",condition = SqlCondition.LIKE)
    private String name;

    @ApiModelProperty(value = "菜单ID")
    @TableField("menu_id")
    private Long menuId;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "请求路径")
    @TableField("request_url")
    private String requestUrl;

    @ApiModelProperty(value = "领域池code")
    @TableField("tenant_code")
    private String tenantCode;
}
