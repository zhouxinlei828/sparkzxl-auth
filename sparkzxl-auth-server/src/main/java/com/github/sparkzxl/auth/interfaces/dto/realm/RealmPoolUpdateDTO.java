package com.github.sparkzxl.auth.interfaces.dto.realm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * description: 领域池更新对象
 *
 * @author charles.zhou
 * @date   2020-07-27 19:49:46
 */
@Data
@ApiModel(value = "领域池更新对象")
public class RealmPoolUpdateDTO {

    @ApiModelProperty(value = "领域池id")
    @NotNull(message = "领域池id不能为空")
    private Long id;

    @ApiModelProperty(value = "领域池名称")
    @NotEmpty(message = "领域池名称不能为空")
    private String name;

    @ApiModelProperty(value = "logo地址")
    private String logo;

    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "领域池简介")
    private String describe;

}
