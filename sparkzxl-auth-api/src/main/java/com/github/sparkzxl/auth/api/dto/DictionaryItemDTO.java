package com.github.sparkzxl.auth.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * description: 字典项DTO
 *
 * @author charles.zhou
 * @date 2021-02-02 11:34:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "DictionaryItemDTO对象", description = "字典项DTO")
public class DictionaryItemDTO implements Serializable {

    private static final long serialVersionUID = 1410040225232909395L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "类型ID")
    private Long dictionaryId;

    @ApiModelProperty(value = "类型")
    private String dictionaryType;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

}
