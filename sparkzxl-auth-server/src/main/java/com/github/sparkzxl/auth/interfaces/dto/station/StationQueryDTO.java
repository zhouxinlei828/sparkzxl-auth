package com.github.sparkzxl.auth.interfaces.dto.station;

import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.entity.data.RemoteData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 岗位分页查询对象
 *
 * @author charles.zhou
 * @date 2020-07-27 19:49:46
 */
@Data
@ApiModel(value = "岗位分页查询对象")
public class StationQueryDTO {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "组织")
    private RemoteData<Long, CoreOrg> org;

}
