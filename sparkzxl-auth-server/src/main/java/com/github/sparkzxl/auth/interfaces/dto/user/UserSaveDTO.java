package com.github.sparkzxl.auth.interfaces.dto.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUserAttribute;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.database.entity.RemoteData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * description: 用户信息
 *
 * @author charles.zhou
 * @date 2020-05-24 12:24:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AuthUserSaveDTO保存对象", description = "AuthUserSaveDTO保存对象")
public class UserSaveDTO {

    @ApiModelProperty(value = "账号")
    @NotEmpty(message = "账号不能为空")
    private String account;

    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "组织ID")
    private RemoteData<Long, CoreOrg> org;

    @ApiModelProperty(value = "岗位ID")
    @TableField("station_id")
    private RemoteData<Long, CoreStation> station;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "民族")
    private RemoteData<String, String> nation;

    @ApiModelProperty(value = "学历")
    private RemoteData<String, String> education;

    @ApiModelProperty(value = "职位状态")
    private RemoteData<String, String> positionStatus;

    @ApiModelProperty(value = "工作描述比如：市长、管理员、局长等等   用于登陆展示")
    private String workDescribe;

    @ApiModelProperty(value = "状态 1启用 0禁用")
    private Boolean status;

    @ApiModelProperty(value = "用户自定义属性")
    private List<AuthUserAttribute> userAttributes;


}
