package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.database.entity.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 系统参数
 *
 * @author zhoux
 * @date 2021-06-13 12:05:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_parameter")
@ApiModel(value = "SysParameter对象", description = "系统参数")
public class SysParameter extends Entity<Long> {

    private static final long serialVersionUID = -7829767214126725276L;

    @ApiModelProperty(value = "参数code")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "参数名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "参数值")
    @TableField("value")
    private String value;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "状态0 禁用 1 启用")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "只读")
    @TableField("readonly")
    private Boolean readonly;

    @ApiModelProperty(value = "租户池code")
    @TableField("tenant_code")
    private String tenantId;


}
