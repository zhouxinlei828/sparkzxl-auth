package com.github.sparkzxl.auth.interfaces.dto.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 资源保存对象
 *
 * @author charles.zhou
 * @date 2020-06-07 13:24:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "资源保存对象", description = "资源保存对象")
public class ResourceSaveDTO {

    private static final long serialVersionUID = -6295580114270886981L;

    @ApiModelProperty(value = "编码规则： 链接： 数据列： 按钮：")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "请求路径")
    private String requestUrl;
}
