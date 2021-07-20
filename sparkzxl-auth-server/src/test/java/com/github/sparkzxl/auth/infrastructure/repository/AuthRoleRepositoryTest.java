package com.github.sparkzxl.auth.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.auth.AuthServerApplication;
import com.github.sparkzxl.auth.infrastructure.entity.AuthRole;
import com.github.sparkzxl.auth.infrastructure.mapper.AuthRoleMapper;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.core.jackson.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-07-20 10:55
 */
@SpringBootTest(classes = {AuthServerApplication.class}, properties = {"spring.profiles.active=dev"})
class AuthRoleRepositoryTest {

    @Autowired
    private AuthRoleMapper authRoleMapper;

    @DisplayName("测试角色数据")
    @Test
    void test() {
        String code = null;
        String name = "管理员";
        BaseContextHolder.setTenant("hz");
        LambdaUpdateWrapper<AuthRole> roleLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        roleLambdaUpdateWrapper.eq(StringUtils.isNotEmpty(code), AuthRole::getCode, code)
                .likeRight(StringUtils.isNotEmpty(name), AuthRole::getName, name);
        List<AuthRole> roleList = authRoleMapper.selectList(roleLambdaUpdateWrapper);
        System.out.println(JsonUtil.toJsonPretty(roleList));
    }

}