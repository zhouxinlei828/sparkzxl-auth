package com.github.sparkzxl.system.admin.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 岗位信息
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_station")
@ApiModel(value = "Station对象", description = "岗位信息")
public class Station implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("组织ID")
    @TableField("org_id")
    private Long orgId;

    @ApiModelProperty("状态 0禁用,1启用")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("删除状态（0：未删除，1：删除）")
    @TableField("is_delete")
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty("描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty("创建人id")
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新人id")
    @TableField("modify_user")
    private Long modifyUser;

    @ApiModelProperty("更新时间")
    @TableField("modify_time")
    private LocalDateTime modifyTime;

    @ApiModelProperty("租户id")
    @TableField(value = "tenant_id", fill = FieldFill.INSERT)
    private String tenantId;


}
