package com.github.sparkzxl.hibernate.template;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLDataType;
import com.alibaba.druid.sql.ast.SQLDataTypeImpl;
import com.alibaba.druid.sql.ast.SQLIndexDefinition;
import com.alibaba.druid.sql.ast.expr.SQLCharExpr;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.MySqlPrimaryKey;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/**
 * description:  模板配置
 *
 * @author zhouxinlei
 * @date 2021-07-25 12:33:42
 */
@Slf4j
public class SqlTableHandler {

    private static final Configuration CONFIGURATION;

    public static String getCreateTableSql(String name, String encoding, Map<String, Object> dataModel) {
        try {
            StringWriter var3 = new StringWriter();
            Template template = CONFIGURATION.getTemplate(name, encoding);
            template.process(dataModel, var3);
            return var3.toString();
        } catch (Exception var5) {
            log.error(var5.getMessage(), var5);
            return var5.toString();
        }
    }

    public static void main(String[] args) {
        SQLCreateTableStatement sqlCreateTableStatement = new SQLCreateTableStatement();
        sqlCreateTableStatement.setTableName("user_basic_info");
        sqlCreateTableStatement.setIfNotExiists(true);
        sqlCreateTableStatement.setComment(new SQLCharExpr("用户信息表"));
        //定义字段
        SQLColumnDefinition sqlColumnDefinition = new SQLColumnDefinition();
        sqlColumnDefinition.setName("id");
        sqlColumnDefinition.setDataType(new SQLDataTypeImpl(SQLDataType.Constants.BIGINT, 20));
        sqlColumnDefinition.setComment("主键ID");
        sqlColumnDefinition.addConstraint(new SQLNotNullConstraint());
        sqlColumnDefinition.setAutoIncrement(true);
        sqlCreateTableStatement.addColumn(sqlColumnDefinition);

        SQLColumnDefinition sqlColumnDefinition1 = new SQLColumnDefinition();
        sqlColumnDefinition1.setName("username");
        sqlColumnDefinition1.setDataType(new SQLDataTypeImpl(SQLDataType.Constants.VARCHAR, 255));
        sqlColumnDefinition1.setComment("用户名");
        sqlColumnDefinition1.addConstraint(new SQLNotNullConstraint());
        sqlColumnDefinition1.setAutoIncrement(true);
        sqlCreateTableStatement.addColumn(sqlColumnDefinition1);

        //主键
        MySqlPrimaryKey mySqlPrimaryKey = new MySqlPrimaryKey();
        SQLIndexDefinition indexDefinition = mySqlPrimaryKey.getIndexDefinition();
        indexDefinition.setType("PRIMARY");
        indexDefinition.setKey(true);
        indexDefinition.getColumns().add(new SQLSelectOrderByItem(new SQLIdentifierExpr("ID")));
        sqlCreateTableStatement.getTableElementList().add(mySqlPrimaryKey);
        // 配置  指定引擎 字符等
        List<SQLAssignItem> tableOptions = sqlCreateTableStatement.getTableOptions();
        tableOptions.add(new SQLAssignItem(new SQLIdentifierExpr("ENGINE"), new SQLIdentifierExpr("InnoDB")));
        tableOptions.add(new SQLAssignItem(new SQLIdentifierExpr("CHARSET"), new SQLIdentifierExpr("utf8mb4")));
        System.out.println(SQLUtils.toMySqlString(sqlCreateTableStatement));
    }

    static {
        CONFIGURATION = new Configuration(Configuration.VERSION_2_3_28);
        CONFIGURATION.setNumberFormat("0.#####################");
        CONFIGURATION.setClassForTemplateLoading(SqlTableHandler.class, "/");
    }
}
