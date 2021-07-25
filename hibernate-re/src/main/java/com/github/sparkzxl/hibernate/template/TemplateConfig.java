package com.github.sparkzxl.hibernate.template;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * description:  模板配置
 *
 * @author zhouxinlei
 * @date 2021-07-25 12:33:42
 */
@Slf4j
public class TemplateConfig {

    private static final Configuration CONFIGURATION;

    public static String getTemplate(String name, String encoding, Map<String, Object> dataModel) {
        try {
            StringWriter var3 = new StringWriter();
            Template template = CONFIGURATION.getTemplate(name, encoding);
            template.process(dataModel, var3);
            return var3.toString();
        } catch (Exception var5) {
            log.error(var5.getMessage(), var5);
            return var5.toString();
        }
    }

    public static String getTemplate(String var0, Map<String, Object> dataModel) {
        return getTemplate(var0, StandardCharsets.UTF_8.displayName().toLowerCase(Locale.ROOT), dataModel);
    }

    public static void main(String[] args) {
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("itl_schema", "sparkzxl_auth_hz");
        dataModel.put("itl_table_name", "auth_ser");
        dataModel.put("itl_table_comment", "用户信息表");
        List<Map<String, Object>> mapList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("table_name", "auth_ser");
            map.put("fieldName", "field" + i);
            map.put("fieldType", "varchar");
            map.put("fieldLength", i);
            map.put("allowNull", 1);
            map.put("comment", "用户字段" + i);
            mapList.add(map);
        }
        dataModel.put("columns", mapList);
        dataModel.put("itl_table_name", "auth_ser");
        System.out.println(TemplateConfig.getTemplate("tableTemplate.ftl", dataModel));
    }

    static {
        CONFIGURATION = new Configuration(Configuration.VERSION_2_3_28);
        CONFIGURATION.setNumberFormat("0.#####################");
        CONFIGURATION.setClassForTemplateLoading(TemplateConfig.class, "/");
    }
}
