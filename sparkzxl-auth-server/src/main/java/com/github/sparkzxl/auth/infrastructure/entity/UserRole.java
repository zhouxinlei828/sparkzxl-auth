package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * description: 角色分配 账号角色绑定
 *
 * @author charles.zhou
 * @date   2020-07-19 20:55:33
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("auth_user_role")
@ApiModel(value = "CAuthUserRole对象", description = "角色分配账号角色绑定")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 3730006313872866511L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "租户池code")
    @TableField("tenant_code")
    private String tenantId;

}
