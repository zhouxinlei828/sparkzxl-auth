package com.github.sparkzxl.system.admin.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 登录日志
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_login_log")
@ApiModel(value = "LoginLog对象", description = "登录日志")
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("登录IP")
    @TableField("request_ip")
    private String requestIp;

    @ApiModelProperty("登录人ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("登录人姓名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("登录人账号")
    @TableField("account")
    private String account;

    @ApiModelProperty("登录描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("登录时间")
    @TableField("login_date")
    private LocalDateTime loginDate;

    @ApiModelProperty("浏览器请求头")
    @TableField("ua")
    private String ua;

    @ApiModelProperty("浏览器名称")
    @TableField("browser")
    private String browser;

    @ApiModelProperty("浏览器版本")
    @TableField("browser_version")
    private String browserVersion;

    @ApiModelProperty("操作系统")
    @TableField("operating_system")
    private String operatingSystem;

    @ApiModelProperty("登录地点")
    @TableField("location")
    private String location;

    @ApiModelProperty("状态 0禁用,1启用")
    @TableField("status")
    private Boolean status;

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
