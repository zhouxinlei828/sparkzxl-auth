package com.github.sparkzxl.auth.application.service;

import com.github.sparkzxl.auth.infrastructure.entity.SysParameter;
import com.github.sparkzxl.database.base.service.SuperService;

/**
 * description: 系统参数 服务类
 *
 * @author zhoux
 * @since 2021-06-13 12:06:56
 */
public interface ISysParameterService extends SuperService<SysParameter> {

    /**
     * 根据code查询系统参数
     *
     * @param code 参数code
     * @return SysParameter
     */
    SysParameter getSysParameterByCode(String code);
}
