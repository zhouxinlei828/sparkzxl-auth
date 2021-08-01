package com.github.sparkzxl.workflow.domain.service.online;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormDesignService;
import com.github.sparkzxl.workflow.infrastructure.entity.OnlFormDesign;
import com.github.sparkzxl.workflow.infrastructure.mapper.OnlFormDesignMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 表单设计 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Service
public class OnlFormDesignServiceImpl extends SuperCacheServiceImpl<OnlFormDesignMapper, OnlFormDesign> implements IOnlFormDesignService {
    @Override
    protected String getRegion() {
        return "onl_form_design";
    }
}
