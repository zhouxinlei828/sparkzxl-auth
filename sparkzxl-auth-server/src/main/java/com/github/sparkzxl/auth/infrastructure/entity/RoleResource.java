package com.github.sparkzxl.auth.infrastructure.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * description: 角色路径
 *
 * @author charles.zhou
 * @date   2020-08-02 22:02:47
 */
@Data
public class RoleResource implements Serializable {

    private static final long serialVersionUID = -7571401319154555650L;

    private String roleCode;

    private String path;

}
