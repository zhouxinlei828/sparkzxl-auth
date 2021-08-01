package com.github.sparkzxl.workflow.domain.service.online;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormIndexService;
import com.github.sparkzxl.workflow.infrastructure.entity.OnlFormIndex;
import com.github.sparkzxl.workflow.infrastructure.mapper.OnlFormIndexMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * online表单索引 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Service
public class OnlFormIndexServiceImpl extends SuperCacheServiceImpl<OnlFormIndexMapper, OnlFormIndex> implements IOnlFormIndexService {
    @Override
    protected String getRegion() {
        return "onl_form_index";
    }
}
