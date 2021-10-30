package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.sparkzxl.annotation.echo.EchoField;
import com.github.sparkzxl.auth.api.constant.enums.SexEnum;
import com.github.sparkzxl.auth.infrastructure.constant.BizConstant;
import com.github.sparkzxl.entity.data.Entity;
import com.github.sparkzxl.entity.data.RemoteData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Map;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE_RIGHT;
import static com.github.sparkzxl.auth.infrastructure.constant.EchoConstant.*;

/**
 * description: 用户信息
 *
 * @author charles.zhou
 * @date 2020-05-24 12:24:03
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "auth_user", autoResultMap = true)
@ApiModel(value = "AuthUser对象", description = "用户")
public class AuthUser extends Entity<Long> {

    private static final long serialVersionUID = -2722880054053904869L;

    @ApiModelProperty(value = "账号")
    @TableField("account")
    private String account;

    @ApiModelProperty(value = "姓名")
    @TableField(value = "name", condition = LIKE_RIGHT)
    private String name;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    @JsonIgnore
    private String password;

    @ApiModelProperty(value = "上级id")
    @TableField("superior_id")
    private Long superiorId;

    @ApiModelProperty(value = "组织ID")
    @TableField("org_id")
    @EchoField(api = ORG_ID_CLASS, beanClass = CoreOrg.class)
    private RemoteData<Long, CoreOrg> org;

    @ApiModelProperty(value = "岗位ID")
    @TableField("station_id")
    @EchoField(api = STATION_ID_CLASS, beanClass = CoreStation.class)
    private RemoteData<Long, CoreStation> station;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "手机")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private SexEnum sex;

    @ApiModelProperty(value = "头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty(value = "民族")
    @TableField("nation")
    @EchoField(api = DICTIONARY_ITEM_CLASS, method = FIND_NAME_BY_IDS, dictType = BizConstant.NATION)
    private RemoteData<String, String> nation;

    @ApiModelProperty(value = "学历")
    @TableField("education")
    @EchoField(api = DICTIONARY_ITEM_CLASS, method = FIND_NAME_BY_IDS, dictType = BizConstant.EDUCATION)
    private RemoteData<String, String> education;

    @ApiModelProperty(value = "职位状态")
    @TableField("position_status")
    @EchoField(api = DICTIONARY_ITEM_CLASS, method = FIND_NAME_BY_IDS, dictType = BizConstant.POSITION_STATUS)
    private RemoteData<String, String> positionStatus;

    @ApiModelProperty(value = "工作描述比如：市长、管理员、局长等等   用于登陆展示")
    @TableField("work_describe")
    private String workDescribe;

    @ApiModelProperty(value = "密码错误次数")
    @TableField("password_error_num")
    private Integer passwordErrorNum;

    @ApiModelProperty(value = "最后登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty(value = "状态 1启用 0禁用")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "扩展信息")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String, Object> extendInfo;
}
