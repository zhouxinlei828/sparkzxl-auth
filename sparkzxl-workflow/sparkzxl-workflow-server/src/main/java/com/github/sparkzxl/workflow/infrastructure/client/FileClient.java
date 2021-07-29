package com.github.sparkzxl.workflow.infrastructure.client;

import com.github.sparkzxl.file.api.FileApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "sparkzxl-file-server", fallbackFactory = FileFallback.class)
@Component
public interface FileClient extends FileApi {
}
