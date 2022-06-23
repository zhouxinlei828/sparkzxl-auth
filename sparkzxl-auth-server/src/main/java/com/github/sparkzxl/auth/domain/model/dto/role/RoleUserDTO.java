package com.github.sparkzxl.auth.domain.model.dto.role;

import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * description：
 *
 * @author charles.zhou
 * @since 2020/6/16 0016
 */
@Data
public class RoleUserDTO {

    @NotNull(message = "角色id")
    private Long id;

    @NotNull(message = "用户列表")
    private List<AuthUser> authUsers;

}
