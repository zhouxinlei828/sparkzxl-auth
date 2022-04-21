package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.github.sparkzxl.entity.data.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE_RIGHT;

/**
 * description: 字典项
 *
 * @author charles.zhou
 * @date 2020-07-28 19:38:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dictionary_item")
@ApiModel(value = "DictionaryItem对象", description = "字典项")
public class DictionaryItem implements Serializable {

    private static final long serialVersionUID = -2612049198867936315L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "类型ID")
    @TableField("dictionary_id")
    private Long dictionaryId;

    @ApiModelProperty(value = "类型")
    @TableField(value = "dictionary_type", condition = LIKE_RIGHT)
    private String dictionaryType;

    @ApiModelProperty(value = "编码")
    @TableField(value = "code", condition = LIKE_RIGHT)
    private String code;

    @ApiModelProperty(value = "名称")
    @TableField(value = "name", condition = LIKE_RIGHT)
    private String name;

    @ApiModelProperty(value = "状态")
    @TableField("status_")
    private Boolean status;

    @ApiModelProperty(value = "描述")
    @TableField("describe_")
    private String describe;

    @ApiModelProperty(value = "排序")
    @TableField("sort_number")
    private Integer sortNumber;

    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected Long createUser;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected Long updateUser;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

}
