package com.github.sparkzxl.workflow.application.rule.external;

import com.github.sparkzxl.redisson.annotation.RedisLock;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteData;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteProcess;
import com.github.sparkzxl.workflow.domain.service.act.ActWorkApiService;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowActionConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description: 提交工作流业务处理器
 *
 * @author zhouxinlei
 * @since 2022-03-06 15:51:26
 */
@Component
@Slf4j
public class WorkflowSubmitActionHandler implements IWorkflowActionHandler {

    @Autowired
    private ActWorkApiService actWorkApiService;

    @Override
    @RedisLock(prefix = "act_driver")
    public DriverResult execute(ExecuteProcess executeProcess) {
        log.info("流程提交业务处理：actType:[{}],businessId:[{}]", executeProcess.getActType(), executeProcess.getBusinessId());
        ExecuteData executeData = assemblyData(executeProcess);
        return actWorkApiService.submitProcess(executeData);
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
        return WorkflowActionConstants.SUBMIT;
    }
}
