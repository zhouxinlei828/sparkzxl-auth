package com.github.sparkzxl.auth.application.event;

import com.github.sparkzxl.auth.domain.model.aggregates.ResourceSource;
import org.springframework.context.ApplicationEvent;

/**
 * description: 角色资源事件
 *
 * @author charles.zhou
 * @date 2021-03-08 14:13:18
 */
public class RoleResourceEvent extends ApplicationEvent {

    public RoleResourceEvent(ResourceSource source) {
        super(source);
    }
}
