package com.github.sparkzxl.system.admin.api.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统日志DTO对象
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OperateLogDTO", description = "系统日志DTO对象")
public class OperateLogDTO implements Serializable {


    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键", example = "1")
    private Long id;

    @ApiModelProperty(value = "操作IP")
    private String requestIp;

    @ApiModelProperty(value = "日志类型OPT:操作类型;EX:异常类型")
    private String type;

    @ApiModelProperty(value = "操作人")
    private String userName;

    @ApiModelProperty(value = "操作描述")
    private String description;

    @ApiModelProperty(value = "类路径")
    private String classPath;

    @ApiModelProperty(value = "请求方法")
    private String actionMethod;

    @ApiModelProperty(value = "请求地址")
    private String requestUri;

    @ApiModelProperty(value = "请求类型 POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}")
    private String httpMethod;

    @ApiModelProperty(value = "请求参数")
    private String params;

    @ApiModelProperty(value = "返回值")
    private String result;

    @ApiModelProperty(value = "异常详情信息")
    private String exDesc;

    @ApiModelProperty(value = "异常描述")
    private String exDetail;

    @ApiModelProperty(value = "开始时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "完成时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime finishTime;

    @ApiModelProperty(value = "消耗时间", example = "1")
    private Long consumingTime;

    @ApiModelProperty(value = "浏览器")
    private String ua;

    @ApiModelProperty(value = "状态 0禁用,1启用")
    private Boolean status;

    @ApiModelProperty(value = "更新人id", example = "1")
    private Long modifyUser;

    @ApiModelProperty(value = "更新时间")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime modifyTime;




}
