package com.github.sparkzxl.workflow.domain.service.online;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormEnhanceSqlService;
import com.github.sparkzxl.workflow.infrastructure.entity.OnlFormEnhanceSql;
import com.github.sparkzxl.workflow.infrastructure.mapper.OnlFormEnhanceSqlMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * online表单sql增强 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Service
public class OnlFormEnhanceSqlServiceImpl extends SuperCacheServiceImpl<OnlFormEnhanceSqlMapper, OnlFormEnhanceSql> implements IOnlFormEnhanceSqlService {
    @Override
    protected String getRegion() {
        return "onl_form_enhance_sql";
    }
}
