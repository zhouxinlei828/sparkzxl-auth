package com.github.sparkzxl.hibernate.template;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Collection;

/**
 * description: 动态SQL服务类
 *
 * @author zhouxinlei
 * @date 2021-08-01 18:26:28
 */
public interface DynamicSqlService {


    int insert(String tableName, JSONObject parameters);

    int deleteById(String tableName, Serializable id);

    int delete(String tableName, JSONObject conditionMap);

    int deleteBatchIds(String tableName, Collection<? extends Serializable> idList);

    int updateById(String tableName, JSONObject parameters, Serializable id);

    int update(String tableName, JSONObject parameters, JSONObject conditionMap);

    JSONObject selectById(String tableName, Serializable id);

    JSONArray selectBatchIds(String tableName, Collection<? extends Serializable> idList);

    JSONObject selectOne(String tableName, JSONObject conditionMap);

    Integer selectCount(String tableName, JSONObject conditionMap);

    JSONArray selectList(String tableName, JSONObject conditionMap);

}
