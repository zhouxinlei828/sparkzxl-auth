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
 * online表单js增强
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("onl_form_enhance_js")
@ApiModel(value = "OnlFormEnhanceJs对象", description = "online表单js增强")
public class OnlFormEnhanceJs extends Entity<Long> {

    private static final long serialVersionUID = -4631051928338320218L;

    @ApiModelProperty(value = "js增强内容")
    @TableField("cg_js")
    private String cgJs;

    @ApiModelProperty(value = "类型")
    @TableField("cg_js_type")
    private String cgJsType;

    @ApiModelProperty(value = "备注")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "表单id")
    @TableField("form_table_id")
    private String formTableId;

}
