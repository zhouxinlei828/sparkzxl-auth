package com.github.sparkzxl.auth.infrastructure.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * description：登录日志统计
 *
 * @author charles.zhou
 * @since 2020/6/17 0017
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "LoginLog", description = "登录日志统计")
public class LoginLogCount {

    @ApiModelProperty(value = "登录时间")
    private LocalDate loginDate;

    @ApiModelProperty(value = "浏览器名称")
    private String browser;

    @ApiModelProperty(value = "操作系统")
    private String operatingSystem;

    @ApiModelProperty(value = "数量")
    private Long count;

}
