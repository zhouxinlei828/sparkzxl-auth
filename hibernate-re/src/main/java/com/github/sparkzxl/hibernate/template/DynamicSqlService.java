package com.github.sparkzxl.hibernate.template;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * description: 动态SQL服务类
 *
 * @author zhouxinlei
 * @date 2021-08-01 18:26:28
 */
public interface DynamicSqlService {


    int insert(String tableName, Map<String, Object> parameters);

    int deleteById(String tableName, Serializable id);

    int delete(String tableName, Map<String, Object> conditionMap);

    int deleteBatchIds(String tableName, Collection<? extends Serializable> idList);

    int updateById(String tableName, Map<String, Object> parameters, Serializable id);

    int update(String tableName, Map<String, Object> parameters, Map<String, Object> conditionMap);

    Map<String, Object> selectById(String tableName, Serializable id);

    List<Map<String, Object>> selectBatchIds(String tableName, Collection<? extends Serializable> idList);

    Map<String, Object> selectOne(String tableName, Map<String, Object> conditionMap);

    Integer selectCount(String tableName, Map<String, Object> conditionMap);

    List<Map<String, Object>> selectList(String tableName, Map<String, Object> conditionMap);

}
