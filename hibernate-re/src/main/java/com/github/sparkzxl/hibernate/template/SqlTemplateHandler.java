package com.github.sparkzxl.hibernate.template;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.StrFormatter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.sparkzxl.core.utils.StrPool;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * description: sql查询模板
 *
 * @author zhouxinlei
 * @date 2021-07-31 17:26:30
 */
public class SqlTemplateHandler {

    public static final String SELECT_LIST = "select {} from {} where {}";

    public static String getSelectListSql(Map<String, String> columnFieldMap, String tableName, Map<String, Object> conditionMap) {
        StringBuilder selectParams = new StringBuilder();
        if (MapUtil.isNotEmpty(columnFieldMap)) {
            for (String key : columnFieldMap.keySet()) {
                String val = columnFieldMap.get(key);
                if (StringUtils.isNotEmpty(val)) {
                    selectParams.append(key).append(StrPool.SPACE).append(val).append(StrPool.DEF_ROOT_PATH);
                } else {
                    selectParams.append(key).append(StrPool.DEF_ROOT_PATH);
                }
            }
        }
        String targetSql = "1=1";
        if (MapUtil.isNotEmpty(conditionMap)) {
            QueryWrapper queryWrapper = new QueryWrapper<>();
            for (String key : conditionMap.keySet()) {
                queryWrapper.eq(key, conditionMap.get(key));
            }
            targetSql = queryWrapper.getTargetSql();
        }
        return StrFormatter.format(SELECT_LIST, selectParams.toString(), tableName, targetSql);
    }

    public static void main(String[] args) {
        Map<String, Object> whereCondition = Maps.newHashMap();
        whereCondition.put("user_id", 1);
        whereCondition.put("username", "admin");
        Map<String, String> columnFieldMap = Maps.newHashMap();
        columnFieldMap.put("user_id", "userId");
        columnFieldMap.put("username", null);
        columnFieldMap.put("sex", null);
        columnFieldMap.put("name", null);
        System.out.println(SqlTemplateHandler.getSelectListSql(columnFieldMap, "user_basic_info", whereCondition));
    }
}
