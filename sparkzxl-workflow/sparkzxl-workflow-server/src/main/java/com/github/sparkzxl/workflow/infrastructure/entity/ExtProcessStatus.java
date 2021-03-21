package com.github.sparkzxl.workflow.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.sparkzxl.database.constant.EntityConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * description: 流程状态记录（新加表）
 *
 * @author charles.zhou
 * @date   2020-07-16 18:39:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ext_process_status")
@ApiModel(value = "ActHiTaskStatus对象", description = "")
public class ExtProcessStatus {

    private static final long serialVersionUID = -8616461939623484360L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = EntityConstant.COLUMN_ID, type = IdType.INPUT)
    protected Long id;

    @ApiModelProperty(value = "业务主键")
    @TableField("business_id")
    private String businessId;

    @ApiModelProperty(value = "流程id")
    @TableField("process_instance_id")
    private String processInstanceId;

    @ApiModelProperty(value = "流程状态")
    @TableField("status")
    private String status;

    @TableField(value = EntityConstant.COLUMN_UPDATE_TIME, fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime updateTime;

    @TableField(value = EntityConstant.COLUMN_CREATE_TIME, fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected LocalDateTime createTime;

}
