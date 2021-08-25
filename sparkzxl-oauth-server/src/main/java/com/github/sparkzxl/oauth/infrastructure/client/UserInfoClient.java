package com.github.sparkzxl.oauth.infrastructure.client;

import com.github.sparkzxl.auth.api.IAuthUserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * description: 用户client
 *
 * @author zhoux
 * @date 2021-08-22 12:07:48
 */
@FeignClient(value = "sparkzxl-auth-server", path = "/user", fallback = UserInfoFallback.class)
@Component
public interface UserInfoClient extends IAuthUserApi {
}
