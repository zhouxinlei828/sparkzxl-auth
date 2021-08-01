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
 * 表单设计
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("onl_form_design")
@ApiModel(value = "OnlFormDesign对象", description = "表单设计")
public class OnlFormDesign extends Entity<Long> {

    private static final long serialVersionUID = 3291713155540484738L;

    @ApiModelProperty(value = "表单code")
    @TableField("form_code")
    private String formCode;

    @ApiModelProperty(value = "表单名称")
    @TableField("form_name")
    private String formName;

    @ApiModelProperty(value = "表单json")
    @TableField("form_json")
    private String formJson;

}
