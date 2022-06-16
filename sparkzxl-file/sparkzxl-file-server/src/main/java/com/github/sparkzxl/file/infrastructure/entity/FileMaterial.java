package com.github.sparkzxl.file.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description: 文件素材实体类
 *
 * @author charles.zhou
 * @since 2020-05-24 12:38:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("file_material")
@ApiModel(value = "文件素材对象", description = "文件素材表")
public class FileMaterial implements Serializable {

    private static final long serialVersionUID = 50906437333220541L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "文件名称")
    @TableField("file_name")
    private String fileName;

    @ApiModelProperty(value = "原始文件名")
    @TableField("original_file_name")
    private String originalFilename;

    @ApiModelProperty(value = "文件对象名称")
    @TableField("object_name")
    private String objectName;

    @ApiModelProperty(value = "文件摘要")
    @TableField("digest")
    private String digest;

    @ApiModelProperty(value = "文件类型")
    @TableField("file_type")
    private String fileType;

    @ApiModelProperty(value = "数据存储桶")
    @TableField("file_bucket")
    private String fileBucket;

    @ApiModelProperty(value = "文件后缀名")
    @TableField("suffix")
    private String suffix;

    @ApiModelProperty(value = "文件后缀名")
    @TableField("full_path")
    private String fullPath;

    @TableField("size")
    @ApiModelProperty(value = "文件大小")
    private Double size;

    @TableField("content_type")
    @ApiModelProperty(value = "媒体类型")
    private String contentType;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
