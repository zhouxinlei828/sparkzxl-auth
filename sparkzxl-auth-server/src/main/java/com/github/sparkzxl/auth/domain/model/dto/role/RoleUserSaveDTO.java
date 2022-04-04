package com.github.sparkzxl.auth.domain.model.dto.role;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * description：
 *
 * @author charles.zhou
 * @date 2020/6/16 0016
 */
@Data
public class RoleUserSaveDTO {

    @NotNull(message = "角色id不能为空")
    private Long roleId;

    private List<Long> userIds;

}
