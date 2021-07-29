package com.github.sparkzxl.file.interfaces.dto;

import com.github.sparkzxl.database.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 文件分页查询入参
 *
 * @author charles.zhou
 * @date   2021-01-03 14:32:09
 */
@ApiModel("文件分页查询入参")
@EqualsAndHashCode(callSuper = true)
@Data
public class FileMaterialPageDTO extends PageDTO {

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "媒体类型")
    private String contentType;

}
