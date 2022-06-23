package com.github.sparkzxl.auth.api.dto;

import com.github.sparkzxl.entity.core.AuthUserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 用户详细信息
 *
 * @author zhoux
 * @since 2021-08-22 12:41:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDetailInfo extends AuthUserInfo<UserDetail> {

    private String password;

}
