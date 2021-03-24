package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.sparkzxl.auth.application.service.IAuthUserAttributeService;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUserAttribute;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthUserAttributeMapper;
import org.springframework.stereotype.Service;

/**
 * description: 用户属性 服务实现类
 *
 * @author charles.zhou
 * @date 2021-03-24 15:53:19
 */
@Service
public class AuthUserAttributeServiceImpl extends ServiceImpl<AuthUserAttributeMapper, AuthUserAttribute> implements IAuthUserAttributeService {

}
