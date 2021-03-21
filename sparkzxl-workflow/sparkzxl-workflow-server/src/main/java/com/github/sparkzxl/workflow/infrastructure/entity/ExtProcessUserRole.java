package com.github.sparkzxl.workflow.infrastructure.entity;

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
 * description: 流程用户角色关系
 *
 * @author fzhouxinlei
 * @date   2021-01-08 16:47:56
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ext_process_user_role")
@ApiModel(value = "ExtProcessUserRole对象", description = "")
public class ExtProcessUserRole implements Serializable {

    private static final long serialVersionUID = -1692343320610914786L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Long userId;


}
