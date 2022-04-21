package com.github.sparkzxl.workflow.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.sparkzxl.constant.EntityConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * description: 流程状态记录（新加表）
 *
 * @author charles.zhou
 * @date 2020-07-16 18:39:32
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

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;
    @ApiModelProperty(value = "业务主键")
    @TableField("business_id")
    private String businessId;
    @ApiModelProperty(value = "流程id")
    @TableField("process_instance_id")
    private String processInstanceId;
    @ApiModelProperty(value = "业务流程名称")
    @TableField("process_name")
    private String processName;
    @ApiModelProperty(value = "流程状态")
    @TableField("status")
    private String status;

}
