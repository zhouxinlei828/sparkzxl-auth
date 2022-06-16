package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.github.sparkzxl.constant.EntityConstant;
import com.github.sparkzxl.entity.data.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description: 资源
 *
 * @author charles.zhou
 * @since 2020-06-07 13:24:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("auth_resource")
@ApiModel(value = "CAuthResourceDO对象", description = "资源")
public class AuthResource implements Serializable {

    private static final long serialVersionUID = -6295580114270886981L;

    @TableId(value = EntityConstant.COLUMN_ID, type = IdType.INPUT)
    protected Long id;

    @ApiModelProperty(value = "编码规则： 链接： 数据列： 按钮：")
    @TableField(value = "code", condition = SqlCondition.LIKE)
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField(value = "name", condition = SqlCondition.LIKE)
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

    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected Long createUser;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected Long updateUser;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

}
