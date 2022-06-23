package com.github.sparkzxl.file.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * description：文件上传结果
 *
 * @author charles.zhou
 */
@Data
public class FileUploadModel implements Serializable {

    private static final long serialVersionUID = -3232121905073771525L;

    @ApiModelProperty(value = "文件唯一标识")
    private String uid;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件上传路径")
    private String fileUrl;

}
