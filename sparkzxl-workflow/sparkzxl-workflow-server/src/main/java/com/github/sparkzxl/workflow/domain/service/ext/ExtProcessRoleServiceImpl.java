package com.github.sparkzxl.workflow.domain.service.ext;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessRoleService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessRole;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessRoleMapper;
import org.springframework.stereotype.Service;

/**
 * description: 流程角色 服务实现类
 *
 * @author charles.zhou
 * @date   2021-01-08 17:08:44
 */
@Service
public class ExtProcessRoleServiceImpl extends ServiceImpl<ExtProcessRoleMapper, ExtProcessRole> implements IExtProcessRoleService {

}
