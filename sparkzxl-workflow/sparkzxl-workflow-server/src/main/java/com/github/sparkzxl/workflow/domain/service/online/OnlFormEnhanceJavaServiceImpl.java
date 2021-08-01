package com.github.sparkzxl.workflow.domain.service.online;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormEnhanceJavaService;
import com.github.sparkzxl.workflow.infrastructure.entity.OnlFormEnhanceJava;
import com.github.sparkzxl.workflow.infrastructure.mapper.OnlFormEnhanceJavaMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * online表单java增强 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Service
public class OnlFormEnhanceJavaServiceImpl extends SuperCacheServiceImpl<OnlFormEnhanceJavaMapper, OnlFormEnhanceJava> implements IOnlFormEnhanceJavaService {
    @Override
    protected String getRegion() {
        return "onl_form_enhance_java";
    }
}
