package com.github.sparkzxl.auth.interfaces.dto.role;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRoleAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * description：角色更新对象
 *
 * @author charles.zhou
 * @date 2020/6/16 0016
 */
@Data
@ApiModel("角色更新对象")
public class RoleUpdateDTO {

    @ApiModelProperty(value = "id")
    @NotNull(message = "id不能为空")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "角色自定义属性")
    @TableField(exist = false)
    private List<AuthRoleAttribute> roleAttributes;
}
