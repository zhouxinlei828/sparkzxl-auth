package com.github.sparkzxl.hibernate.template;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * description: 动态字段实体类
 *
 * @author zhouxinlei
 * @since 2021-08-02 12:12:26
 */
@Data
@Accessors(chain = true)
public class DynamicColumn {

    private String key;

    private String type;

    private String alias;

    private Object val;
}
