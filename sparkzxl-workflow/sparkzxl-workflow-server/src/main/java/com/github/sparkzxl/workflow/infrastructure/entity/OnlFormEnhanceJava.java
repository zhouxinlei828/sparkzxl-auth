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
 * online表单java增强
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("onl_form_enhance_java")
@ApiModel(value = "OnlFormEnhanceJava对象", description = "online表单java增强")
public class OnlFormEnhanceJava extends Entity<Long> {

    private static final long serialVersionUID = 1365716680824969272L;

    @ApiModelProperty(value = "按钮编码")
    @TableField("button_code")
    private String buttonCode;

    @ApiModelProperty(value = "类型")
    @TableField("cg_java_type")
    private String cgJavaType;

    @ApiModelProperty(value = "数值")
    @TableField("cg_java_value")
    private String cgJavaValue;

    @ApiModelProperty(value = "表单id")
    @TableField("form_table_id")
    private String formTableId;

    @ApiModelProperty(value = "生效状态")
    @TableField("active_status")
    private String activeStatus;

    @ApiModelProperty(value = "事件状态(end:结束，start:开始)")
    @TableField("event")
    private String event;

}
