package com.github.sparkzxl.auth.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * description: 用户详情信息
 *
 * @author zhouxinlei
 * @since 2022-02-11 17:07:30
 */
@Data
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 5354547474711499362L;

    private OrgBasicInfo org;

    private StationBasicInfo station;

    private String mobile;

    private String email;

    private String education;

    private String positionStatus;
}
