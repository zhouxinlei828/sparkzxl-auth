package com.github.sparkzxl.workflow.application.event;

import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import org.springframework.context.ApplicationEvent;

/**
 * description: 流程状态事件
 *
 * @author zhouxinlei
 * @since 2022-03-05 15:03:21
 */
public class ExtProcessTaskStatusEvent extends ApplicationEvent {

    public ExtProcessTaskStatusEvent(ExtProcessStatus source) {
        super(source);
    }
}
