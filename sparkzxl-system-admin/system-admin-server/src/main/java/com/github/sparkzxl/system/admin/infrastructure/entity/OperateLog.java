package com.github.sparkzxl.system.admin.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统日志
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_operate_log")
@ApiModel(value = "OperateLog对象", description = "系统日志")
public class OperateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("操作IP")
    @TableField("request_ip")
    private String requestIp;

    @ApiModelProperty("日志类型OPT:操作类型;EX:异常类型")
    @TableField("type")
    private String type;

    @ApiModelProperty("操作人")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("操作描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("类路径")
    @TableField("class_path")
    private String classPath;

    @ApiModelProperty("请求方法")
    @TableField("action_method")
    private String actionMethod;

    @ApiModelProperty("请求地址")
    @TableField("request_uri")
    private String requestUri;

    @ApiModelProperty("请求类型 POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}")
    @TableField("http_method")
    private String httpMethod;

    @ApiModelProperty("请求参数")
    @TableField("params")
    private String params;

    @ApiModelProperty("返回值")
    @TableField("result")
    private String result;

    @ApiModelProperty("异常详情信息")
    @TableField("ex_desc")
    private String exDesc;

    @ApiModelProperty("异常描述")
    @TableField("ex_detail")
    private String exDetail;

    @ApiModelProperty("开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    @ApiModelProperty("完成时间")
    @TableField("finish_time")
    private LocalDateTime finishTime;

    @ApiModelProperty("消耗时间")
    @TableField("consuming_time")
    private Long consumingTime;

    @ApiModelProperty("浏览器")
    @TableField("ua")
    private String ua;

    @ApiModelProperty("状态 0禁用,1启用")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("创建人id")
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新人id")
    @TableField("modify_user")
    private Long modifyUser;

    @ApiModelProperty("更新时间")
    @TableField("modify_time")
    private LocalDateTime modifyTime;

    @ApiModelProperty("租户id")
    @TableField(value = "tenant_id", fill = FieldFill.INSERT)
    private String tenantId;


}
