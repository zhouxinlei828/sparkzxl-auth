package com.github.sparkzxl.auth.domain.model.dto.log;

import lombok.Data;

import java.util.Date;

/**
 * description: 登录日志查询对象
 *
 * @author charles.zhou
 * @date 2021-03-23 10:57:32
 */
@Data
public class LoginLogQueryDTO {

    private String account;

    private Date startTime;

    private Date endTime;
}
