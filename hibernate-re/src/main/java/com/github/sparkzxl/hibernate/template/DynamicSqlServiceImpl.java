package com.github.sparkzxl.hibernate.template;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * description: 动态SQL服务实现类
 *
 * @author zhouxinlei
 * @date 2021-08-01 18:27:39
 */
@Service
public class DynamicSqlServiceImpl implements DynamicSqlService {

    @Override
    public int insert(String tableName, Map<String, Object> parameters) {
        return 0;
    }

    @Override
    public int deleteById(String tableName, Serializable id) {
        return 0;
    }

    @Override
    public int delete(String tableName, Map<String, Object> conditionMap) {
        return 0;
    }

    @Override
    public int deleteBatchIds(String tableName, Collection<? extends Serializable> idList) {
        return 0;
    }

    @Override
    public int updateById(String tableName, Map<String, Object> parameters, Serializable id) {
        return 0;
    }

    @Override
    public int update(String tableName, Map<String, Object> parameters, Map<String, Object> conditionMap) {
        return 0;
    }

    @Override
    public Map<String, Object> selectById(String tableName, Serializable id) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectBatchIds(String tableName, Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public Map<String, Object> selectOne(String tableName, Map<String, Object> conditionMap) {
        return null;
    }

    @Override
    public Integer selectCount(String tableName, Map<String, Object> conditionMap) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectList(String tableName, Map<String, Object> conditionMap) {
        return null;
    }
}
