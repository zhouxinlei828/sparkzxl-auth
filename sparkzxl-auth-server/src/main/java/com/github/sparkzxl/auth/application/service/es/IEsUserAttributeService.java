package com.github.sparkzxl.auth.application.service.es;

import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Map;

/**
 * description: ES用户属性 服务类
 *
 * @author charles.zhou
 * @date 2021-03-24 15:52:17
 */
public interface IEsUserAttributeService {

    /**
     * 创建索引
     *
     * @param index 索引
     */
    void createIndex(String index);

    /**
     * delete Index
     *
     * @param index 索引
     */
    void deleteIndex(String index);

    /**
     * 保存
     *
     * @param index         索引
     * @param id            主键
     * @param userAttribute 对象列表
     */
    void insert(String index, String id, Map<String, Object> userAttribute);

    /**
     * 更新
     *
     * @param index         索引
     * @param id            主键
     * @param userAttribute 对象列表
     */
    void update(String index, String id, Map<String, Object> userAttribute);

    /**
     * 批量保存
     *
     * @param index          索引
     * @param id             主键
     * @param userAttributes 对象列表
     */
    void insertBatch(String index, String id, List<Map<String, Object>> userAttributes);

    /**
     * 批量更新
     *
     * @param index          索引
     * @param id             主键
     * @param userAttributes 对象列表
     */
    void updateBatch(String index, String id, List<Map<String, Object>> userAttributes);

    /**
     * 删除
     *
     * @param index         索引
     * @param id            主键
     * @param userAttribute 对象
     */
    void delete(String index, String id, @Nullable Map<String, Object> userAttribute);

    /**
     * search all doc records
     *
     * @param index 索引
     * @return List<Map < String, Object>>
     */
    List<Map<String, Object>> searchList(String index);

    /**
     * search all doc records
     *
     * @param index 索引
     * @param id    主键
     * @return Map<String, Object>
     */
    Map<String, Object> searchUserAttribute(String index, String id);

    /**
     * search all doc records
     *
     * @param index  索引
     * @param idList 主键列表
     * @return Map<String, Object>
     */
    List<Map<String, Object>> searchUserAttributeList(String index, List<Long> idList);

}
