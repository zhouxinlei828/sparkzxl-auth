package com.github.sparkzxl.auth.domain.model.dto.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 字典保存入参
 *
 * @author charles.zhou
 * @since 2020-12-02 10:14:51
 */
@Data
@ApiModel("字典保存入参")
public class DictionarySaveDTO {

    @ApiModelProperty(value = "编码一颗树仅仅有一个统一的编码")
    private String type;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String describe;
}
