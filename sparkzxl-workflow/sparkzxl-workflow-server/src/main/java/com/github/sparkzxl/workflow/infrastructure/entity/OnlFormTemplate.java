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
 * 表单设计模板
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("onl_form_template")
@ApiModel(value = "OnlFormTemplate对象", description = "表单设计模板")
public class OnlFormTemplate extends Entity<Long> {

    private static final long serialVersionUID = 3191268418202630750L;

    @ApiModelProperty(value = "模板code")
    @TableField("template_code")
    private String templateCode;

    @ApiModelProperty(value = "模板名称")
    @TableField("template_name")
    private String templateName;

    @ApiModelProperty(value = "模板json")
    @TableField("template_json")
    private String templateJson;

}
