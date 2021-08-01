package com.github.sparkzxl.workflow.domain.service.online;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.online.IOnlFormTableService;
import com.github.sparkzxl.workflow.infrastructure.entity.OnlFormTable;
import com.github.sparkzxl.workflow.infrastructure.mapper.OnlFormTableMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * online表单table 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-08-01
 */
@Service
public class OnlFormTableServiceImpl extends SuperCacheServiceImpl<OnlFormTableMapper, OnlFormTable> implements IOnlFormTableService {
    @Override
    protected String getRegion() {
        return "onl_form_table";
    }
}
