package com.github.sparkzxl.workflow.domain.service.online;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormButtonService;
import com.github.sparkzxl.workflow.infrastructure.entity.OnlFormButton;
import com.github.sparkzxl.workflow.infrastructure.mapper.OnlFormButtonMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * online表单自定义按钮 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Service
public class OnlFormButtonServiceImpl extends SuperCacheServiceImpl<OnlFormButtonMapper, OnlFormButton> implements IOnlFormButtonService {

    @Override
    protected String getRegion() {
        return "onl_form_button";
    }
}
