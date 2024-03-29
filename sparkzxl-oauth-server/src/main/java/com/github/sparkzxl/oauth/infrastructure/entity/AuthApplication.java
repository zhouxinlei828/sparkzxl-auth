package com.github.sparkzxl.oauth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.github.sparkzxl.entity.data.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description: 应用信息
 *
 * @author charles.zhou
 * @since 2021-02-20 09:42:43
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("auth_application")
@ApiModel(value = "应用信息", description = "")
public class AuthApplication implements Serializable {

    private static final long serialVersionUID = -5517070329109683485L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "应用名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "应用访问地址")
    @TableField("website")
    private String website;

    @ApiModelProperty(value = "应用图标地址")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "类型 SERVER:服务应用;APP:手机应用;PC:PC网页应用;WAP:手机网页应用")
    @TableField("app_type")
    private String appType;

    @ApiModelProperty(value = "类型 SERVER:服务应用;APP:手机应用;PC:PC网页应用;WAP:手机网页应用")
    @TableField(exist = false)
    private String appTypeName;

    @ApiModelProperty(value = "应用简介")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "健康检查路径")
    @TableField("health_check")
    private String healthCheck;

    @ApiModelProperty(value = "应用健康状况")
    @TableField("health_status")
    private Boolean healthStatus;

    @ApiModelProperty(value = "客户端id")
    @TableField("client_id")
    private String clientId;

    @ApiModelProperty("客户端原始密钥")
    @TableField("original_client_secret")
    private String originalClientSecret;

    @ApiModelProperty(value = "应用客户端")
    @TableField(exist = false)
    private OauthClientDetails oauthClientDetail;

    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected Long createUser;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected Long updateUser;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

}
