package com.github.sparkzxl.workflow.application.rule.external;

import com.github.sparkzxl.redisson.annotation.RedisLock;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteProcess;
import com.github.sparkzxl.workflow.domain.service.act.ActWorkApiService;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description: 结束工作流业务处理器
 *
 * @author zhouxinlei
 * @since 2022-03-05 14:19:27
 */
@Component
@Slf4j
public class WorkflowEndActionHandler implements IWorkflowActionHandler {

    @Autowired
    private ActWorkApiService actWorkApiService;

    @Override
    @RedisLock(prefix = "act_driver")
    public DriverResult execute(ExecuteProcess executeProcess) {
        log.info("流程结束业务处理：actType:[{}],businessId:[{}]", executeProcess.getActType(), executeProcess.getBusinessId());
        return actWorkApiService.submitProcess(executeProcess);
    }

    @Override
    public int getActionType() {
        return WorkflowConstants.WorkflowAction.END;
    }
}
