package com.github.sparkzxl.auth.domain.model.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * description：
 *
 * @author charles.zhou
 * @date 2020/6/16 0016
 */
@Data
@ApiModel("角色菜单资源")
public class RoleResourceDTO {

    @ApiModelProperty("角色id")
    private Long id;

    @ApiModelProperty("菜单列表")
    private List<Long> authMenus;

    @ApiModelProperty("资源列表")
    private List<Long> authResources;

}
