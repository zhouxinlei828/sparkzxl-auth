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
import java.time.LocalDateTime;

/**
 * description: 角色组织关系
 *
 * @author charles.zhou
 * @date   2020-07-19 20:53:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("auth_role_org")
@ApiModel(value = "CAuthRoleOrg对象", description = "角色组织关系")
public class RoleOrg implements Serializable {

    private static final long serialVersionUID = -7571401319154552550L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty(value = "部门ID")
    @TableField("org_id")
    private Long orgId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("create_user")
    private Long createUser;

    @ApiModelProperty(value = "租户池code")
    @TableField("tenant_code")
    private String tenantId;


}
