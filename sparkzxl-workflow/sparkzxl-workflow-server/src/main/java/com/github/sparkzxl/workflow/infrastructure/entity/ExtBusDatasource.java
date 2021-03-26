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
 * description: 业务数据源
 *
 * @author charles.zhou
 * @date 2021-03-26 11:11:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ext_bus_datasource")
@ApiModel(value = "ExtBusDatasource对象", description = "业务数据源")
public class ExtBusDatasource implements Serializable {

    private static final long serialVersionUID = 611474744936918735L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "数据源名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "数据源连接地址")
    @TableField("jdbc_url")
    private String jdbcUrl;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
