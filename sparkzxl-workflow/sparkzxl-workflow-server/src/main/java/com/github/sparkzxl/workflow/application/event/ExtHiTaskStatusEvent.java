package com.github.sparkzxl.workflow.application.event;

import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import org.springframework.context.ApplicationEvent;

/**
 * description: 流程任务状态事件
 *
 * @author zhouxinlei
 * @since 2022-03-05 15:03:35
 */
public class ExtHiTaskStatusEvent extends ApplicationEvent {

    public ExtHiTaskStatusEvent(ExtHiTaskStatus source) {
        super(source);
    }
}
