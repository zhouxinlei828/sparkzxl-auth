package com.github.sparkzxl.oauth.infrastructure.client;

import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.auth.api.dto.UserDetailInfo;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import org.springframework.stereotype.Component;

/**
 * description: 用户降级处理
 *
 * @author zhoux
 * @date 2021-08-22 12:12:28
 */
@Component
public class UserInfoFallback implements UserInfoClient {
    @Override
    public UserDetailInfo getUserDetailInfo(String username) {
        return null;
    }

    @Override
    public AuthUserInfo<Long> getAuthUserInfo(String username) {
        return null;
    }

    @Override
    public AuthUserBasicVO getUserByUserId(Long userId) {
        return null;
    }

    @Override
    public AuthUserBasicVO getUserByUsername(String username) {
        return null;
    }
}
