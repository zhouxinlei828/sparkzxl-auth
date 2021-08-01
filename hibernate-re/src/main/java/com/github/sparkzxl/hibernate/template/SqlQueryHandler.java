package com.github.sparkzxl.hibernate.template;

import cn.hutool.core.map.MapUtil;
import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOperator;
import com.alibaba.druid.sql.ast.expr.SQLCharExpr;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLSelect;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * description: sql查询模板
 *
 * @author zhouxinlei
 * @date 2021-07-31 17:26:30
 */
public class SqlQueryHandler {

    public static String getSelectListSql(Map<String, String> columnFieldMap, String tableName, Map<String, String> conditionMap) {
        SQLSelect sqlSelect = new SQLSelect();
        SQLSelectQueryBlock queryBlock = new SQLSelectQueryBlock();
        if (MapUtil.isNotEmpty(columnFieldMap)) {
            for (String key : columnFieldMap.keySet()) {
                String val = columnFieldMap.get(key);
                SQLIdentifierExpr sqlIdentifierExpr = new SQLIdentifierExpr(key);
                if (StringUtils.isNotEmpty(val)) {
                    queryBlock.addSelectItem(sqlIdentifierExpr, val);
                } else {
                    queryBlock.addSelectItem(sqlIdentifierExpr);
                }
            }
        }
        queryBlock.setFrom(new SQLExprTableSource(new SQLIdentifierExpr(tableName)));
        if (MapUtil.isNotEmpty(conditionMap)) {
            for (String key : conditionMap.keySet()) {
                SQLBinaryOpExpr sqlBinaryOpExpr = new SQLBinaryOpExpr(new SQLIdentifierExpr(key), SQLBinaryOperator.Equality,
                        new SQLCharExpr(conditionMap.get(key)));
                queryBlock.addCondition(sqlBinaryOpExpr);
            }
        }
        sqlSelect.setQuery(queryBlock);
        return SQLUtils.toSQLString(sqlSelect, DbType.mysql);
    }

    public static void main(String[] args) {
        Map<String, String> whereCondition = Maps.newHashMap();
        whereCondition.put("user_id", "1");
        whereCondition.put("username", "admin");
        Map<String, String> columnFieldMap = Maps.newHashMap();
        columnFieldMap.put("user_id", "userId");
        columnFieldMap.put("username", null);
        columnFieldMap.put("sex", null);
        columnFieldMap.put("name", null);
        System.out.println(SqlQueryHandler.getSelectListSql(columnFieldMap, "user_basic_info", whereCondition));
    }
}
