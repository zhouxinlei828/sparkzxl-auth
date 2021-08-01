package com.github.sparkzxl.hibernate.template;

import com.alibaba.druid.sql.ast.SQLDataType;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import lombok.Data;

/**
 * description: 条件构造
 *
 * @author zhouxinlei
 * @date 2021-08-01 21:00:04
 */
@Data
public class Condition {
    private String key;
    private String val;
    private SQLDataType type;
    private SqlKeyword keyword;
}
