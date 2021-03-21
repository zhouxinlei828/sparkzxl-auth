package com.github.sparkzxl.workflow.domain.service.act;

import com.github.sparkzxl.core.support.ResponseResultStatus;
import com.github.sparkzxl.core.support.SparkZxlExceptionAssert;
import com.github.sparkzxl.workflow.application.service.act.IProcessRepositoryService;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.application.service.act.IProcessTaskService;
import com.github.sparkzxl.workflow.application.service.ext.IExtHiTaskStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessTaskRuleService;
import com.github.sparkzxl.workflow.domain.model.DriverData;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.act.DeleteTaskCmd;
import com.github.sparkzxl.workflow.infrastructure.act.SetFlowNodeAndGoCmd;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskRule;
import com.github.sparkzxl.workflow.infrastructure.enums.ProcessStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.enums.TaskStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.utils.ActivitiUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.ManagementService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * description: 流程核心API接口
 *
 * @author charles.zhou
 * @date   2020-07-20 18:35:56
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
    private IProcessTaskService taskService;
    @Autowired
    private IProcessRepositoryService repositoryService;
    @Autowired
    private ManagementService managementService;
    @Autowired
    private IExtProcessTaskRuleService processTaskRuleService;

    public DriverResult promoteProcess(DriverData driverData) {
        String processInstanceId = driverData.getProcessInstanceId();
        String comment = driverData.getComment();
        String userId = driverData.getUserId();
        Map<String, Object> variables = driverData.getVariables();
        Task task = processTaskService.getLatestTaskByProInstId(processInstanceId);
        String currentTaskId = task.getId();
        String taskDefinitionKey = task.getTaskDefinitionKey();
        ResponseResultStatus.FAILURE.assertNotNull(task);
        //添加审核人
        Authentication.setAuthenticatedUserId(userId);
        if (StringUtils.isNotEmpty(comment)) {
            processTaskService.addComment(currentTaskId, processInstanceId, comment);
        }
        processTaskService.setAssignee(currentTaskId, userId);
        processTaskService.claimTask(currentTaskId, userId);
        processTaskService.completeTask(currentTaskId, variables);
        return recordProcessState(processInstanceId, driverData.getBusinessId(), driverData.getActType(), currentTaskId, taskDefinitionKey);
    }

    /**
     * 记录流程状态
     *
     * @param processInstanceId 流程实例id
     * @param businessId        业务主键
     * @param actType           流程动作类型
     * @param currentTaskId     任务id
     * @param taskDefinitionKey 任务定义key
     * @return DriverResult
     */
    public DriverResult recordProcessState(String processInstanceId, String businessId,
                                           int actType, String currentTaskId,
                                           String taskDefinitionKey) {
        boolean processIsEnd = processRuntimeService.processIsEnd(processInstanceId);
        String status;
        String taskStatus;
        if (WorkflowConstants.WorkflowAction.ROLLBACK == actType) {
            status = ProcessStatusEnum.getValue(actType);
            taskStatus = TaskStatusEnum.getValue(actType);
        } else if (processIsEnd) {
            status = ProcessStatusEnum.END.getDesc();
            taskStatus = TaskStatusEnum.AGREE.getDesc();
        } else {
            status = ProcessStatusEnum.RUN_TIME.getDesc();
            taskStatus = TaskStatusEnum.AGREE.getDesc();
        }
        DriverResult driverResult = new DriverResult();
        driverResult.setProcessIsEnd(processIsEnd);
        CompletableFuture.runAsync(() -> saveProcessTaskStatus(
                processInstanceId,
                businessId,
                status));
        CompletableFuture.runAsync(() -> saveExtHiTaskStatus(processInstanceId,
                currentTaskId, taskDefinitionKey, taskStatus));
        driverResult.setOperateSuccess(true);
        return driverResult;
    }

    public DriverResult jumpProcess(DriverData driverData) {
        String processInstanceId = driverData.getProcessInstanceId();
        String userId = driverData.getUserId();
        String comment = driverData.getComment();
        Task currentTask = taskService.getLatestTaskByProInstId(processInstanceId);
        String currentTaskId = currentTask.getId();
        //添加审核人
        Authentication.setAuthenticatedUserId(userId);
        if (StringUtils.isNotEmpty(comment)) {
            processTaskService.addComment(currentTaskId, processInstanceId, comment);
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
        ExtProcessTaskRule actRuTaskRule = processTaskRuleService.findActRuTaskRule(driverData.getProcessDefinitionKey(),
                taskDefinitionKey, driverData.getActType());
        DriverResult driverResult;
        if (ObjectUtils.isEmpty(actRuTaskRule)) {
            SparkZxlExceptionAssert.businessFail("请设置流程跳转规则");
        }
        String taskDefKey = actRuTaskRule.getTaskDefKey();
        FlowElement flowElement = ActivitiUtils.getFlowElementById(taskDefKey, flowElements);
        // 获取目标节点定义
        assert flowElement != null;
        FlowNode targetNode = (FlowNode) process.getFlowElement(flowElement.getId());
        // 删除当前运行任务，同时返回执行id，该id在并发情况下也是唯一的
        String executionEntityId = managementService.executeCommand(new DeleteTaskCmd(currentTaskId));
        // 流程执行到来源节点
        managementService.executeCommand(new SetFlowNodeAndGoCmd(targetNode, executionEntityId));
        driverResult = recordProcessState(processInstanceId, driverData.getBusinessId(), driverData.getActType(), currentTaskId, taskDefinitionKey);
        return driverResult;
    }

    /**
     * 保存任务历史记录
     *
     * @param processInstanceId 流程实例id
     * @param taskId            任务id
     * @param taskDefinitionKey 任务定义key
     * @param taskStatus        任务状态
     */
    public void saveExtHiTaskStatus(String processInstanceId, String taskId,
                                    String taskDefinitionKey, String taskStatus) {
        log.info("保存任务历史记录 processInstanceId：{}，taskId：{}", processInstanceId, taskId);
        ExtHiTaskStatus actHiTaskStatus = new ExtHiTaskStatus();
        actHiTaskStatus.setProcessInstanceId(processInstanceId);
        actHiTaskStatus.setTaskId(taskId);
        actHiTaskStatus.setTaskDefKey(taskDefinitionKey);
        actHiTaskStatus.setTaskStatus(taskStatus);
        actHiTaskStatusService.save(actHiTaskStatus);
    }

    /**
     * 记录当前任务流程状态
     *
     * @param processInstanceId 流程实例id
     * @param status            流程状态
     */
    public void saveProcessTaskStatus(String processInstanceId, String businessId, String status) {
        log.info("记录当前任务流程状态 processInstanceId：{}，businessId：{}", processInstanceId, businessId);
        ExtProcessStatus extProcessStatus = processTaskStatusService.getExtProcessStatus(businessId, processInstanceId);
        //记录当前任务流程状态
        if (ObjectUtils.isNotEmpty(extProcessStatus)) {
            extProcessStatus.setStatus(status);
        } else {
            extProcessStatus = new ExtProcessStatus();
            extProcessStatus.setProcessInstanceId(processInstanceId);
            extProcessStatus.setBusinessId(businessId);
            extProcessStatus.setStatus(status);
        }
        processTaskStatusService.saveOrUpdate(extProcessStatus);
    }

}
