package com.github.sparkzxl.workflow.infrastructure.client;

import com.github.sparkzxl.core.support.ExceptionAssert;
import com.github.sparkzxl.feign.exception.RemoteCallException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FileFallback implements FallbackFactory<FileClient> {
    @Override
    public FileClient create(Throwable throwable) {
        return fileDTO -> {
            // 部分接口需要捕获异常
            if (throwable instanceof RemoteCallException) {
                ExceptionAssert.failure(throwable.getMessage());
            }
            return null;
        };
    }
}
