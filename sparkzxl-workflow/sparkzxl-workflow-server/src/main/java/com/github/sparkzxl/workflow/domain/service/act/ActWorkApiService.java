package com.github.sparkzxl.workflow.domain.service.act;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.core.base.result.ApiResponseStatus;
import com.github.sparkzxl.core.support.BizExceptionAssert;
import com.github.sparkzxl.workflow.application.service.act.IProcessRepositoryService;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.application.service.act.IProcessTaskService;
import com.github.sparkzxl.workflow.application.service.ext.IExtHiTaskStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessTaskRuleService;
import com.github.sparkzxl.workflow.domain.model.DriveProcess;
import com.github.sparkzxl.workflow.domain.model.DriverData;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessUserRepository;
import com.github.sparkzxl.workflow.dto.DriverResult;
import com.github.sparkzxl.workflow.infrastructure.act.DeleteTaskCmd;
import com.github.sparkzxl.workflow.infrastructure.act.SetFlowNodeAndGoCmd;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskRule;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessUser;
import com.github.sparkzxl.workflow.infrastructure.enums.ProcessStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.enums.TaskStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.utils.ActivitiUtils;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.*;
import org.activiti.engine.IdentityService;
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
import java.util.concurrent.CompletableFuture;

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

    @Autowired
    private IdentityService identityService;

    @Transactional(rollbackFor = Exception.class)
    public DriverResult startProcess(DriveProcess driveProcess) {
        DriverResult driverResult = new DriverResult();
        String businessId = driveProcess.getBusinessId();
        try {
            String userId = driveProcess.getUserId();
            //查询是否存在已有流程，如果有，则不能进行启动工作流操作
            ProcessInstance originalProcessInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
            if (ObjectUtils.isNotEmpty(originalProcessInstance)) {
                BizExceptionAssert.businessFail("流程已存在，请勿重复启动");
            }
            Map<String, Object> variables = Maps.newHashMap();
            variables.put("assignee", driveProcess.getNextTaskApproveUserId());
            variables.put("actType", driveProcess.getActType());
            identityService.setAuthenticatedUserId(String.valueOf(userId));
            ProcessInstance processInstance = processRuntimeService.startProcessInstanceByKey(driveProcess.getProcessDefinitionKey(),
                    businessId,
                    variables);
            String processInstanceId = processInstance.getProcessInstanceId();
            log.info("启动activiti流程------++++++ProcessInstanceId：{}------++++++", processInstanceId);
            String comment = driveProcess.getComment();
            if (StringUtils.isEmpty(comment)) {
                comment = "开始节点跳过";
            }
            boolean needJump = driveProcess.isNeedJump();
            if (needJump) {
                driveProcess.setProcessInstanceId(processInstanceId);
                driveProcess.setProcessDefinitionKey(processInstance.getProcessDefinitionKey());
                driveProcess.setActType(WorkflowConstants.WorkflowAction.JUMP);
                driveProcess.setComment(comment);
                driverResult = jumpProcess(driveProcess);
            } else {
                variables.put("actType", WorkflowConstants.WorkflowAction.SUBMIT);
                DriverData driverData = DriverData.builder()
                        .userId(userId)
                        .processInstanceId(processInstanceId)
                        .businessId(businessId)
                        .processDefinitionKey(processInstance.getProcessDefinitionKey())
                        .actType(WorkflowConstants.WorkflowAction.SUBMIT)
                        .comment(comment)
                        .variables(variables)
                        .build();
                driverResult = promoteProcess(driverData);
            }
        } catch (Exception e) {
            driverResult.setErrorMsg(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("发生异常 Exception：{}", ExceptionUtil.getMessage(e));
        }
        return driverResult;
    }

    public DriverResult promoteProcess(DriverData driverData) {
        String processInstanceId = driverData.getProcessInstanceId();
        String comment = driverData.getComment();
        String userId = driverData.getUserId();
        Map<String, Object> variables = driverData.getVariables();
        Task task = processTaskService.getLatestTaskByProInstId(processInstanceId);
        String currentTaskId = task.getId();
        String taskDefinitionKey = task.getTaskDefinitionKey();
        ApiResponseStatus.FAILURE.assertNotNull(task);
        validateAuthority(task, userId);
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

    @Transactional(rollbackFor = Exception.class)
    public DriverResult jumpProcess(DriveProcess driveProcess) {
        DriverResult driverResult = new DriverResult();
        try {
            String businessId = driveProcess.getBusinessId();
            String userId = driveProcess.getUserId();
            int actType = driveProcess.getActType();
            ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
            if (ObjectUtils.isEmpty(processInstance)) {
                BizExceptionAssert.businessFail("流程实例为空，请检查参数是否正确");
            }
            String processInstanceId = processInstance.getProcessInstanceId();
            String comment = driveProcess.getComment();
            Task currentTask = processTaskService.getLatestTaskByProInstId(processInstanceId);
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
            ExtProcessTaskRule actRuTaskRule = processTaskRuleService.findActRuTaskRule(driveProcess.getProcessDefinitionKey(),
                    taskDefinitionKey, driveProcess.getActType());
            if (ObjectUtils.isEmpty(actRuTaskRule)) {
                BizExceptionAssert.businessFail("请设置流程跳转规则");
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
            driverResult = recordProcessState(processInstanceId, driveProcess.getBusinessId(), actType, currentTaskId, taskDefinitionKey);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            driverResult.setErrorMsg(e.getMessage());
            log.error("发生异常 Exception：{}", ExceptionUtil.getMessage(e));
        }
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

    @Transactional(rollbackFor = Exception.class)
    public DriverResult submitProcess(DriveProcess driveProcess) {
        DriverResult driverResult = new DriverResult();
        String businessId = driveProcess.getBusinessId();
        try {
            String nextTaskApproveUserId = driveProcess.getNextTaskApproveUserId();
            String userId = driveProcess.getUserId();
            Map<String, Object> variables = Maps.newHashMap();
            if (StringUtils.isNotEmpty(nextTaskApproveUserId)) {
                variables.put("assignee", nextTaskApproveUserId);
            }
            variables.put("actType", driveProcess.getActType());
            ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
            if (ObjectUtils.isEmpty(processInstance)) {
                BizExceptionAssert.businessFail("流程实例为空，请检查参数是否正确");
            }
            DriverData driverData = DriverData.builder()
                    .userId(userId)
                    .processInstanceId(processInstance.getProcessInstanceId())
                    .businessId(businessId)
                    .processDefinitionKey(processInstance.getProcessDefinitionKey())
                    .actType(driveProcess.getActType())
                    .comment(driveProcess.getComment())
                    .variables(variables)
                    .build();
            driverResult = promoteProcess(driverData);
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
        BizExceptionAssert.businessFail("当前节点审批人[" + extProcessUser.getName() + "]无权限审批！");
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
