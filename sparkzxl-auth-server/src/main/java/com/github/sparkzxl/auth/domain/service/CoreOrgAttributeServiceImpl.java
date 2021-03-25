package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.sparkzxl.auth.application.service.ICoreOrgAttributeService;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrgAttribute;
import com.github.sparkzxl.auth.infrastructure.mapper.CoreOrgAttributeMapper;
import org.springframework.stereotype.Service;

/**
 * description: 组织属性 服务实现类
 *
 * @author charles.zhou
 * @date 2021-03-25 15:03:31
 */
@Service
public class CoreOrgAttributeServiceImpl extends ServiceImpl<CoreOrgAttributeMapper, CoreOrgAttribute> implements ICoreOrgAttributeService {

}
