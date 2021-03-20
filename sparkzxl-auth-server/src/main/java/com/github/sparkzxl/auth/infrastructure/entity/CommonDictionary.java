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
 * description: 字典类型
 *
 * @author charles.zhou
 * @date   2020-07-28 19:38:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("common_dictionary")
@ApiModel(value = "CCommonDictionary对象", description = "字典类型")
public class CommonDictionary extends Entity<Long> {

    private static final long serialVersionUID = -4224343605781132375L;

    @ApiModelProperty(value = "编码一颗树仅仅有一个统一的编码")
    @TableField(value = "type_", condition = LIKE_RIGHT)
    private String type;

    @ApiModelProperty(value = "名称")
    @TableField(value = "name",condition = LIKE_RIGHT)
    private String name;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "状态")
    @TableField("status_")
    private Boolean status;

    @ApiModelProperty(value = "领域池code")
    @TableField("realm_code")
    private String RealmCode;
}
