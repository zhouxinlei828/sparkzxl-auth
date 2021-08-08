package com.github.sparkzxl.auth.interfaces.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * description: 组织用户保存DTO
 *
 * @author zhouxinlei
 * @date 2021-08-08 17:14:35
 */
@Data
@ApiModel(value = "OrgUserSaveDTO", description = "组织用户保存DTO")
public class OrgUserSaveDTO {

    @ApiModelProperty("组织id")
    @NotNull(message = "组织id不能为空")
    private Long orgId;

    @ApiModelProperty("用户id列表")
    private List<Long> userIds;
}
