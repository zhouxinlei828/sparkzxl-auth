package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.sparkzxl.auth.application.service.IAuthRoleAttributeService;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRoleAttribute;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleAttributeMapper;
import org.springframework.stereotype.Service;

/**
 * description: 角色属性 服务实现类
 *
 * @author charles.zhou
 * @date 2021-03-24 15:52:53
 */
@Service
public class AuthRoleAttributeServiceImpl extends ServiceImpl<AuthRoleAttributeMapper, AuthRoleAttribute> implements IAuthRoleAttributeService {

}
