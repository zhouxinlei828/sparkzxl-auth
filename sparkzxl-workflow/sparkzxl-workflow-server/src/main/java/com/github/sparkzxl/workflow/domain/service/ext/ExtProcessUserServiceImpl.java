package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessUserService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessUserMapper;
import org.springframework.stereotype.Service;

/**
 * description: 流程用户信息 服务实现类
 *
 * @author charles.zhou
 * @date 2021-01-08 17:09:59
 */
@Service
public class ExtProcessUserServiceImpl extends SuperCacheServiceImpl<ExtProcessUserMapper, ExtProcessUser> implements IExtProcessUserService {

    @Override
    protected String getRegion() {
        return "ext_process_user";
    }
}
