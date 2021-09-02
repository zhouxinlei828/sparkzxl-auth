package com.github.sparkzxl.workflow.domain.repository.mongodb;

import cn.hutool.json.JSONUtil;
import com.github.sparkzxl.core.context.AppContextHolder;
import com.github.sparkzxl.core.utils.DateUtils;
import com.github.sparkzxl.mongodb.dynamic.DynamicDatabaseContextHolder;
import com.github.sparkzxl.workflow.WorkflowApplication;
import com.github.sparkzxl.workflow.infrastructure.entity.mongodb.OnlFormTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

@SpringBootTest(classes = {WorkflowApplication.class}, properties = {"spring.profiles.active=dev"})
public class OnlFormTemplateRepositoryTest {

    @Autowired
    private OnlFormTemplateRepository templateRepository;

    @Test
    void test() {
        AppContextHolder.setUserId("admin");
        DynamicDatabaseContextHolder.push("hz");
        OnlFormTemplate onlFormTemplate = new OnlFormTemplate();
        onlFormTemplate.setTemplateCode("test_template");
        onlFormTemplate.setTemplateName("测试模板");
        onlFormTemplate.setTemplateJson("{\"column\":[{\"type\":\"title\",\"span\":24,\"display\":true,\"styles\":{\"fontSize\":\"18px\",\"color\":\"#000\"},\"labelWidth\":\"50%\",\"value\":\"请假条\",\"prop\":\"1630205651504_44581\",\"label\":\"\"},{\"type\":\"input\",\"label\":\"请假标题\",\"span\":12,\"display\":true,\"prop\":\"1630205696341_50071\",\"labelTip\":\"请输入请假事由\",\"labelTipPlacement\":\"bottom\"},{\"type\":\"daterange\",\"label\":\"请假时间\",\"span\":12,\"display\":true,\"format\":\"yyyy-MM-dd\",\"valueFormat\":\"yyyy-MM-dd\",\"prop\":\"1630205813595_74698\"},{\"type\":\"ueditor\",\"component\":\"avue-ueditor\",\"label\":\"详细事由\",\"span\":24,\"display\":true,\"options\":{\"action\":\"\",\"oss\":\"\",\"props\":{},\"ali\":{},\"qiniu\":{}},\"prop\":\"1630205854232_45542\"}],\"labelPosition\":\"left\",\"labelSuffix\":\"：\",\"labelWidth\":120,\"gutter\":0,\"menuBtn\":true,\"submitBtn\":true,\"submitText\":\"提交\",\"emptyBtn\":true,\"emptyText\":\"清空\",\"menuPosition\":\"center\",\"tabs\":false}");
        templateRepository.insert(onlFormTemplate);
    }

    @Test
    void testFindTemplate() {
        //DynamicDatabaseContextHolder.push("hz");
        OnlFormTemplate onlFormTemplate = new OnlFormTemplate();
        onlFormTemplate.setTemplateCode("test_template1");
        Example<OnlFormTemplate> example = Example.of(onlFormTemplate);
        OnlFormTemplate template = templateRepository.findOne(example).orElse(null);
        System.out.println(DateUtils.formatLocalDateTime(template.getCreateTime()));
        System.out.println(JSONUtil.toJsonPrettyStr(template));
    }

}
