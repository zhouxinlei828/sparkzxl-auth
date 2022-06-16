package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.application.service.ISysParameterService;
import com.github.sparkzxl.auth.infrastructure.entity.SysParameter;
import com.github.sparkzxl.auth.infrastructure.mapper.SysParameterMapper;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * description: 系统参数 服务实现类
 *
 * @author zhoux
 * @since 2021-06-13 12:07:45
 */
@Service
public class SysParameterServiceImpl extends SuperServiceImpl<SysParameterMapper, SysParameter> implements ISysParameterService {

    @Override
    public SysParameter getSysParameterByCode(String code) {
        return getOne(new LambdaQueryWrapper<SysParameter>().eq(SysParameter::getCode, code)
                .eq(SysParameter::getStatus, true).last("limit 1"));
    }
}
