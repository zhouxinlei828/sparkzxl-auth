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
 * 应用
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_application")
@ApiModel(value = "Application对象", description = "应用")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("应用名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("应用访问地址")
    @TableField("website")
    private String website;

    @ApiModelProperty("应用图标地址")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("类型 SERVER:服务应用;APP:手机应用;PC:PC网页应用;WAP:手机网页应用")
    @TableField("app_type")
    private String appType;

    @ApiModelProperty("应用简介")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty("健康检查路径")
    @TableField("health_check")
    private String healthCheck;

    @ApiModelProperty("应用健康状况：0健康，1死亡")
    @TableField("health_status")
    private String healthStatus;

    @ApiModelProperty("客户端id")
    @TableField("client_id")
    private String clientId;

    @ApiModelProperty("客户端原始密钥")
    @TableField("original_client_secret")
    private String originalClientSecret;

    @ApiModelProperty("状态 0禁用,1启用")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("删除状态（0：未删除，1：删除）")
    @TableField("is_delete")
    @TableLogic
    private Boolean isDelete;

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
