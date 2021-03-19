package com.github.sparkzxl.auth.domain.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * description: 角色资源显示层对象
 *
 * @author charles.zhou
 * @date   2020-12-01 14:21:38
*/
@Data
@ApiModel("角色资源显示层对象")
public class RoleResourceVO {

    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("菜单列表")
    private List<Long> authMenus;

    @ApiModelProperty("资源列表")
    private List<Long> authResources;
}
