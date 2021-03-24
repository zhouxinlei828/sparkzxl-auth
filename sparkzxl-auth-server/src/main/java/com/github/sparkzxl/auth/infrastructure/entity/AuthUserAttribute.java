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
 * description: 用户属性
 *
 * @author charles.zhou
 * @date 2021-03-24 15:50:04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("auth_user_attribute")
@ApiModel(value = "AuthUserAttribute对象", description = "用户属性")
public class AuthUserAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "属性名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "属性key")
    @TableField("attribute_key")
    private String attributeKey;

    @ApiModelProperty(value = "属性值")
    @TableField("attribute_value")
    private String attributeValue;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "领域池code")
    @TableField("realm_code")
    private String realmCode;


}
