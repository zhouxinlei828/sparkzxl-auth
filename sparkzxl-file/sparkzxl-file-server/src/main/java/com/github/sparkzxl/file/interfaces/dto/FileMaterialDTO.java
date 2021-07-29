package com.github.sparkzxl.file.interfaces.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * description：文件入参
 *
 * @author charles.zhou
 * @date 2020/6/16 0016
 */
@Data
public class FileMaterialDTO {

    @ApiModelProperty(value = "文件唯一标识")
    private String uid;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件后缀名")
    private String suffix;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @ApiModelProperty(value = "文件大小")
    private Double size;

    @ApiModelProperty(value = "媒体类型")
    private String contentType;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
