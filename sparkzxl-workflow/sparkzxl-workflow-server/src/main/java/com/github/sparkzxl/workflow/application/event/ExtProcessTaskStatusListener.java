package com.github.sparkzxl.workflow.application.event;

import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * description: 流程任务状态监听
 *
 * @author zhouxinlei
 * @since 2022-03-05 15:26:35
 */
@Component
@Slf4j
public class ExtProcessTaskStatusListener {


    @Autowired
    private IExtProcessStatusService extProcessStatusService;

    @Async
    @EventListener({ExtProcessTaskStatusEvent.class})
    public void saveExtHiTaskStatus(ExtProcessTaskStatusEvent event) {
        ExtProcessStatus extProcessStatus = (ExtProcessStatus) event.getSource();
        log.info("记录当前任务流程状态 processInstanceId：{}，businessId：{}", extProcessStatus.getProcessInstanceId(), extProcessStatus.getBusinessId());
        ExtProcessStatus newExtProcessStatus =
                extProcessStatusService.getExtProcessStatus(extProcessStatus.getBusinessId(), extProcessStatus.getProcessInstanceId());
        if (!ObjectUtils.isNotEmpty(newExtProcessStatus)) {
            newExtProcessStatus = new ExtProcessStatus();
            newExtProcessStatus.setProcessInstanceId(extProcessStatus.getProcessInstanceId());
            newExtProcessStatus.setBusinessId(extProcessStatus.getBusinessId());
            newExtProcessStatus.setProcessName(extProcessStatus.getProcessName());
        }
        newExtProcessStatus.setStatus(extProcessStatus.getStatus());
        extProcessStatusService.saveOrUpdate(newExtProcessStatus);

    }
}
