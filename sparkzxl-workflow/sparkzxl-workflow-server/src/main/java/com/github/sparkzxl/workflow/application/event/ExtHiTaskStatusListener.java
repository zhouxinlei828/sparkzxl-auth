package com.github.sparkzxl.workflow.application.event;

import com.github.sparkzxl.workflow.application.service.ext.IExtHiTaskStatusService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * description: 历史任务状态监听
 *
 * @author zhouxinlei
 * @since 2022-03-05 15:26:35
 */
@Component
@Slf4j
public class ExtHiTaskStatusListener {


    @Autowired
    private IExtHiTaskStatusService extHiTaskStatusService;

    @Async
    @EventListener({ExtHiTaskStatusEvent.class})
    public void saveExtHiTaskStatus(ExtHiTaskStatusEvent event) {
        ExtHiTaskStatus extHiTaskStatus = (ExtHiTaskStatus) event.getSource();
        log.info("保存任务历史记录 processInstanceId：{}，taskId：{}", extHiTaskStatus.getProcessInstanceId(), extHiTaskStatus.getTaskId());
        extHiTaskStatusService.save(extHiTaskStatus);
    }
}
