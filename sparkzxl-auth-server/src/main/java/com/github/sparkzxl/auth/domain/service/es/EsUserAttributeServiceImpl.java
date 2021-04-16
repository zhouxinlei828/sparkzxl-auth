package com.github.sparkzxl.auth.domain.service.es;

import com.github.sparkzxl.auth.application.service.es.IEsUserAttributeService;
import com.github.sparkzxl.auth.infrastructure.constant.ElasticsearchConstant;
import com.github.sparkzxl.database.constant.EntityConstant;
import com.github.sparkzxl.elasticsearch.service.base.BaseElasticsearchService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * description: ES用户属性 服务实现类
 *
 * @author zhouxinlei
 * @date 2021-04-16 21:25:35
 */
@Service
@Slf4j
public class EsUserAttributeServiceImpl extends BaseElasticsearchService implements IEsUserAttributeService {

    @Override
    public void createIndex(String index) {
        createIndexRequest(index);
    }

    @Override
    public void deleteIndex(String index) {
        deleteIndexRequest(index);
    }

    @Override
    public void insert(String index, String id, Map<String, Object> userAttribute) {
        try {
            IndexRequest request = buildIndexRequest(index, id, userAttribute);
            try {
                restHighLevelClient.index(request, COMMON_OPTIONS);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        } finally {
            try {
                restHighLevelClient.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    @Override
    public void update(String index, String id, Map<String, Object> userAttributes) {
        updateRequest(index, id, userAttributes);
    }

    @Override
    public void insertBatch(String index, String id, List<Map<String, Object>> userAttributes) {

    }

    @Override
    public void updateBatch(String index, String id, List<Map<String, Object>> userAttributes) {

    }

    @Override
    public void delete(String index, String id, Map<String, Object> userAttribute) {
        if (ObjectUtils.isEmpty(userAttribute)) {
            // 如果person 对象为空，则删除全量
            searchList(index).forEach(p -> {
                deleteRequest(index, String.valueOf(p.get(EntityConstant.COLUMN_ID)));
            });
        }
        deleteRequest(index, String.valueOf(userAttribute.get(EntityConstant.COLUMN_ID)));
    }

    @Override
    public List<Map<String, Object>> searchList(String index) {
        SearchResponse searchResponse = search(index);
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<Map<String, Object>> userAttributeList = new ArrayList<>();
        Arrays.stream(hits).forEach(hit -> {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            userAttributeList.add(sourceAsMap);
        });
        return userAttributeList;
    }

    @Override
    public Map<String, Object> searchUserAttribute(String index, String id) {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery(ElasticsearchConstant.ES_ID, id));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, COMMON_OPTIONS);
        } catch (IOException e) {
            log.error(e.getMessage());
            log.error(e.getMessage());
        }
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<Map<String, Object>> userAttributeList = new ArrayList<>();
        Arrays.stream(hits).forEach(hit -> {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            userAttributeList.add(sourceAsMap);
        });
        return userAttributeList.size() == 0 ? null : userAttributeList.get(0);
    }

    @Override
    public List<Map<String, Object>> searchUserAttributeList(String index, List<Long> idList) {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termsQuery(ElasticsearchConstant.ES_ID, idList));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = null;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, COMMON_OPTIONS);
        } catch (IOException e) {
            log.error(e.getMessage());
            log.error(e.getMessage());
        }
        SearchHit[] hits = searchResponse.getHits().getHits();
        List<Map<String, Object>> userAttributeList = new ArrayList<>();
        Arrays.stream(hits).forEach(hit -> {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            userAttributeList.add(sourceAsMap);
        });
        return userAttributeList;
    }
}
