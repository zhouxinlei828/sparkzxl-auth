package com.github.sparkzxl.auth.domain.model.aggregates;

import lombok.Data;

/**
 * description: 角色基本信息
 *
 * @author charles.zhou
 * @date 2020-08-17 11:39:25
 */
@Data
public class RoleBasicInfo {

    private Long id;
    private String code;
    private String name;

}
