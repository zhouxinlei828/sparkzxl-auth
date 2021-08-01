package com.github.sparkzxl.auth.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * description: id序列生成
 *
 * @author charles.zhou
 * @date 2021-02-14 10:33:10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("segment_id")
@ApiModel(value = "IdSegment对象", description = "")
public class SegmentId implements Serializable {

    private static final long serialVersionUID = -912732215123787770L;

    @ApiModelProperty(value = "业务标记")
    @TableId(value = "business_tag", type = IdType.ASSIGN_ID)
    private String businessTag;

    @ApiModelProperty(value = "当前id值")
    @TableField("max_id")
    private Long maxId;

    @ApiModelProperty(value = "步长")
    @TableField("step")
    private Integer step;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
