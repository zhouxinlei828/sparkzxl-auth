package com.github.sparkzxl.oauth.interfaces.client;

import com.github.sparkzxl.auth.api.IAuthUserProvider;
import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.auth.api.dto.UserDetail;
import com.github.sparkzxl.auth.api.dto.UserDetailInfo;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.feign.annoation.RetryableMethod;
import com.github.sparkzxl.feign.resilience4j.FeignDecoratorBuilderInterceptor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * description: 用户client
 *
 * @author zhoux
 * @date 2021-08-22 12:07:48
 */
@FeignClient(contextId = "userInfoProvider", value = "sparkzxl-auth-server", path = "/user", configuration = UserInfoProvider.UserInfoConfig.class)
@Component
@RetryableMethod
public interface UserInfoProvider extends IAuthUserProvider {

    class UserInfoConfig {

        @Bean
        public FeignDecoratorBuilderInterceptor userInfoInterceptor() {
            return builder -> builder.withFallbackFactory(UserInfoFallBack::new);
        }

        @Slf4j
        @NoArgsConstructor
        @Getter
        public static class UserInfoFallBack implements UserInfoProvider {

            private Exception cause;

            public UserInfoFallBack(Exception cause) {
                this.cause = cause;
            }

            @Override
            public UserDetailInfo getUserDetailInfo(String username) {
                return null;
            }

            @Override
            public AuthUserInfo<UserDetail> getAuthUserInfo(String username) {
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
    }
}
