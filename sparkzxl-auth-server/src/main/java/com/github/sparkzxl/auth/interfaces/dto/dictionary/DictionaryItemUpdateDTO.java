package com.github.sparkzxl.auth.interfaces.dto.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 字典项更新入参
 *
 * @author charles.zhou
 * @date 2020-12-02 10:15:37
 */
@Data
@ApiModel("字典项更新入参")
public class DictionaryItemUpdateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "类型ID")
    private Long dictionaryId;

    @ApiModelProperty(value = "类型")
    private String dictionaryType;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "状态")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    private String describe;

    @ApiModelProperty(value = "排序")
    private Integer sortValue;
}
