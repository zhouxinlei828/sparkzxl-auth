package com.github.sparkzxl.file.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * description: 文件入参
 *
 * @author charles.zhou
 * @date 2020-05-24 12:30:13
 */
@Data
public class FileDTO {

    private String filePath;

    private List<String> fileList;

    private LocalDateTime localDateTime;

}
