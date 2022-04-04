package com.github.sparkzxl.mock;

import com.github.sparkzxl.auth.api.IDictionaryProvider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * description: 用户client
 *
 * @author zhoux
 * @date 2021-08-22 12:07:48
 */
@FeignClient(contextId = "dictionaryProvider", value = "sparkzxl-auth-server", path = "/base/dictionaryItem", fallback = DictionaryFallback.class)
@Component
public interface DictionaryProvider extends IDictionaryProvider {
}
