package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.entity.data.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 角色的资源
 *
 * @author charles.zhou
 * @date   2020-07-19 20:56:02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("auth_role_authority")
@ApiModel(value = "CAuthRoleAuthority对象", description = "角色的资源")
public class RoleAuthority extends SuperEntity<Long> {

    private static final long serialVersionUID = -6764899985506548603L;

    @ApiModelProperty(value = "资源id")
    @TableField("authority_id")
    private Long authorityId;

    @ApiModelProperty(value = "权限类型#AuthorizeType{MENU:菜单;RESOURCE:资源;}")
    @TableField("authority_type")
    private String authorityType;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Long roleId;

}
