package com.github.sparkzxl.hibernate.template;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * description: 动态SQL服务类
 *
 * @author zhouxinlei
 * @since 2021-08-01 18:26:28
 */
public interface DynamicSqlService {


    int insert(String tableName, List<DynamicColumn> columnList);

    int deleteById(String tableName, String key, Serializable id);

    int delete(String tableName, List<Condition> whereConditionList);

    int deleteBatchIds(String tableName, String key, Collection<? extends Serializable> idList);

    int updateById(String tableName, List<DynamicColumn> columnList, String key, Serializable id);

    int update(String tableName, JSONObject parameters, JSONObject conditionMap);

    JSONObject selectById(String tableName, Serializable id);

    JSONArray selectBatchIds(String tableName, Collection<? extends Serializable> idList);

    JSONObject selectOne(String tableName, JSONObject conditionMap);

    Integer selectCount(String tableName, JSONObject conditionMap);

    JSONArray selectList(String tableName, JSONObject conditionMap);

}
