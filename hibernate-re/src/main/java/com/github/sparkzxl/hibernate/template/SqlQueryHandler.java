package com.github.sparkzxl.hibernate.template;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.IdUtil;
import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOperator;
import com.alibaba.druid.sql.ast.expr.SQLCharExpr;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.expr.MySqlCharExpr;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlInsertStatement;
import com.alibaba.fastjson.JSONObject;
import com.github.sparkzxl.core.utils.StrPool;
import org.apache.commons.lang3.StringUtils;

/**
 * description: sql查询模板
 *
 * @author zhouxinlei
 * @date 2021-07-31 17:26:30
 */
public class SqlQueryHandler {


    public static String getInsertSql(String tableName, JSONObject columnFieldJsonObject) {
        SQLInsertInto sqlInsertInto = new MySqlInsertStatement();
        sqlInsertInto.setTableSource(new SQLExprTableSource(tableName));
        SQLInsertStatement.ValuesClause valuesClause = new SQLInsertStatement.ValuesClause();
        for (String key : columnFieldJsonObject.keySet()) {
            String val = columnFieldJsonObject.getString(key);
            SQLIdentifierExpr sqlIdentifierExpr = new SQLIdentifierExpr(key);
            sqlInsertInto.addColumn(sqlIdentifierExpr);
            valuesClause.addValue(new MySqlCharExpr(val));
        }
        sqlInsertInto.addValueCause(valuesClause);
        return SQLUtils.toSQLString(sqlInsertInto, DbType.mysql);
    }

    public static String getDeleteSql(String tableName, JSONObject conditionJsonObject) {
        String deleteSql = "delete from {} where {}";
        StringBuilder whereClause = new StringBuilder();
        int index = 0;
        for (String key : conditionJsonObject.keySet()) {
            String val = conditionJsonObject.getString(key);
            if (index == conditionJsonObject.size() - 1) {
                whereClause.append(key)
                        .append(StrPool.EQUALS)
                        .append(val);
            } else {
                whereClause.append(key)
                        .append(StrPool.EQUALS)
                        .append(val)
                        .append(StrPool.SPACE)
                        .append(StrPool.AND)
                        .append(StrPool.SPACE);
            }
            index++;
        }
        return StrFormatter.format(deleteSql, tableName, whereClause.toString());
    }

    public static String getSelectSql(JSONObject columnFieldJsonObject, String tableName, JSONObject conditionJsonObject) {
        SQLSelect sqlSelect = new SQLSelect();
        SQLSelectQueryBlock queryBlock = new SQLSelectQueryBlock();
        if (MapUtil.isNotEmpty(columnFieldJsonObject)) {
            for (String key : columnFieldJsonObject.keySet()) {
                String val = columnFieldJsonObject.getString(key);
                SQLIdentifierExpr sqlIdentifierExpr = new SQLIdentifierExpr(key);
                if (StringUtils.isNotEmpty(val)) {
                    queryBlock.addSelectItem(sqlIdentifierExpr, val);
                } else {
                    queryBlock.addSelectItem(sqlIdentifierExpr);
                }
            }
        }
        queryBlock.setFrom(new SQLExprTableSource(new SQLIdentifierExpr(tableName)));
        if (MapUtil.isNotEmpty(conditionJsonObject)) {
            for (String key : conditionJsonObject.keySet()) {
                SQLBinaryOpExpr sqlBinaryOpExpr = new SQLBinaryOpExpr(new SQLIdentifierExpr(key), SQLBinaryOperator.Equality,
                        new SQLCharExpr(conditionJsonObject.getString(key)));
                queryBlock.addCondition(sqlBinaryOpExpr);
            }
        }
        sqlSelect.setQuery(queryBlock);
        return SQLUtils.toSQLString(sqlSelect, DbType.mysql);
    }

    public static void main(String[] args) {
        JSONObject whereCondition = new JSONObject(true);
        whereCondition.put("user_id", "1");
        whereCondition.put("username", "admin");
        JSONObject columnFieldMap = new JSONObject(true);
        columnFieldMap.put("user_id", "userId");
        columnFieldMap.put("username", null);
        columnFieldMap.put("sex", null);
        columnFieldMap.put("name", null);
        System.out.println(SqlQueryHandler.getSelectSql(columnFieldMap, "user_basic_info", whereCondition));
        System.out.println("=================");
        JSONObject insertColumnFieldMap = new JSONObject(true);
        insertColumnFieldMap.put("user_id", IdUtil.objectId());
        insertColumnFieldMap.put("username", "zhouxinlei");
        insertColumnFieldMap.put("sex", "1");
        insertColumnFieldMap.put("name", "周鑫磊");
        System.out.println(SqlQueryHandler.getInsertSql("user_basic_info", insertColumnFieldMap));

        System.out.println("=================");
        System.out.println(SqlQueryHandler.getDeleteSql("user_basic_info", whereCondition));
    }
}
