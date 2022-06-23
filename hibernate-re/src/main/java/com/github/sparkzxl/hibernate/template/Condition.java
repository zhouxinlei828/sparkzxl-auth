package com.github.sparkzxl.hibernate.template;

import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * description: 条件构造
 *
 * @author zhouxinlei
 * @since 2021-08-01 21:00:04
 */
@Data
@Accessors(chain = true)
public class Condition {
    private String key;
    private Object val;
    private String type;
    private SqlKeyword keyword;
}
