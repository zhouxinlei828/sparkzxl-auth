package com.github.sparkzxl.workflow.domain.service.online;

import com.alibaba.fastjson.JSONObject;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormTemplateService;
import com.github.sparkzxl.workflow.domain.repository.mongodb.OnlFormTemplateRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.mongodb.OnlFormTemplate;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 表单设计模板 服务实现类
 *
 * @author zhouxinlei
 * @date 2021-08-29 10:27:45
 */
@Service
public class OnlFormTemplateServiceImpl implements IOnlFormTemplateService {

    @Autowired
    private OnlFormTemplateRepository templateRepository;

    @Override
    public boolean saveTemplate(OnlFormTemplate template) {
        templateRepository.save(template);
        return true;
    }

    @Override
    public boolean updateTemplate(OnlFormTemplate template) {
        templateRepository.save(template);
        return true;
    }

    @Override
    public boolean deleteTemplate(Long templateId) {
        templateRepository.deleteById(templateId);
        return true;
    }

    @Override
    public boolean deleteTemplate(List<Long> templateIds) {
        templateRepository.deleteByIdIn(templateIds);
        return true;
    }

    @Override
    public OnlFormTemplate getTemplate(Long templateId) {
        return templateRepository.findById(templateId).orElse(null);
    }

    @Override
    public JSONObject getTemplateJson(String templateCode) {
        OnlFormTemplate template = new OnlFormTemplate();
        template.setTemplateCode(templateCode);
        Example<OnlFormTemplate> example = Example.of(template);
        OnlFormTemplate onlFormTemplate = templateRepository.findOne(example).orElse(null);
        if (ObjectUtils.isEmpty(onlFormTemplate)) {
            return null;
        }
        return JSONObject.parseObject(onlFormTemplate.getTemplateJson());
    }
}
