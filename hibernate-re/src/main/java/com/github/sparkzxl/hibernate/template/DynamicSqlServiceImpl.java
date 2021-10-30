package com.github.sparkzxl.hibernate.template;

import com.alibaba.druid.sql.ast.SQLDataType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * description: 动态SQL服务实现类
 *
 * @author zhouxinlei
 * @date 2021-08-01 18:27:39
 */
@Service
public class DynamicSqlServiceImpl implements DynamicSqlService {

    @Override
    public int insert(String tableName, List<DynamicColumn> columnList) {
        String insertSql = DynamicSqlOps.getInsertSql(tableName, columnList);
        return 0;
    }

    @Override
    public int deleteById(String tableName, String key, Serializable id) {
        Condition condition = new Condition();
        condition.setKey(key)
                .setVal(id)
                .setType(SQLDataType.Constants.BIGINT)
                .setKeyword(SqlKeyword.EQ);
        String deleteSql = DynamicSqlOps.getDeleteSql(tableName, Lists.newArrayList(condition));
        return 0;
    }

    @Override
    public int delete(String tableName, List<Condition> whereConditionList) {
        String deleteSql = DynamicSqlOps.getDeleteSql(tableName, whereConditionList);
        return 0;
    }

    @Override
    public int deleteBatchIds(String tableName, String key, Collection<? extends Serializable> idList) {
        for (Serializable id : idList) {
            deleteById(tableName, key, id);
        }
        return 0;
    }

    @Override
    public int updateById(String tableName, List<DynamicColumn> columnList, String key, Serializable id) {
        Condition condition = new Condition();
        condition.setKey(key)
                .setVal(id)
                .setType(SQLDataType.Constants.BIGINT)
                .setKeyword(SqlKeyword.EQ);
        String updateSql = DynamicSqlOps.getUpdateSql(tableName, columnList, Lists.newArrayList(condition));
        return 0;
    }

    @Override
    public int update(String tableName, JSONObject parameters, JSONObject conditionMap) {
        return 0;
    }

    @Override
    public JSONObject selectById(String tableName, Serializable id) {
        return null;
    }

    @Override
    public JSONArray selectBatchIds(String tableName, Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public JSONObject selectOne(String tableName, JSONObject conditionMap) {
        return null;
    }

    @Override
    public Integer selectCount(String tableName, JSONObject conditionMap) {
        return null;
    }

    @Override
    public JSONArray selectList(String tableName, JSONObject conditionMap) {
        return null;
    }
}
