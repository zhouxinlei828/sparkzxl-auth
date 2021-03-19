package com.github.sparkzxl.auth.interfaces.dto.manager;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * description: 领域管理员查询对象
 *
 * @author charles.zhou
 * @date 2021-03-14 13:28:08
 */
@Data
@ApiModel(value = "领域管理员查询对象")
public class RealmManagerQueryDTO {

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "手机")
    private String mobile;

}
