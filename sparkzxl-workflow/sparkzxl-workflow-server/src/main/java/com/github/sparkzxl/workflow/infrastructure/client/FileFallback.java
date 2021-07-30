package com.github.sparkzxl.workflow.infrastructure.client;

import com.github.sparkzxl.core.support.ExceptionAssert;
import com.github.sparkzxl.feign.exception.RemoteCallException;
import com.github.sparkzxl.file.dto.FileDTO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FileFallback implements FallbackFactory<FileClient> {
    @Override
    public FileClient create(Throwable throwable) {
        return new FileClient() {
            @Override
            public FileDTO getPdf(FileDTO fileDTO) {
                // 部分接口需要捕获异常
                if (throwable instanceof RemoteCallException) {
                    ExceptionAssert.failure(throwable.getMessage());
                }
                return null;
            }

            @Override
            public FileDTO getHtml(FileDTO fileDTO) {
                return null;
            }
        };
    }
}
