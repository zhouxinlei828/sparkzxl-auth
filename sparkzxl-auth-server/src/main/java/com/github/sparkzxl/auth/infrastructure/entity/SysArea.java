package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.github.sparkzxl.constant.EntityConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description: 地区表
 *
 * @author charles.zhou
 * @date 2020-07-28 19:35:34
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_area")
@ApiModel(value = "Area对象", description = "地区表")
public class SysArea implements Serializable {

    private static final long serialVersionUID = 2594868912590581188L;
    @TableField("parent_code")
    protected Long parentCode;
    @ApiModelProperty(value = "行政单位类别 省 市 区/县 街道/乡镇")
    @TableField(value = "level")
    protected String level;
    @TableField("sort_number")
    protected Integer sortNumber;
    @TableField(value = EntityConstant.COLUMN_UPDATE_TIME, fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;
    @TableField(value = EntityConstant.COLUMN_CREATE_TIME, fill = FieldFill.INSERT)
    protected LocalDateTime createTime;
    @ApiModelProperty(value = "编码")
    @TableId(value = "code", type = IdType.INPUT)
    private Long code;
    @ApiModelProperty(value = "行政单位名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "城市编码")
    @TableField("city_code")
    private String cityCode;

    @ApiModelProperty(value = "经度，纬度")
    @TableField("center")
    private String center;

}
