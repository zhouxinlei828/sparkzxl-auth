package com.github.sparkzxl.hibernate.template;

import cn.hutool.core.convert.Convert;
import com.alibaba.druid.sql.ast.SQLDataType;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.expr.*;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.github.sparkzxl.core.utils.DateUtils;

import java.math.BigDecimal;

/**
 * description: SQL处理工具类
 *
 * @author zhouxinlei
 * @date 2021-08-02 10:25:08
 */
public class SqlHandlerUtils {

    public static SQLExpr getSqlExpr(String sqlDataType, Object val) {
        SQLExpr sqlExpr = null;
        if (sqlDataType.equals(SQLDataType.Constants.BIGINT) ||
                sqlDataType.equals(SQLDataType.Constants.INT) ||
                sqlDataType.equals(SQLDataType.Constants.TINYINT) ||
                sqlDataType.equals(SQLDataType.Constants.NUMBER)) {
            sqlExpr = new SQLIntegerExpr(Convert.toLong(val, 0L));
        } else if (sqlDataType.equals(SQLDataType.Constants.CHAR) ||
                sqlDataType.equals(SQLDataType.Constants.NCHAR) ||
                sqlDataType.equals(SQLDataType.Constants.VARCHAR) ||
                sqlDataType.equals(SQLDataType.Constants.VARBINARY) ||
                sqlDataType.equals(SQLDataType.Constants.TEXT)) {
            sqlExpr = new SQLCharExpr(Convert.toStr(val));
        } else if (sqlDataType.equals(SQLDataType.Constants.DATE) ||
                sqlDataType.equals(SQLDataType.Constants.TIMESTAMP)) {
            sqlExpr = new SQLDateExpr(DateUtils.formatDateTime(Convert.toDate(val)));
        } else if (sqlDataType.equals(SQLDataType.Constants.DOUBLE)) {
            sqlExpr = new SQLDoubleExpr(Convert.toDouble(val, 0.0));
        } else if (sqlDataType.equals(SQLDataType.Constants.FLOAT)) {
            sqlExpr = new SQLFloatExpr(Convert.toStr(val));
        } else if (sqlDataType.equals(SQLDataType.Constants.DECIMAL)) {
            sqlExpr = new SQLDecimalExpr(Convert.toBigDecimal(val, new BigDecimal("0.0")));
        } else if (sqlDataType.equals(SQLDataType.Constants.BOOLEAN)) {
            sqlExpr = new SQLBooleanExpr(Convert.toBool(val, false));
        }
        return sqlExpr;
    }


    public static SQLBinaryOperator getOperator(SqlKeyword keyword) {
        SQLBinaryOperator sqlBinaryOperator = null;
        if (keyword.equals(SqlKeyword.AND)) {
            sqlBinaryOperator = SQLBinaryOperator.BooleanAnd;
        } else if (keyword.equals(SqlKeyword.OR)) {
            sqlBinaryOperator = SQLBinaryOperator.BooleanOr;
        } else if (keyword.equals(SqlKeyword.LIKE)) {
            sqlBinaryOperator = SQLBinaryOperator.Like;
        } else if (keyword.equals(SqlKeyword.NOT_LIKE)) {
            sqlBinaryOperator = SQLBinaryOperator.NotLike;
        } else if (keyword.equals(SqlKeyword.EQ)) {
            sqlBinaryOperator = SQLBinaryOperator.Equality;
        } else if (keyword.equals(SqlKeyword.NE)) {
            sqlBinaryOperator = SQLBinaryOperator.NotEqual;
        } else if (keyword.equals(SqlKeyword.GT)) {
            sqlBinaryOperator = SQLBinaryOperator.GreaterThan;
        } else if (keyword.equals(SqlKeyword.GE)) {
            sqlBinaryOperator = SQLBinaryOperator.GreaterThanOrEqual;
        } else if (keyword.equals(SqlKeyword.LT)) {
            sqlBinaryOperator = SQLBinaryOperator.LessThan;
        } else if (keyword.equals(SqlKeyword.LE)) {
            sqlBinaryOperator = SQLBinaryOperator.LessThanOrEqual;
        }
        return sqlBinaryOperator;
    }

    public static SQLBinaryOpExpr getSqlBinaryOpExpr(Condition condition) {
        SQLBinaryOpExpr sqlBinaryOpExpr = new SQLBinaryOpExpr();
        sqlBinaryOpExpr.setLeft(new SQLIdentifierExpr(condition.getKey()));
        SQLExpr sqlExpr = getSqlExpr(condition.getType(), condition.getVal());
        sqlBinaryOpExpr.setRight(sqlExpr);
        SqlKeyword keyword = condition.getKeyword();
        SQLBinaryOperator sqlBinaryOperator = getOperator(condition.getKeyword());
        sqlBinaryOpExpr.setOperator(sqlBinaryOperator);
        return sqlBinaryOpExpr;
    }
}
