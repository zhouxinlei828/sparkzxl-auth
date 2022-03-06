package com.github.sparkzxl.workflow.application.rule.external;

import com.github.sparkzxl.redisson.annotation.RedisLock;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteProcess;
import com.github.sparkzxl.workflow.domain.service.act.ActWorkApiService;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowActionConstants;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description: 启动工作流业务处理器
 *
 * @author zhouxinlei
 * @since 2022-03-05 14:19:27
 */
@Component
@Slf4j
public class WorkflowJumpActionHandler implements IWorkflowActionHandler {

    @Autowired
    private ActWorkApiService actWorkApiService;

    @Override
    @RedisLock(prefix = "act_driver")
    public DriverResult execute(ExecuteProcess executeProcess) {
        log.info("流程跳转业务处理：actType:[{}],businessId:[{}]", executeProcess.getActType(), executeProcess.getBusinessId());
        return actWorkApiService.jumpProcess(executeProcess, null);
    }

    @Override
    public int getActionType() {
        return WorkflowActionConstants.JUMP;
    }
}
