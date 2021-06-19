package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.database.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * description：登录日志
 *
 * @author charles.zhou
 * @date 2020/6/17 0017
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("auth_login_log")
@ApiModel(value = "LoginLog", description = "登录日志")
public class LoginLog extends SuperEntity<Long> {

    private static final long serialVersionUID = -4832393724255136497L;

    @ApiModelProperty(value = "登录IP")
    @Length(max = 50, message = "登录IP长度不能超过50")
    @TableField(value = "request_ip", condition = LIKE)
    private String requestIp;

    @ApiModelProperty(value = "登录人ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "登录人姓名")
    @Length(max = 50, message = "登录人姓名长度不能超过50")
    @TableField(value = "user_name", condition = LIKE)
    private String userName;

    @ApiModelProperty(value = "登录人账号")
    @Length(max = 30, message = "登录人账号长度不能超过30")
    @TableField(value = "account", condition = LIKE)
    private String account;

    @ApiModelProperty(value = "登录描述")
    @Length(max = 255, message = "登录描述长度不能超过255")
    @TableField(value = "description", condition = LIKE)
    private String description;

    @ApiModelProperty(value = "登录时间")
    @TableField(value = "login_date",fill = FieldFill.INSERT)
    private LocalDateTime loginDate;

    @ApiModelProperty(value = "浏览器请求头")
    @Length(max = 500, message = "浏览器请求头长度不能超过500")
    @TableField(value = "ua", condition = LIKE)
    private String ua;

    @ApiModelProperty(value = "浏览器名称")
    @Length(max = 255, message = "浏览器名称长度不能超过255")
    @TableField(value = "browser", condition = LIKE)
    private String browser;

    @ApiModelProperty(value = "浏览器版本")
    @Length(max = 255, message = "浏览器版本长度不能超过255")
    @TableField(value = "browser_version", condition = LIKE)
    private String browserVersion;

    @ApiModelProperty(value = "操作系统")
    @Length(max = 255, message = "操作系统长度不能超过255")
    @TableField(value = "operating_system", condition = LIKE)
    private String operatingSystem;
    @ApiModelProperty(value = "登录地点")
    @Length(max = 50, message = "登录地点长度不能超过50")
    @TableField(value = "location", condition = LIKE)
    private String location;

    @ApiModelProperty(value = "租户池code")
    @TableField("tenant_code")
    private String tenantId;


    @Builder
    public LoginLog(Long id, LocalDateTime createTime, Long createUser,
                    String requestIp, Long userId, String userName, String account, String description,
                    LocalDateTime loginDate, String ua, String browser, String browserVersion, String operatingSystem,
                    String location, String tenantId) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.requestIp = requestIp;
        this.userId = userId;
        this.userName = userName;
        this.account = account;
        this.description = description;
        this.loginDate = loginDate;
        this.ua = ua;
        this.browser = browser;
        this.browserVersion = browserVersion;
        this.operatingSystem = operatingSystem;
        this.location = location;
        this.tenantId = tenantId;
    }

}
