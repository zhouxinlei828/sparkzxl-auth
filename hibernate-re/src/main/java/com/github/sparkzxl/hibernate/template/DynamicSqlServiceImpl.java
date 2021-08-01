package com.github.sparkzxl.hibernate.template;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

/**
 * description: 动态SQL服务实现类
 *
 * @author zhouxinlei
 * @date 2021-08-01 18:27:39
 */
@Service
public class DynamicSqlServiceImpl implements DynamicSqlService {

    @Override
    public int insert(String tableName, JSONObject parameters) {
        return 0;
    }

    @Override
    public int deleteById(String tableName, Serializable id) {
        return 0;
    }

    @Override
    public int delete(String tableName, JSONObject conditionMap) {
        return 0;
    }

    @Override
    public int deleteBatchIds(String tableName, Collection<? extends Serializable> idList) {
        return 0;
    }

    @Override
    public int updateById(String tableName, JSONObject parameters, Serializable id) {
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
