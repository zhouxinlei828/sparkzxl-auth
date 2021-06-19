package com.github.sparkzxl.auth.domain.model.aggregates;

import lombok.Data;

/**
 * description: 用户统计
 *
 * @author zhouxinlei
 * @date 2021-03-20 12:05:14
 */
@Data
public class UserCount {

    private String tenantId;

    private Integer count;
}
