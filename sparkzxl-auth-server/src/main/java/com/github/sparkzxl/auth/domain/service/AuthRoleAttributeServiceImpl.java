package com.github.sparkzxl.auth.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.sparkzxl.auth.application.service.IAuthRoleAttributeService;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRoleAttribute;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleAttributeMapper;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: 角色属性 服务实现类
 *
 * @author charles.zhou
 * @date 2021-03-24 15:52:53
 */
@Service
public class AuthRoleAttributeServiceImpl extends ServiceImpl<AuthRoleAttributeMapper, AuthRoleAttribute> implements IAuthRoleAttributeService {


    @Override
    public Map<Long, List<AuthRoleAttribute>> getRoleAttributeList(List<Long> roleIdList) {
        if (CollectionUtils.isNotEmpty(roleIdList)) {
            List<AuthRoleAttribute> roleAttributes = list(new LambdaQueryWrapper<AuthRoleAttribute>().in(AuthRoleAttribute::getRoleId, roleIdList));
            return roleAttributes.stream().collect(Collectors.groupingBy(AuthRoleAttribute::getRoleId));
        }
        return Maps.newHashMap();
    }
}
