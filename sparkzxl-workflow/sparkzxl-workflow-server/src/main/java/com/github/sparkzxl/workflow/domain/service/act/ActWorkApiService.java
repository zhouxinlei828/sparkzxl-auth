package com.github.sparkzxl.workflow.domain.service.act;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.github.sparkzxl.core.util.ArgumentAssert;
import com.github.sparkzxl.workflow.application.service.act.IProcessRepositoryService;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.application.service.act.IProcessTaskService;
import com.github.sparkzxl.workflow.application.service.ext.IExtHiTaskStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessTaskRuleService;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteData;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessUserRepository;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.act.DeleteTaskCmd;
import com.github.sparkzxl.workflow.infrastructure.act.ExecutionVariableDeleteCmd;
import com.github.sparkzxl.workflow.infrastructure.act.SetFlowNodeAndGoCmd;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskRule;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.github.sparkzxl.workflow.infrastructure.enums.ProcessStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.enums.TaskStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.utils.ActivitiUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.*;
import org.activiti.engine.ManagementService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * description: 流程核心API接口
 *
 * @author charles.zhou
 * @date 2020-07-20 18:35:56
 */
@Service
@Slf4j
public class ActWorkApiService {

    @Autowired
    private IProcessTaskService processTaskService;
    @Autowired
    private IProcessRuntimeService processRuntimeService;
    @Autowired
    private IExtProcessStatusService processTaskStatusService;
    @Autowired
    private IExtHiTaskStatusService actHiTaskStatusService;
    @Autowired
    private IProcessRepositoryService repositoryService;
    @Autowired
    private ManagementService managementService;
    @Autowired
    private IExtProcessTaskRuleService processTaskRuleService;
    @Autowired
    private IExtProcessUserRepository processUserRepository;

    public DriverResult promoteProcess(ExecuteData executeData, Map<String, Object> variables) {
        String userId = executeData.getUserId();
        variables.put("actType", executeData.getActType());

        // 查询当前流程实例任务
        Task task = processTaskService.getLatestTaskByBusinessKey(executeData.getBusinessId());
        String currentTaskId = task.getId();
        String taskDefinitionKey = task.getTaskDefinitionKey();
        ArgumentAssert.notNull(task, "任务不能为空");

        // 校验审批权限
        validateAuthority(task, userId);
        //添加审核人
        Authentication.setAuthenticatedUserId(userId);
        if (StringUtils.isNotEmpty(executeData.getComment())) {
            processTaskService.addComment(currentTaskId, executeData.getProcessInstanceId(), executeData.getComment());
        }
        processTaskService.setAssignee(currentTaskId, userId);
        processTaskService.claimTask(currentTaskId, userId);
        processTaskService.completeTask(currentTaskId, variables);
        recordTaskStatus(executeData.getProcessInstanceId(), executeData.getActType(),
                currentTaskId, taskDefinitionKey);
        return recordProcessState(executeData);
    }

    /**
     * 记录流程状态
     *
     * @param executeData 流程驱动model
     * @return DriverResult
     */
    public DriverResult recordProcessState(ExecuteData executeData) {
        boolean processIsEnd = processRuntimeService.processIsEnd(executeData.getProcessInstanceId());
        String status;
        if (processIsEnd) {
            status = ProcessStatusEnum.END.getDesc();
        } else {
            status = ProcessStatusEnum.RUN_TIME.getDesc();
        }
        DriverResult driverResult = new DriverResult();
        driverResult.setProcessIsEnd(processIsEnd);
        log.info("记录当前任务流程状态 processInstanceId：{}，businessId：{}", executeData.getProcessInstanceId(), executeData.getBusinessId());
        ExtProcessStatus extProcessStatus = processTaskStatusService.getExtProcessStatus(executeData.getBusinessId(), executeData.getProcessInstanceId());
        //记录当前流程状态
        if (!ObjectUtils.isNotEmpty(extProcessStatus)) {
            extProcessStatus = new ExtProcessStatus();
            extProcessStatus.setProcessInstanceId(executeData.getProcessInstanceId());
            extProcessStatus.setBusinessId(executeData.getBusinessId());
            extProcessStatus.setProcessName(executeData.getProcessName());
        }
        extProcessStatus.setStatus(status);
        processTaskStatusService.saveOrUpdate(extProcessStatus);
        driverResult.setOperateSuccess(true);
        return driverResult;
    }

    public void recordTaskStatus(String processInstanceId, int actType, String currentTaskId,
                                 String taskDefinitionKey) {
        log.info("保存任务历史记录 processInstanceId：{}，taskId：{}", processInstanceId, currentTaskId);
        TaskStatusEnum taskStatusEnum = Objects.requireNonNull(TaskStatusEnum.get(actType));
        ExtHiTaskStatus actHiTaskStatus = new ExtHiTaskStatus();
        actHiTaskStatus.setProcessInstanceId(processInstanceId);
        actHiTaskStatus.setTaskId(currentTaskId);
        actHiTaskStatus.setTaskDefKey(taskDefinitionKey);
        actHiTaskStatus.setTaskStatus(taskStatusEnum.getCode());
        actHiTaskStatus.setTaskStatusName(taskStatusEnum.getDesc());
        actHiTaskStatusService.save(actHiTaskStatus);
    }


    @Transactional(rollbackFor = Exception.class)
    public DriverResult jumpProcess(ExecuteData executeData) {
        DriverResult driverResult = new DriverResult();
        try {
            String businessId = executeData.getBusinessId();
            String userId = executeData.getUserId();
            ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
            ArgumentAssert.notNull(processInstance, "流程实例为空，请检查参数是否正确");
            executeData.setProcessInstanceId(processInstance.getProcessInstanceId());
            String comment = executeData.getComment();
            Task currentTask = processTaskService.getLatestTaskByProInstId(processInstance.getProcessInstanceId());
            String currentTaskId = currentTask.getId();
            //添加审核人
            Authentication.setAuthenticatedUserId(userId);
            if (StringUtils.isNotEmpty(comment)) {
                processTaskService.addComment(currentTaskId, processInstance.getProcessInstanceId(), comment);
            }
            processTaskService.setAssignee(currentTaskId, userId);
            String taskDefinitionKey = currentTask.getTaskDefinitionKey();
            String processDefinitionId = currentTask.getProcessDefinitionId();
            BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
            // 获取流程定义
            Process process = bpmnModel.getMainProcess();
            //获取所有的FlowElement信息
            Collection<FlowElement> flowElements = process.getFlowElements();
            // 获取目标节点task定义key
            ExtProcessTaskRule actRuTaskRule = processTaskRuleService.findActRuTaskRule(executeData.getProcessDefinitionKey(),
                    taskDefinitionKey, executeData.getActType());
            ArgumentAssert.notNull(actRuTaskRule, "流程规则为空，请检查参数是否正确");
            String taskDefKey = actRuTaskRule.getTaskDefKey();
            FlowElement flowElement = ActivitiUtils.getFlowElementById(taskDefKey, flowElements);
            // 获取目标节点定义
            assert flowElement != null;
            FlowNode targetNode = (FlowNode) process.getFlowElement(flowElement.getId());
            // 删除当前运行任务，同时返回执行id，该id在并发情况下也是唯一的
            String executionEntityId = managementService.executeCommand(new DeleteTaskCmd(currentTaskId));
            //删除变量
            managementService.executeCommand(new ExecutionVariableDeleteCmd(executionEntityId));
            // 流程执行到来源节点
            managementService.executeCommand(new SetFlowNodeAndGoCmd(targetNode, executionEntityId));
            recordTaskStatus(executeData.getProcessInstanceId(), executeData.getActType(),
                    currentTaskId, taskDefinitionKey);
            return recordProcessState(executeData);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            driverResult.setErrorMsg(e.getMessage());
            log.error("发生异常 Exception：{}", ExceptionUtil.getMessage(e));
        }
        return driverResult;
    }

    @Transactional(rollbackFor = Exception.class)
    public DriverResult submitProcess(ExecuteData executeData) {
        DriverResult driverResult = new DriverResult();
        String businessId = executeData.getBusinessId();
        try {
            String nextTaskApproveUserId = executeData.getNextTaskApproveUserId();
            Map<String, Object> variables = executeData.getVariables();
            if (StringUtils.isNotEmpty(nextTaskApproveUserId)) {
                variables.put("assignee", nextTaskApproveUserId);
            }
            ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
            ArgumentAssert.notNull(processInstance, "流程实例为空，请检查参数是否正确");
            executeData.setProcessInstanceId(processInstance.getProcessInstanceId());
            driverResult = promoteProcess(executeData, variables);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("发生异常 Exception：{}", ExceptionUtil.getMessage(e));
            driverResult.setErrorMsg(e.getMessage());
        }
        return driverResult;
    }


    private void validateAuthority(Task task, String userId) {
        FlowElement flowElement = getThisNodeByInsId(task);
        if (flowElement instanceof UserTask) {
            List<String> listGroup = ((UserTask) flowElement).getCandidateGroups();
            if (listGroup.size() == 0) {
                return;
            }
            //遍历所有组
            List<String> userIdList = processUserRepository.findUserIdListByRoleIds(listGroup);
            if (userIdList.contains(userId)) {
                return;
            }
        }
        ExtProcessUser extProcessUser = processUserRepository.findUserById(userId);
        ExceptionAssert.failure("当前节点审批人[" + extProcessUser.getName() + "]无权限审批！");
    }

    private FlowElement getThisNodeByInsId(Task task) {
        BpmnModel bpmnModel = repositoryService.getBpmnModel(task.getProcessDefinitionId());
        // 获取流程定义
        Process process = bpmnModel.getMainProcess();
        //获取所有的FlowElement信息
        Collection<FlowElement> flowElements = process.getFlowElements();
        return ActivitiUtils.getFlowElementById(task.getTaskDefinitionKey(), flowElements);
    }

}
