package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.github.sparkzxl.entity.data.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description: 系统参数
 *
 * @author zhoux
 * @date 2021-06-13 12:05:27
 */
@Data
@TableName("sys_parameter")
@ApiModel(value = "SysParameter对象", description = "系统参数")
public class SysParameter implements Serializable {

    private static final long serialVersionUID = -7829767214126725276L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

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

    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected Long createUser;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected Long updateUser;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;
}
