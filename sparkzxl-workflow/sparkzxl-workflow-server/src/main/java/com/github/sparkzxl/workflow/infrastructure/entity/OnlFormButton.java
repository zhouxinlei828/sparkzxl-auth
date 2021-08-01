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
 * online表单自定义按钮
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("onl_form_button")
@ApiModel(value = "OnlFormButton对象", description = "online表单自定义按钮")
public class OnlFormButton extends Entity<Long> {

    private static final long serialVersionUID = 7592554822446727700L;

    @ApiModelProperty(value = "按钮编码")
    @TableField("button_code")
    private String buttonCode;

    @ApiModelProperty(value = "按钮图标")
    @TableField("button_icon")
    private String buttonIcon;

    @ApiModelProperty(value = "按钮名称")
    @TableField("button_name")
    private String buttonName;

    @ApiModelProperty(value = "按钮状态")
    @TableField("button_status")
    private String buttonStatus;

    @ApiModelProperty(value = "按钮样式")
    @TableField("button_style")
    private String buttonStyle;

    @ApiModelProperty(value = "表达式")
    @TableField("exp")
    private String exp;

    @ApiModelProperty(value = "表单id")
    @TableField("form_table_id")
    private String formTableId;

    @ApiModelProperty(value = "按钮类型")
    @TableField("opt_type")
    private String optType;

    @ApiModelProperty(value = "排序")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty(value = "按钮位置1侧面 2底部")
    @TableField("opt_position")
    private String optPosition;

}
