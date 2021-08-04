package com.github.sparkzxl.hibernate.template;

import cn.hutool.core.util.IdUtil;
import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLDataType;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlInsertStatement;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * description: 动态SQL操作类
 *
 * @author zhouxinlei
 * @date 2021-07-31 17:26:30
 */
public class DynamicSqlOps {


    /**
     * 获取新增SQL
     *
     * @param tableName  表名
     * @param columnList 字段
     * @return String
     */
    public static String getInsertSql(String tableName, List<DynamicColumn> columnList) {
        SQLInsertInto sqlInsertInto = new MySqlInsertStatement();
        sqlInsertInto.setTableSource(new SQLExprTableSource(tableName));
        SQLInsertStatement.ValuesClause valuesClause = new SQLInsertStatement.ValuesClause();
        for (DynamicColumn column : columnList) {
            SQLIdentifierExpr sqlIdentifierExpr = new SQLIdentifierExpr(column.getKey());
            sqlInsertInto.addColumn(sqlIdentifierExpr);
            SQLExpr sqlExpr = SqlHandlerUtils.getSqlExpr(column.getType(), column.getVal());
            valuesClause.addValue(sqlExpr);
        }
        sqlInsertInto.addValueCause(valuesClause);
        return SQLUtils.toSQLString(sqlInsertInto, DbType.mysql);
    }

    /**
     * 获取删除SQL
     *
     * @param tableName          表名
     * @param whereConditionList 查询条件
     * @return String
     */
    public static String getDeleteSql(String tableName, List<Condition> whereConditionList) {
        SQLDeleteStatement statement = new SQLDeleteStatement();
        statement.setTableSource(new SQLExprTableSource(tableName));
        for (Condition condition : whereConditionList) {
            SQLBinaryOpExpr sqlBinaryOpExpr = SqlHandlerUtils.getSqlBinaryOpExpr(condition);
            statement.addCondition(sqlBinaryOpExpr);
        }
        return SQLUtils.toSQLString(statement, DbType.mysql);
    }

    /**
     * 获取修改SQL
     *
     * @param tableName          表名
     * @param columnList         修改字段
     * @param whereConditionList 查询条件
     * @return String
     */
    public static String getUpdateSql(String tableName, List<DynamicColumn> columnList, List<Condition> whereConditionList) {
        SQLUpdateStatement updateStatement = new SQLUpdateStatement();
        updateStatement.setTableSource(new SQLExprTableSource(tableName));
        for (DynamicColumn column : columnList) {
            SQLUpdateSetItem sqlUpdateSetItem = new SQLUpdateSetItem();
            sqlUpdateSetItem.setColumn(new SQLIdentifierExpr(column.getKey()));
            SQLExpr sqlExpr = SqlHandlerUtils.getSqlExpr(column.getType(), column.getVal());
            sqlUpdateSetItem.setValue(sqlExpr);
            updateStatement.addItem(sqlUpdateSetItem);
        }
        for (Condition condition : whereConditionList) {
            SQLBinaryOpExpr sqlBinaryOpExpr = SqlHandlerUtils.getSqlBinaryOpExpr(condition);
            updateStatement.addCondition(sqlBinaryOpExpr);
        }
        return SQLUtils.toSQLString(updateStatement, DbType.mysql);
    }

    /**
     * 获取查询SQL
     *
     * @param tableName          表名
     * @param columnList         修改字段
     * @param whereConditionList 查询条件
     * @return String
     */
    public static String getSelectSql(String tableName, List<DynamicColumn> columnList, List<Condition> whereConditionList) {
        SQLSelect sqlSelect = new SQLSelect();
        SQLSelectQueryBlock queryBlock = new SQLSelectQueryBlock();
        if (CollectionUtils.isNotEmpty(columnList)) {
            for (DynamicColumn column : columnList) {
                SQLIdentifierExpr sqlIdentifierExpr = new SQLIdentifierExpr(column.getKey());
                if (StringUtils.isNotEmpty(column.getAlias())) {
                    queryBlock.addSelectItem(sqlIdentifierExpr, column.getAlias());
                } else {
                    queryBlock.addSelectItem(sqlIdentifierExpr);
                }
            }
        } else {
            SQLIdentifierExpr sqlIdentifierExpr = new SQLIdentifierExpr("*");
            queryBlock.addSelectItem(sqlIdentifierExpr);
        }
        queryBlock.setFrom(new SQLExprTableSource(tableName));
        if (CollectionUtils.isNotEmpty(whereConditionList)) {
            for (Condition condition : whereConditionList) {
                SQLBinaryOpExpr sqlBinaryOpExpr = SqlHandlerUtils.getSqlBinaryOpExpr(condition);
                queryBlock.addCondition(sqlBinaryOpExpr);
            }
        }
        sqlSelect.setQuery(queryBlock);
        return SQLUtils.toSQLString(sqlSelect, DbType.mysql);
    }

    public static void main(String[] args) {
        insertData();
        System.out.println("=================");
        updateData();
        System.out.println("=================");
        deleteData();
        System.out.println("=================");
        selectData();

    }

    public static String insertData() {
        List<DynamicColumn> columnList = Lists.newArrayList();
        DynamicColumn dynamicColumn = new DynamicColumn()
                .setKey("user_id")
                .setVal(IdUtil.objectId())
                .setType(SQLDataType.Constants.VARCHAR);
        columnList.add(dynamicColumn);
        DynamicColumn dynamicColumn1 = new DynamicColumn()
                .setKey("username")
                .setVal("zhouxinlei")
                .setType(SQLDataType.Constants.VARCHAR);
        columnList.add(dynamicColumn1);
        DynamicColumn dynamicColumn2 = new DynamicColumn()
                .setKey("sex")
                .setVal("男")
                .setType(SQLDataType.Constants.INT);
        columnList.add(dynamicColumn2);
        DynamicColumn dynamicColumn3 = new DynamicColumn()
                .setKey("name")
                .setVal("周鑫磊")
                .setType(SQLDataType.Constants.VARCHAR);
        columnList.add(dynamicColumn3);
        System.out.println(DynamicSqlOps.getInsertSql("user_basic_info", columnList));
        return DynamicSqlOps.getInsertSql("user_basic_info", columnList);
    }

    public static String updateData() {
        List<DynamicColumn> columnList = Lists.newArrayList();
        DynamicColumn dynamicColumn = new DynamicColumn()
                .setKey("user_id")
                .setVal(IdUtil.objectId())
                .setType(SQLDataType.Constants.VARCHAR);
        columnList.add(dynamicColumn);
        DynamicColumn dynamicColumn1 = new DynamicColumn()
                .setKey("username")
                .setVal("zhouxinlei")
                .setType(SQLDataType.Constants.VARCHAR);
        columnList.add(dynamicColumn1);
        DynamicColumn dynamicColumn2 = new DynamicColumn()
                .setKey("sex")
                .setVal("男")
                .setType(SQLDataType.Constants.INT);
        columnList.add(dynamicColumn2);
        DynamicColumn dynamicColumn3 = new DynamicColumn()
                .setKey("name")
                .setVal("周鑫磊")
                .setType(SQLDataType.Constants.VARCHAR);
        columnList.add(dynamicColumn3);

        List<Condition> whereConditionList = Lists.newArrayList();
        Condition condition = new Condition();
        condition.setKey("user_id")
                .setVal(1)
                .setType(SQLDataType.Constants.BIGINT)
                .setKeyword(SqlKeyword.EQ);
        whereConditionList.add(condition);
        Condition condition1 = new Condition();
        condition1.setKey("username")
                .setVal("admin")
                .setType(SQLDataType.Constants.VARCHAR)
                .setKeyword(SqlKeyword.EQ);
        whereConditionList.add(condition1);
        System.out.println(DynamicSqlOps.getUpdateSql("user_basic_info", columnList, whereConditionList));
        return DynamicSqlOps.getUpdateSql("user_basic_info", columnList, whereConditionList);
    }

    public static String deleteData() {
        List<Condition> whereConditionList = Lists.newArrayList();
        Condition condition = new Condition();
        condition.setKey("user_id")
                .setVal(1)
                .setType(SQLDataType.Constants.BIGINT)
                .setKeyword(SqlKeyword.EQ);
        whereConditionList.add(condition);
        Condition condition1 = new Condition();
        condition1.setKey("username")
                .setVal("admin")
                .setType(SQLDataType.Constants.VARCHAR)
                .setKeyword(SqlKeyword.EQ);
        whereConditionList.add(condition1);
        System.out.println(DynamicSqlOps.getDeleteSql("user_basic_info", whereConditionList));
        return DynamicSqlOps.getDeleteSql("user_basic_info", whereConditionList);
    }

    public static String selectData() {
        List<Condition> whereConditionList = Lists.newArrayList();
        Condition condition = new Condition();
        condition.setKey("user_id")
                .setVal(1)
                .setType(SQLDataType.Constants.BIGINT)
                .setKeyword(SqlKeyword.EQ);
        whereConditionList.add(condition);
        Condition condition1 = new Condition();
        condition1.setKey("username")
                .setVal("admin")
                .setType(SQLDataType.Constants.VARCHAR)
                .setKeyword(SqlKeyword.EQ);
        whereConditionList.add(condition1);
        List<DynamicColumn> columnList = Lists.newArrayList();
        DynamicColumn dynamicColumn = new DynamicColumn()
                .setKey("user_id")
                .setAlias("userId");
        columnList.add(dynamicColumn);
        DynamicColumn dynamicColumn1 = new DynamicColumn()
                .setKey("username");
        columnList.add(dynamicColumn1);
        DynamicColumn dynamicColumn2 = new DynamicColumn()
                .setKey("sex");
        columnList.add(dynamicColumn2);
        DynamicColumn dynamicColumn3 = new DynamicColumn()
                .setKey("name");
        columnList.add(dynamicColumn3);
        System.out.println(DynamicSqlOps.getSelectSql("user_basic_info", columnList, whereConditionList));
        return DynamicSqlOps.getSelectSql("user_basic_info", columnList, whereConditionList);
    }

}
