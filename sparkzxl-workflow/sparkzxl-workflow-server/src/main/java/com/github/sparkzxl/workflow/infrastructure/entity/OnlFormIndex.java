package com.github.sparkzxl.workflow.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.entity.data.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * online表单索引
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("onl_form_index")
@ApiModel(value = "OnlFormIndex对象", description = "online表单索引")
public class OnlFormIndex extends Entity<Long> {

    private static final long serialVersionUID = 6389605570126539437L;

    @ApiModelProperty(value = "主表id")
    @TableField("form_table_id")
    private String formTableId;

    @ApiModelProperty(value = "索引名称")
    @TableField("index_name")
    private String indexName;

    @ApiModelProperty(value = "索引栏位")
    @TableField("index_field")
    private String indexField;

    @ApiModelProperty(value = "索引类型")
    @TableField("index_type")
    private String indexType;

    @ApiModelProperty(value = "是否同步数据库 n未同步 y已同步")
    @TableField("db_sync")
    private String dbSync;

    @ApiModelProperty(value = "是否删除 0未删除 1删除")
    @TableField("del_flag")
    private Integer delFlag;

}
