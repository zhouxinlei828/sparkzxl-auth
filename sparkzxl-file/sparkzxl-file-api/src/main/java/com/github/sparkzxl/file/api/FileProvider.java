package com.github.sparkzxl.file.api;

import com.github.sparkzxl.file.dto.FileDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * description: 文件Provider
 *
 * @author charles.zhou
 * @since 2020-05-24 12:27:04
 */
public interface FileProvider {

    /**
     * 转换pdf文件
     *
     * @param fileDTO 文件入参
     * @return FileDTO
     */
    @PostMapping("/pdf")
    FileDTO getPdf(@RequestBody FileDTO fileDTO);

}
