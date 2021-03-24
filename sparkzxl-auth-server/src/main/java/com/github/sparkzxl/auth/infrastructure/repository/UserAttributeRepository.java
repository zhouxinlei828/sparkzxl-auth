package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.domain.repository.IUserAttributeRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUserAttribute;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthUserAttributeMapper;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: 用户属性 仓储实现类
 *
 * @author charles.zhou
 * @date 2021-03-24 16:23:29
 */
@Repository
public class UserAttributeRepository implements IUserAttributeRepository {

    private AuthUserAttributeMapper userAttributeMapper;

    @Autowired
    public void setUserAttributeMapper(AuthUserAttributeMapper userAttributeMapper) {
        this.userAttributeMapper = userAttributeMapper;
    }

    @Override
    public Map<Long, List<AuthUserAttribute>> findUserAttributeMapList(List<Long> userIdList) {
        if (CollectionUtils.isNotEmpty(userIdList)) {
            List<AuthUserAttribute> authUserAttributes = userAttributeMapper.selectList(new LambdaQueryWrapper<AuthUserAttribute>()
                    .in(AuthUserAttribute::getUserId, userIdList));
            if (CollectionUtils.isNotEmpty(authUserAttributes)) {
                return authUserAttributes.stream().collect(Collectors.groupingBy(AuthUserAttribute::getUserId));
            }
        }
        return Maps.newHashMap();
    }
}
