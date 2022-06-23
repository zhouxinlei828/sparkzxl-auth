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
 * @since 2020-07-28 19:35:34
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_area")
@ApiModel(value = "Area对象", description = "地区表")
public class SysArea implements Serializable {

    private static final long serialVersionUID = 2594868912590581188L;

    @TableId(value = EntityConstant.COLUMN_ID, type = IdType.INPUT)
    protected Long id;

    @TableField("parent_id")
    protected Long parentId;

    @ApiModelProperty(value = "行政单位类别 省 市 区/县 街道/乡镇")
    @TableField(value = "level")
    protected String level;

    @ApiModelProperty(value = "编码")
    @TableField(value = "code")
    private Long code;

    @ApiModelProperty(value = "行政单位名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "经度，纬度")
    @TableField("center")
    private String center;

    @TableField("sort_number")
    protected Integer sortNumber;

    @TableField(value = "create_user", fill = FieldFill.INSERT)
    protected Long createUser;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE)
    protected Long updateUser;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

}
