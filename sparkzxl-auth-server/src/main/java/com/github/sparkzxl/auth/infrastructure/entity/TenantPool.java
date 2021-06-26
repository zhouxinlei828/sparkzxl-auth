package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.entity.data.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 租户池信息
 *
 * @author charles.zhou
 * @date 2021-02-02 16:08:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tenant_pool")
@ApiModel(value = "租户池信息对象", description = "")
public class TenantPool extends Entity<Long> {

    private static final long serialVersionUID = -6955056237245642400L;

    @ApiModelProperty(value = "领域用户id")
    @TableField("tenant_user_id")
    private Long tenantUserId;

    @ApiModelProperty(value = "租户池编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "租户池名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "内置租户池")
    @TableField("readonly")
    private Boolean readonly;

    @ApiModelProperty(value = "logo地址")
    @TableField("logo")
    private String logo;

    @ApiModelProperty(value = "租户池简介")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "用户数")
    @TableField(exist = false)
    private int userCount;

}
