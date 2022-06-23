package com.github.sparkzxl.auth.domain.model.dto.role;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * description：
 *
 * @author charles.zhou
 * @since 2020/6/16 0016
 */
@Data
public class RoleUserDeleteDTO {

    @NotNull(message = "角色id不能为空")
    private Long id;

    @NotNull(message = "至少选择一个用户")
    private Set<Serializable> userIds;

}
