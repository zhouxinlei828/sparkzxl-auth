package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.database.entity.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE_RIGHT;

/**
 * description: 字典项
 *
 * @author charles.zhou
 * @date   2020-07-28 19:38:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dictionary_item")
@ApiModel(value = "DictionaryItem对象", description = "字典项")
public class DictionaryItem extends Entity<Long> {

    private static final long serialVersionUID = 8505347163173853317L;

    @ApiModelProperty(value = "类型ID")
    @TableField("dictionary_id")
    private Long dictionaryId;

    @ApiModelProperty(value = "类型")
    @TableField(value = "dictionary_type",condition = LIKE_RIGHT)
    private String dictionaryType;

    @ApiModelProperty(value = "编码")
    @TableField(value = "code",condition = LIKE_RIGHT)
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField(value = "name",condition = LIKE_RIGHT)
    private String name;

    @ApiModelProperty(value = "状态")
    @TableField("status_")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "排序")
    @TableField("sort_value")
    private Integer sortValue;

    @ApiModelProperty(value = "领域池code")
    @TableField("realm_code")
    private String RealmCode;

}
