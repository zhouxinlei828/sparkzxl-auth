package com.github.sparkzxl.auth.application.event;

import com.github.sparkzxl.auth.application.service.IRoleAuthorityService;
import com.github.sparkzxl.core.context.RequestLocalContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * description: 初始化角色资源加载类
 *
 * @author charles.zhou
 * @date 2020-08-02 22:10:40
 */
@Component
public class InitRolePathApplicationRunner implements CommandLineRunner, Ordered {

    private IRoleAuthorityService roleAuthorityService;

    @Autowired
    public void setRoleAuthorityService(IRoleAuthorityService roleAuthorityService) {
        this.roleAuthorityService = roleAuthorityService;
    }

    @Override
    public void run(String... args) {
        RequestLocalContextHolder.setTenant("hz");
        roleAuthorityService.refreshAuthorityList();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
