package com.github.sparkzxl.workflow.domain.service.online;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormEnhanceJsService;
import com.github.sparkzxl.workflow.infrastructure.entity.OnlFormEnhanceJs;
import com.github.sparkzxl.workflow.infrastructure.mapper.OnlFormEnhanceJsMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * online表单js增强 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Service
public class OnlFormEnhanceJsServiceImpl extends SuperCacheServiceImpl<OnlFormEnhanceJsMapper, OnlFormEnhanceJs> implements IOnlFormEnhanceJsService {
    @Override
    protected String getRegion() {
        return "onl_form_enhance_js";
    }
}
