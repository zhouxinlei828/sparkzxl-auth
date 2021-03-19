package com.github.sparkzxl.auth.interfaces.dto.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description: 字典更新入参
 *
 * @author charles.zhou
 * @date   2020-12-02 10:15:37
*/
@Data
@ApiModel("字典更新入参")
public class DictionaryUpdateDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "编码一颗树仅仅有一个统一的编码")
    private String type;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String describe;
}
