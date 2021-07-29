package com.github.sparkzxl.file.infrastructure.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;

/**
 * description: 上传结果
 *
 * @author charles.zhou
 * @date 2020-05-24 12:38:34
 */
@Data
@ToString
public class UploadResult {

    private String filename;

    private String filePath;

    private String key;

    private String thumbPath;

    private String suffix;

    private MediaType mediaType;

    private Long size;

    private Integer width;

    private Integer height;


    public FileMaterial builder(UploadResult uploadResult) {
        FileMaterial fileMaterialDO = new FileMaterial();
        fileMaterialDO.setFileName(uploadResult.getFilename());
        fileMaterialDO.setSuffix(uploadResult.getSuffix());
        fileMaterialDO.setFilePath(uploadResult.getFilePath());
        fileMaterialDO.setSize((double) uploadResult.getSize());
        fileMaterialDO.setContentType(uploadResult.getMediaType().getType());
        fileMaterialDO.setUid(String.valueOf(System.currentTimeMillis()));
        fileMaterialDO.setCreateTime(LocalDateTime.now());
        return fileMaterialDO;
    }

}
