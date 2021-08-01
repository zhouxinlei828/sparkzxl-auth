package com.github.sparkzxl.workflow.domain.service.online;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormTemplateService;
import com.github.sparkzxl.workflow.infrastructure.entity.OnlFormTemplate;
import com.github.sparkzxl.workflow.infrastructure.mapper.OnlFormTemplateMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 表单设计模板 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Service
public class OnlFormTemplateServiceImpl extends SuperCacheServiceImpl<OnlFormTemplateMapper, OnlFormTemplate> implements IOnlFormTemplateService {
    @Override
    protected String getRegion() {
        return "onl_form_template";
    }
}
