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
 * online表单sql增强
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("onl_form_enhance_sql")
@ApiModel(value = "OnlFormEnhanceSql对象", description = "online表单sql增强")
public class OnlFormEnhanceSql extends Entity<Long> {

    private static final long serialVersionUID = 6463131044549569476L;

    @ApiModelProperty(value = "按钮编码")
    @TableField("button_code")
    private String buttonCode;

    @ApiModelProperty(value = "sql内容")
    @TableField("enhance_sql")
    private String enhanceSql;

    @ApiModelProperty(value = "sql名称")
    @TableField("enhance_sql_name")
    private String enhanceSqlName;

    @ApiModelProperty(value = "备注")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "表单id")
    @TableField("form_table_id")
    private String formTableId;

}
