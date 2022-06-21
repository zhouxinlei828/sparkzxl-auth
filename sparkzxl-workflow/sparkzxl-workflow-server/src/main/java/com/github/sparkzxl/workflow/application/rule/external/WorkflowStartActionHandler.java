package com.github.sparkzxl.workflow.application.rule.external;

import com.github.sparkzxl.core.util.ArgumentAssert;
import com.github.sparkzxl.lock.annotation.DistributedLock;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteData;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteProcess;
import com.github.sparkzxl.workflow.domain.service.act.ActWorkApiService;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowActionConstants;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Map;

/**
 * description: 启动工作流业务处理器
 *
 * @author zhouxinlei
 * @since 2022-03-05 14:19:27
 */
@Component
@Slf4j
public class WorkflowStartActionHandler implements IWorkflowActionHandler {

    @Autowired
    private ActWorkApiService actWorkApiService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private IProcessRuntimeService processRuntimeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DistributedLock(keys = {"#p0.businessId", "#p0.actType"}, expire = 15000, acquireTimeout = 200)
    public DriverResult execute(ExecuteProcess executeProcess) {
        log.info("流程启动业务处理：actType:[{}],businessId:[{}]", executeProcess.getActType(), executeProcess.getBusinessId());
        DriverResult driverResult = new DriverResult();
        String businessId = executeProcess.getBusinessId();
        try {
            String userId = executeProcess.getUserId();
            //查询是否存在已有流程，如果有，则不能进行启动工作流操作
            ProcessInstance originalProcessInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
            ArgumentAssert.isNull(originalProcessInstance, "流程已存在，请勿重复启动");
            Map<String, Object> variables = Maps.newHashMap();
            variables.put("assignee", executeProcess.getNextTaskApproveUserId());
            variables.put("actType", executeProcess.getActType());
            identityService.setAuthenticatedUserId(String.valueOf(userId));
            ProcessInstance processInstance = processRuntimeService.startProcessInstanceByKey(executeProcess.getProcessDefinitionKey(),
                    businessId,
                    variables);
            String processInstanceId = processInstance.getProcessInstanceId();
            String comment = executeProcess.getComment();
            if (StringUtils.isEmpty(comment)) {
                comment = "开始节点跳过";
            }
            String processName = "【".concat(userId).concat("】发起").concat(processInstance.getProcessDefinitionName());
            log.info("启动activiti流程------++++++ProcessInstanceId：{}------++++++processName：{}", processInstanceId, processName);
            executeProcess.setProcessName(processName);
            executeProcess.setProcessInstanceId(processInstanceId);
            executeProcess.setProcessDefinitionKey(processInstance.getProcessDefinitionKey());
            executeProcess.setComment(comment);
            boolean needJump = executeProcess.isNeedJump();
            if (needJump) {
                ExecuteData executeData = assemblyData(executeProcess, WorkflowActionConstants.JUMP, processInstanceId, processName);
                driverResult = actWorkApiService.jumpProcess(executeData);
            } else {
                ExecuteData executeData = assemblyData(executeProcess, WorkflowActionConstants.SUBMIT, processInstanceId, processName);
                driverResult = actWorkApiService.promoteProcess(executeData, variables);
            }
        } catch (Exception e) {
            driverResult.setErrorMsg(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("发生异常 Exception：", e);
        }
        return driverResult;
    }

    private ExecuteData assemblyData(ExecuteProcess executeProcess, int actType, String processInstanceId, String processName) {
        return ExecuteData.builder()
                .businessId(executeProcess.getBusinessId())
                .processName(processName)
                .processInstanceId(processInstanceId)
                .processDefinitionKey(executeProcess.getProcessDefinitionKey())
                .actType(actType)
                .userId(executeProcess.getUserId())
                .comment(executeProcess.getComment())
                .variables(executeProcess.getVariables())
                .build();
    }

    @Override
    public int getActionType() {
        return WorkflowActionConstants.START;
    }
}
