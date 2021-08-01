package com.github.sparkzxl.auth.interfaces.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * description: 角色资源保存对象
 *
 * @author charles.zhou
 * @date 2020-07-30 20:45:20
 */
@Data
@ApiModel("角色资源保存对象")
public class RoleAuthoritySaveDTO {

    @NotNull(message = "角色不能为空")
    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("资源id列表")
    private Set<Long> resourceIds;

    @ApiModelProperty("菜单id列表")
    private Set<Long> menuIds;

}
