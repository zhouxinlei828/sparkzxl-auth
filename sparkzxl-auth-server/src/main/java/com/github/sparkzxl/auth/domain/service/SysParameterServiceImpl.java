package com.github.sparkzxl.auth.domain.service;

import com.github.sparkzxl.auth.infrastructure.entity.SysParameter;
import com.github.sparkzxl.auth.infrastructure.mapper.SysParameterMapper;
import com.github.sparkzxl.auth.application.service.ISysParameterService;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import org.springframework.stereotype.Service;

/**
 * description: 系统参数 服务实现类
 *
 * @author zhoux
 * @date 2021-06-13 12:07:45
 */
@Service
public class SysParameterServiceImpl extends SuperCacheServiceImpl<SysParameterMapper, SysParameter> implements ISysParameterService {

    @Override
    protected String getRegion() {
        return "sys_parameter";
    }
}
