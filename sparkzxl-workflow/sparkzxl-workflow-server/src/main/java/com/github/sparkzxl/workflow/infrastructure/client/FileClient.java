package com.github.sparkzxl.workflow.infrastructure.client;

import com.github.sparkzxl.file.api.FileProvider;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "sparkzxl-file-server", fallbackFactory = FileFallback.class)
@Component
public interface FileClient extends FileProvider {
}
