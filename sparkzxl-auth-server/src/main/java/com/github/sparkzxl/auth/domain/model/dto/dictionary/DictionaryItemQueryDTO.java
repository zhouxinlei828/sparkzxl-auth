package com.github.sparkzxl.auth.domain.model.dto.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 字典项查询入参
 *
 * @author charles.zhou
 * @since 2020-12-02 10:13:57
 */
@Data
@ApiModel("字典项查询入参")
public class DictionaryItemQueryDTO {

    @ApiModelProperty(value = "字典ID")
    private Long dictionaryId;

    @ApiModelProperty(value = "字典项类型")
    private String dictionaryType;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;
}
