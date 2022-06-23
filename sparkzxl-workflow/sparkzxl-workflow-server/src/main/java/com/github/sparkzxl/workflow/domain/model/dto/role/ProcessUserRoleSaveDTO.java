package com.github.sparkzxl.workflow.domain.model.dto.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * description: 流程角色用户保存DTO
 *
 * @author charles.zhou
 * @since 2021-05-17 09:39:35
 */
@Data
@ApiModel("流程角色用户保存DTO")
public class ProcessUserRoleSaveDTO {

    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Long roleId;

    @ApiModelProperty(value = "用户id列表")
    private List<Long> userIds;

}
