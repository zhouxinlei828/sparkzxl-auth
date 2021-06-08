package com.github.sparkzxl.auth.application.event;

import cn.hutool.json.JSONUtil;
import com.github.sparkzxl.auth.domain.model.aggregates.ResourceSource;
import com.github.sparkzxl.auth.domain.repository.IRoleAuthorityRepository;
import com.github.sparkzxl.core.context.BaseContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * description: 权限资源变更事件监听，用于调整具体的业务
 *
 * @author charles.zhou
 * @date 2021-03-08 14:19:51
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RoleResourceListener {

    private IRoleAuthorityRepository roleAuthorityRepository;

    @Autowired
    public void setRoleAuthorityRepository(IRoleAuthorityRepository roleAuthorityRepository) {
        this.roleAuthorityRepository = roleAuthorityRepository;
    }

    @Async
    @EventListener({RoleResourceEvent.class})
    public void operationRoleResourceList(RoleResourceEvent event) {
        ResourceSource source = (ResourceSource) event.getSource();
        log.info("权限资源变更事件监听源：{}", JSONUtil.toJsonPrettyStr(source));
        String realm = BaseContextHolder.getRealm();
        switch (source.getOperation()) {
            case SAVE:
                roleAuthorityRepository.refreshAuthorityByRealmCode(source.getRealmCode());
                break;
            case DELETE:
                roleAuthorityRepository.refreshAuthority(source.getOldVal());
                break;
            case UPDATE:
                roleAuthorityRepository.refreshAuthority(source.getOldVal(), source.getNewVal());
                break;
            default:
                break;
        }
    }

}
