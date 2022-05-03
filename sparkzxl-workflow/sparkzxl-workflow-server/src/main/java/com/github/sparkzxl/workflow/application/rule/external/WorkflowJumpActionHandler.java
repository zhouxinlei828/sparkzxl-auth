package com.github.sparkzxl.workflow.application.rule.external;

import com.github.sparkzxl.lock.annotation.DistributedLock;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteData;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteProcess;
import com.github.sparkzxl.workflow.domain.service.act.ActWorkApiService;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowActionConstants;
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
    @DistributedLock(keys = {"#p0.businessId","#p0.actType"})
    public DriverResult execute(ExecuteProcess executeProcess) {
        log.info("流程跳转业务处理：actType:[{}],businessId:[{}]", executeProcess.getActType(), executeProcess.getBusinessId());
        ExecuteData executeData = assemblyData(executeProcess);
        return actWorkApiService.jumpProcess(executeData);
    }

    private ExecuteData assemblyData(ExecuteProcess executeProcess) {
        return ExecuteData.builder()
                .businessId(executeProcess.getBusinessId())
                .processDefinitionKey(executeProcess.getProcessDefinitionKey())
                .actType(executeProcess.getActType())
                .userId(executeProcess.getUserId())
                .comment(executeProcess.getComment())
                .variables(executeProcess.getVariables())
                .build();
    }

    @Override
    public int getActionType() {
        return WorkflowActionConstants.JUMP;
    }
}
