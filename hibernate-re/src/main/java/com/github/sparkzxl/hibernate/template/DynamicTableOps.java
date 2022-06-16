package com.github.sparkzxl.hibernate.template;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLDataType;
import com.alibaba.druid.sql.ast.SQLDataTypeImpl;
import com.alibaba.druid.sql.ast.SQLIndexDefinition;
import com.alibaba.druid.sql.ast.expr.SQLCharExpr;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.statement.SQLAssignItem;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLNotNullConstraint;
import com.alibaba.druid.sql.ast.statement.SQLSelectOrderByItem;
import com.alibaba.druid.sql.dialect.mysql.ast.MySqlPrimaryKey;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.sql.visitor.VisitorFeature;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * description: 动态Table操作类
 *
 * @author zhouxinlei
 * @since 2021-08-04 15:30:26
 */
public class DynamicTableOps {

    public static String getCreateTableSql(String tableName, String comment, String storageEngine, List<SQLColumnDefinition> columnDefinitionList) {
        MySqlCreateTableStatement sqlCreateTableStatement = new MySqlCreateTableStatement();
        sqlCreateTableStatement.setTableName(tableName);
        sqlCreateTableStatement.setIfNotExiists(true);
        sqlCreateTableStatement.setComment(new SQLCharExpr(comment));
        for (SQLColumnDefinition sqlColumnDefinition : columnDefinitionList) {
            sqlCreateTableStatement.addColumn(sqlColumnDefinition);
        }
        MySqlPrimaryKey mySqlPrimaryKey = new MySqlPrimaryKey();
        SQLIndexDefinition indexDefinition = mySqlPrimaryKey.getIndexDefinition();
        indexDefinition.setType("PRIMARY");
        indexDefinition.setKey(true);
        indexDefinition.getColumns().add(new SQLSelectOrderByItem(new SQLIdentifierExpr("id")));
        sqlCreateTableStatement.getTableElementList().add(mySqlPrimaryKey);
        List<SQLAssignItem> tableOptions = sqlCreateTableStatement.getTableOptions();
        tableOptions.add(new SQLAssignItem(new SQLIdentifierExpr("ENGINE"), new SQLIdentifierExpr(storageEngine)));
        tableOptions.add(new SQLAssignItem(new SQLIdentifierExpr("CHARSET"), new SQLIdentifierExpr("utf8mb4")));
        tableOptions.add(new SQLAssignItem(new SQLIdentifierExpr("COLLATE"), new SQLIdentifierExpr("utf8mb4_general_ci")));
        tableOptions.add(new SQLAssignItem(new SQLIdentifierExpr("ROW_FORMAT"), new SQLIdentifierExpr("DYNAMIC")));
        return SQLUtils.toMySqlString(sqlCreateTableStatement, VisitorFeature.OutputPrettyFormat);
    }


    public static void main(String[] args) {
        List<SQLColumnDefinition> columnDefinitionList = Lists.newArrayList();
        //定义字段
        SQLColumnDefinition sqlColumnDefinition = new SQLColumnDefinition();
        sqlColumnDefinition.setName("id");
        sqlColumnDefinition.setDataType(new SQLDataTypeImpl(SQLDataType.Constants.BIGINT, 20));
        sqlColumnDefinition.setComment("主键ID");
        // 设置是否可为空
        sqlColumnDefinition.addConstraint(new SQLNotNullConstraint());
        sqlColumnDefinition.setAutoIncrement(true);
        columnDefinitionList.add(sqlColumnDefinition);

        SQLColumnDefinition sqlColumnDefinition1 = new SQLColumnDefinition();
        sqlColumnDefinition1.setName("username");
        sqlColumnDefinition1.setDataType(new SQLDataTypeImpl(SQLDataType.Constants.VARCHAR, 255));
        sqlColumnDefinition1.setComment("用户名");
        columnDefinitionList.add(sqlColumnDefinition1);
        String createTableSql = getCreateTableSql("user_basic_info", "用户信息表", "InnoDB", columnDefinitionList);
        System.out.println(createTableSql);
    }

}
