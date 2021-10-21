package com.github.sparkzxl.auth.infrastructure.repository;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.auth.AuthServerApplication;
import com.github.sparkzxl.auth.domain.repository.IAuthUserRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.RoleAuthority;
import com.github.sparkzxl.auth.infrastructure.enums.AuthorityTypeEnum;
import com.github.sparkzxl.auth.infrastructure.mapper.RoleAuthorityMapper;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.core.jackson.JsonUtil;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-06-09 17:18
 */
@SpringBootTest(classes = {AuthServerApplication.class}, properties = {"spring.profiles.active=dev"})
class AuthUserRepositoryTest {

    @Autowired
    private IAuthUserRepository authUserRepository;
    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @DisplayName("测试数据自动回显")
    @Test
    void selectByAccount() {
        BaseContextHolder.setTenant("6055fc0465a6f7ecf13fe03a");
        AuthUser authUser = authUserRepository.selectByAccount("zhouxinlei");
        System.out.println(JsonUtil.toJsonPretty(authUser));
    }

    @DisplayName("测试数据")
    @Test
    void test() {
        List<Long> roleIds = Lists.newArrayList(100L);
        BaseContextHolder.setTenant("hz");
        LambdaQueryWrapper<RoleAuthority> roleAuthorityLambdaQueryWrapper = new LambdaQueryWrapper<RoleAuthority>()
                .in(RoleAuthority::getRoleId, roleIds)
                .eq(RoleAuthority::getAuthorityType, AuthorityTypeEnum.RESOURCE.name())
                .groupBy(RoleAuthority::getAuthorityId, RoleAuthority::getRoleId);
        List<RoleAuthority> roleAuthorities =
                roleAuthorityMapper.selectList(roleAuthorityLambdaQueryWrapper);
        System.out.println(JsonUtil.toJsonPretty(roleAuthorities));
    }

}
