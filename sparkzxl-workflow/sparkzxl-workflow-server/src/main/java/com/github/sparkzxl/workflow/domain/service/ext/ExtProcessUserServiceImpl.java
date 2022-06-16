package com.github.sparkzxl.workflow.domain.service.ext;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessUserService;
import com.github.sparkzxl.workflow.domain.model.dto.user.ProcessUserQueryDTO;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 流程用户信息 服务实现类
 *
 * @author charles.zhou
 * @since 2021-01-08 17:09:59
 */
@Service
public class ExtProcessUserServiceImpl extends SuperServiceImpl<ExtProcessUserMapper, ExtProcessUser> implements IExtProcessUserService {

    @Override
    public List<ExtProcessUser> userList(ProcessUserQueryDTO userQueryDTO) {
        LambdaQueryWrapper<ExtProcessUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(userQueryDTO.getAccount())) {
            lambdaQueryWrapper.eq(ExtProcessUser::getAccount, userQueryDTO.getAccount());
        }
        if (StringUtils.isNotBlank(userQueryDTO.getName())) {
            lambdaQueryWrapper.eq(ExtProcessUser::getName, userQueryDTO.getName());
        }
        lambdaQueryWrapper.orderByAsc(ExtProcessUser::getId);
        return list(lambdaQueryWrapper);
    }
}
