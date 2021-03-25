package com.github.sparkzxl.auth.interfaces.dto.role;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRoleAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * description：
 *
 * @author charles.zhou
 * @date 2020/6/16 0016
 */
@Data
@ApiModel("角色保存对象")
public class RoleSaveDTO {

    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "编码")
    @NotEmpty(message = "编码不能为空")
    private String code;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "是否内置角色")
    private Boolean readonly;

    @ApiModelProperty(value = "数据权限类型 {ALL:1,全部;THIS_LEVEL:2,本级;THIS_LEVEL_CHILDREN:3,本级以及子级;CUSTOMIZE:4,自定义;SELF:5,个人;} ")
    private String dsType;

    @ApiModelProperty(value = "角色自定义属性")
    @TableField(exist = false)
    private List<AuthRoleAttribute> roleAttributes;

}
