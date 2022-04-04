package com.github.sparkzxl.oauth.interfaces.client;

import com.github.sparkzxl.auth.api.IAuthUserProvider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * description: 用户client
 *
 * @author zhoux
 * @date 2021-08-22 12:07:48
 */
@FeignClient(contextId = "userInfoProvider", value = "sparkzxl-auth-server", path = "/user", fallback = UserInfoFallback.class)
@Component
public interface UserInfoProvider extends IAuthUserProvider {
}
