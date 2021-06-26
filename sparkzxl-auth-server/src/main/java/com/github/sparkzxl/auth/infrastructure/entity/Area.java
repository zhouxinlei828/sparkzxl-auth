package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.sparkzxl.entity.data.TreeEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 地区表
 *
 * @author charles.zhou
 * @date   2020-07-28 19:35:34
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("area")
@ApiModel(value = "Area对象", description = "地区表")
public class Area extends TreeEntity<Area, Long> {

    private static final long serialVersionUID = -5452812529610884314L;

    @ApiModelProperty(value = "编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "行政区级")
    @TableField("level")
    private String level;

    @ApiModelProperty(value = "租户池code")
    @TableField("tenant_code")
    private String tenantId;
}
