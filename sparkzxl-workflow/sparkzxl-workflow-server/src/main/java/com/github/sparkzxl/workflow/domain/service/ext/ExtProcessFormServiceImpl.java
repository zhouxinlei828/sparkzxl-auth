package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessFormService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessForm;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessFormMapper;
import org.springframework.stereotype.Service;

/**
 * description: 流程表单 服务实现类
 *
 * @author charles.zhou
 * @date 2021-03-25 18:02:09
 */
@Service
public class ExtProcessFormServiceImpl extends SuperCacheServiceImpl<ExtProcessFormMapper, ExtProcessForm> implements IExtProcessFormService {

    @Override
    protected String getRegion() {
        return "process_form";
    }

}
