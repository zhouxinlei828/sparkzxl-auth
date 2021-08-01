package com.github.sparkzxl.workflow.domain.service.online;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormFieldService;
import com.github.sparkzxl.workflow.infrastructure.entity.OnlFormField;
import com.github.sparkzxl.workflow.infrastructure.mapper.OnlFormFieldMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * online表单字段 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Service
public class OnlFormFieldServiceImpl extends SuperCacheServiceImpl<OnlFormFieldMapper, OnlFormField> implements IOnlFormFieldService {
    @Override
    protected String getRegion() {
        return "onl_form_field";
    }
}
