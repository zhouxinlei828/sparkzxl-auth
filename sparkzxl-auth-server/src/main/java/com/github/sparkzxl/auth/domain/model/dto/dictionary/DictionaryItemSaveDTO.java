package com.github.sparkzxl.auth.domain.model.dto.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 字典项保存入参
 *
 * @author charles.zhou
 * @since 2020-12-02 10:14:51
 */
@Data
@ApiModel("字典项保存入参")
public class DictionaryItemSaveDTO {

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
    private Integer sortNumber;
}
