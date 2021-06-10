package com.github.sparkzxl.auth.infrastructure.repository;


import com.github.sparkzxl.auth.AuthServerApplication;
import com.github.sparkzxl.auth.domain.repository.IAuthUserRepository;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.core.context.BaseContextHolder;
import com.github.sparkzxl.core.jackson.JsonUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @DisplayName("测试数据自动回显")
    @Test
    void selectByAccount() {
        BaseContextHolder.setRealm("6055fc0465a6f7ecf13fe03a");
        AuthUser authUser = authUserRepository.selectByAccount("zhouxinlei");
        System.out.println(JsonUtil.toJsonPretty(authUser));
    }
}
