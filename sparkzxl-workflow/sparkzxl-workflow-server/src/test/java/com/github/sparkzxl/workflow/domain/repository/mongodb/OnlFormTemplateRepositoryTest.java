package com.github.sparkzxl.workflow.domain.repository.mongodb;

import cn.hutool.json.JSONUtil;
import com.github.sparkzxl.core.context.AppContextHolder;
import com.github.sparkzxl.workflow.WorkflowApplication;
import com.github.sparkzxl.workflow.infrastructure.entity.mongodb.OnlFormTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.Optional;

@SpringBootTest(classes = {WorkflowApplication.class}, properties = {"spring.profiles.active=dev"})
public class OnlFormTemplateRepositoryTest {

    @Autowired
    private OnlFormTemplateRepository templateRepository;

    @Test
    void test() {
        AppContextHolder.setUserId("admin");
        OnlFormTemplate onlFormTemplate = new OnlFormTemplate();
        onlFormTemplate.setTemplateCode("test_template");
        onlFormTemplate.setTemplateName("测试模板");
        onlFormTemplate.setTemplateJson("{\"diffPayment\": 1, \"contractType\": 1, \"paymentScale\": \"http://172.16.200.202:9000/gongbaojin-user/payment_scale/20210824192910XF8GUs7D.jpg\", \"constructionLicense\": \"http://172.16.200.202:9000/gongbaojin-user/construction_license/202108241929183JpqRjQP.png\", \"constructionContract\": \"http://172.16.200.202:9000/gongbaojin-user/construction_contract/20210824192911uDrlcydn.jpg\"}");
        templateRepository.insert(onlFormTemplate);
    }

    @Test
    void testFindTemplate() {
        AppContextHolder.setUserId("admin");
        OnlFormTemplate onlFormTemplate = new OnlFormTemplate();
        onlFormTemplate.setTemplateCode("test_template");
        Example<OnlFormTemplate> example = Example.of(onlFormTemplate);
        OnlFormTemplate template = templateRepository.findOne(example).orElse(null);
        System.out.println(JSONUtil.toJsonPrettyStr(template));
    }

}
