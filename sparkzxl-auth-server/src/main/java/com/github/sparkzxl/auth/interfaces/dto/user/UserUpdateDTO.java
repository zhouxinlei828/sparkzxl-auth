package com.github.sparkzxl.auth.interfaces.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * description: 用户信息
 *
 * @author charles.zhou
 * @date 2020-05-24 12:24:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AuthUserUpdateDTO更新对象", description = "AuthUserUpdateDTO更新对象")
public class UserUpdateDTO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "用户ID不能为空")
    private Long id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "组织ID")
    private Long orgId;

    @ApiModelProperty(value = "岗位ID")
    private Long stationId;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "民族")
    private String nation;

    @ApiModelProperty(value = "学历")
    private String education;

    @ApiModelProperty(value = "职位状态")
    private String positionStatus;

    @ApiModelProperty(value = "工作描述比如：市长、管理员、局长等等   用于登陆展示")
    private String workDescribe;

    @ApiModelProperty(value = "状态 1启用 0禁用")
    private Boolean status;

    @ApiModelProperty(value = "用户自定义属性")
    private Map<String, Object> userAttribute;

}
