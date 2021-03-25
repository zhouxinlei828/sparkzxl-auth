package com.github.sparkzxl.workflow.infrastructure.entity;

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
 * description: 流程表单
 *
 * @author charles.zhou
 * @date 2021-03-25 18:00:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ext_process_form")
@ApiModel(value = "ExtProcessForm对象", description = "流程表单")
public class ExtProcessForm implements Serializable {

    private static final long serialVersionUID = 6496068983689961489L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "模板名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "表单类型")
    @TableField("form_type")
    private String formType;

    @ApiModelProperty(value = "模板json")
    @TableField("form_json")
    private String formJson;

    @ApiModelProperty(value = "0:草稿，1:上架")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
