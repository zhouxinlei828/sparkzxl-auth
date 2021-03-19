package com.github.sparkzxl.auth.interfaces.dto.station;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.database.entity.RemoteData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * description: 岗位保存对象
 *
 * @author charles.zhou
 * @date   2020-07-27 19:49:46
 */
@Data
@ApiModel(value = "岗位保存对象")
public class StationSaveDTO {

    @ApiModelProperty(value = "名称")
    @NotNull(message = "岗位名称不能为空")
    private String name;

    @ApiModelProperty(value = "组织ID")
    @NotNull(message = "组织不能为空")
    private RemoteData<Long, CoreOrg> org;

    @ApiModelProperty(value = "状态")
    @NotNull(message = "状态不能为空")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

}
