package com.github.sparkzxl.workflow.domain.service.driver;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.core.util.DateUtils;
import com.github.sparkzxl.core.util.ListUtils;
import com.github.sparkzxl.patterns.factory.BusinessStrategyFactory;
import com.github.sparkzxl.patterns.strategy.BusinessHandler;
import com.github.sparkzxl.workflow.application.service.act.IProcessRepositoryService;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.application.service.act.IProcessTaskService;
import com.github.sparkzxl.workflow.application.service.driver.IProcessDriveService;
import com.github.sparkzxl.workflow.application.service.ext.IExtHiTaskStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.domain.model.DriveProcess;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessUserRepository;
import com.github.sparkzxl.workflow.dto.*;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import com.github.sparkzxl.workflow.infrastructure.convert.ActivitiDriverConvert;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.enums.ProcessStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.utils.ActivitiUtils;
import com.github.sparkzxl.workflow.interfaces.dto.process.ProcessNextTaskDTO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * description: 流程驱动 服务 实现类
 *
 * @author charles.zhou
 * @date 2020-07-17 16:27:58
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProcessDriveServiceImpl implements IProcessDriveService {

    private final IExtHiTaskStatusService extHiTaskStatusService;
    private final IExtProcessStatusService extProcessStatusService;
    private final IProcessRepositoryService processRepositoryService;
    private final IProcessRuntimeService processRuntimeService;
    private final IProcessTaskService processTaskService;
    private final BusinessStrategyFactory businessStrategyFactory;
    private final IExtProcessUserRepository processUserRepository;

    @Override
    public DriverResult driveProcess(DriverProcessParam driverProcessParam) {
        int actType = driverProcessParam.getActType();
        BusinessHandler<DriverResult, DriveProcess> processBusinessHandler =
                this.businessStrategyFactory.getStrategy(WorkflowConstants.BusinessTaskStrategy.BUSINESS_TASK_DRIVER,
                        String.valueOf(actType));
        DriveProcess driveProcess = ActivitiDriverConvert.INSTANCE.convertDriveProcess(driverProcessParam);
        return processBusinessHandler.execute(driveProcess);
    }

    @Override
    public UserNextTask getNextUserTask(String processInstanceId, Integer actType) {
        Task currentTask = processTaskService.getLatestTaskByProInstId(processInstanceId);
        List<UserTask> userTasks = Lists.newArrayList();
        //获取BpmnModel对象
        BpmnModel bpmnModel = processRepositoryService.getBpmnModel(currentTask.getProcessDefinitionId());
        //获取Process对象
        Process process = bpmnModel.getProcesses().get(bpmnModel.getProcesses().size() - 1);
        //获取所有的FlowElement信息
        Collection<FlowElement> flowElements = process.getFlowElements();
        //获取当前节点信息
        FlowElement flowElement = ActivitiUtils.getFlowElementById(currentTask.getTaskDefinitionKey(), flowElements);
        Map<String, Object> variables = Maps.newHashMap();
        variables.put("actType", actType == null ? WorkflowConstants.WorkflowAction.SUBMIT : actType);
        ActivitiUtils.getNextNode(flowElements, flowElement, variables, userTasks);
        log.info("userTasks = {}", userTasks);
        List<UserNextTask> userNextTasks = Lists.newArrayList();
        if (ListUtils.isNotEmpty(userTasks)) {
            userTasks.forEach(item -> {
                UserNextTask userNextTask = new UserNextTask();
                userNextTask.setAssignee(item.getAssignee());
                userNextTask.setOwner(item.getOwner());
                userNextTask.setPriority(item.getPriority());
                Optional.ofNullable(item.getDueDate()).ifPresent(x -> userNextTask.setDueDate(
                        DateUtils.formatDate(x, DatePattern.NORM_DATETIME_PATTERN)));
                userNextTask.setBusinessCalendarName(item.getBusinessCalendarName());
                userNextTask.setCandidateUsers(item.getCandidateUsers());
                List<String> candidateGroups = item.getCandidateGroups();
                userNextTask.setCandidateGroups(candidateGroups);
                List<WorkflowUserInfo> userList = processUserRepository.findUserByRoleIds(candidateGroups);
                String candidateUserNames = userList.stream().map(WorkflowUserInfo::getName).collect(Collectors.joining("/"));
                userNextTask.setCandidateUserInfos(userList);
                userNextTask.setCandidateUserNames(candidateUserNames);
                userNextTask.setTaskDefKey(item.getId());
                userNextTask.setTaskName(item.getName());
                userNextTasks.add(userNextTask);
            });
            return userNextTasks.stream().sorted(Comparator.comparing(UserNextTask::getTaskDefKey).reversed()).collect(Collectors.toList()).get(0);
        }
        return null;
    }

    @Override
    public List<UserNextTask> getNextUserTask(ProcessNextTaskDTO processNextTaskDTO) {
        Task currentTask = processTaskService.getLatestTaskByProInstId(processNextTaskDTO.getProcessInstanceId());
        List<UserTask> userTasks = Lists.newArrayList();
        //获取BpmnModel对象
        BpmnModel bpmnModel = processRepositoryService.getBpmnModel(currentTask.getProcessDefinitionId());
        //获取Process对象
        Process process = bpmnModel.getProcesses().get(bpmnModel.getProcesses().size() - 1);
        //获取所有的FlowElement信息
        Collection<FlowElement> flowElements = process.getFlowElements();
        //获取当前节点信息
        FlowElement flowElement = ActivitiUtils.getFlowElementById(currentTask.getTaskDefinitionKey(), flowElements);
        ActivitiUtils.getNextNode(flowElements, flowElement, processNextTaskDTO.getVariables(), userTasks);
        log.info("userTasks = {}", userTasks);
        List<UserNextTask> userNextTasks = Lists.newArrayList();
        if (ListUtils.isNotEmpty(userTasks)) {
            userTasks.forEach(item -> {
                UserNextTask userNextTask = new UserNextTask();
                userNextTask.setAssignee(item.getAssignee());
                userNextTask.setOwner(item.getOwner());
                userNextTask.setPriority(item.getPriority());
                userNextTask.setDueDate(DateUtils.formatDate(item.getDueDate(), DatePattern.NORM_DATETIME_PATTERN));
                userNextTask.setBusinessCalendarName(item.getBusinessCalendarName());
                userNextTask.setCandidateUsers(item.getCandidateUsers());
                userNextTask.setCandidateGroups(item.getCandidateGroups());
                userNextTask.setTaskDefKey(item.getId());
                userNextTask.setTaskName(item.getName());
                userNextTasks.add(userNextTask);
            });
        }
        return userNextTasks;
    }

    @Override
    public BusTaskInfo busTaskInfo(String businessId, String processDefinitionKey) {
        BusTaskInfo busTaskInfo = new BusTaskInfo();
        busTaskInfo.setProcessDefinitionKey(processDefinitionKey);
        busTaskInfo.setBusinessId(businessId);
        ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
        Map<Object, Object> actionMap = Maps.newHashMap();
        if (ObjectUtils.isNotEmpty(processInstance)) {
            actionMap.put(WorkflowConstants.WorkflowAction.SUBMIT, "提交");
            actionMap.put(WorkflowConstants.WorkflowAction.AGREE, "同意");
            actionMap.put(WorkflowConstants.WorkflowAction.JUMP, "跳转");
            actionMap.put(WorkflowConstants.WorkflowAction.REJECTED, "驳回");
            actionMap.put(WorkflowConstants.WorkflowAction.ROLLBACK, "回退");
            actionMap.put(WorkflowConstants.WorkflowAction.END, "结束");
            Task lastTask = processTaskService.getLatestTaskByProInstId(processInstance.getProcessInstanceId());
            List<IdentityLink> identityLinks = processTaskService.getIdentityLinksForTask(lastTask.getId());
            List<String> candidateGroupList = Lists.newArrayList();
            List<String> assigneeList = Lists.newArrayList();
            if (CollectionUtils.isNotEmpty(identityLinks)) {
                identityLinks.forEach(identityLink -> {
                    if (StringUtils.isNoneEmpty(identityLink.getGroupId())) {
                        candidateGroupList.add(identityLink.getGroupId());
                    }
                    if (StringUtils.isNoneEmpty(identityLink.getUserId())) {
                        assigneeList.add(identityLink.getUserId());
                    }
                });
            }
            List<WorkflowUserInfo> userList = processUserRepository.findUserByRoleIds(candidateGroupList);
            String candidateUserNames = userList.stream().map(WorkflowUserInfo::getName).collect(Collectors.joining("/"));
            UserNextTask userNextTask = new UserNextTask();
            userNextTask.setTaskId(lastTask.getId());
            userNextTask.setAssignee(ListUtils.listToString(assigneeList));
            userNextTask.setOwner(lastTask.getOwner());
            userNextTask.setPriority(String.valueOf(lastTask.getPriority()));
            userNextTask.setDueDate(lastTask.getDueDate());
            userNextTask.setCandidateUserInfos(userList);
            userNextTask.setCandidateUserNames(candidateUserNames);
            userNextTask.setCandidateGroups(candidateGroupList);
            userNextTask.setTaskDefKey(lastTask.getTaskDefinitionKey());
            userNextTask.setTaskName(lastTask.getName());
            busTaskInfo.setCurrentUserTask(userNextTask);
        } else {
            actionMap.put(WorkflowConstants.WorkflowAction.START, "启动");
        }
        busTaskInfo.setActTypeMap(actionMap);
        return busTaskInfo;
    }

    @Override
    public List<BusTaskInfo> busTaskInfoList(String processDefinitionKey, List<String> businessIds) {
        List<BusTaskInfo> busTaskInfoList = Lists.newArrayList();
        businessIds.forEach(x -> busTaskInfoList.add(busTaskInfo(x, processDefinitionKey)));
        return busTaskInfoList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean suspendProcess(ModifyProcessDTO modifyProcessDTO) {
        LambdaUpdateWrapper<ExtProcessStatus> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(ExtProcessStatus::getStatus, ProcessStatusEnum.SUSPEND.getDesc());
        if (modifyProcessDTO.getType().equals(1)) {
            lambdaUpdateWrapper.eq(ExtProcessStatus::getBusinessId, modifyProcessDTO.getBusinessId());
            processRuntimeService.suspendProcess(modifyProcessDTO.getBusinessId());
        } else {
            lambdaUpdateWrapper.eq(ExtProcessStatus::getProcessInstanceId, modifyProcessDTO.getProcessInstanceId());
            processRuntimeService.suspendProcessInstanceById(modifyProcessDTO.getProcessInstanceId());
        }
        extProcessStatusService.update(lambdaUpdateWrapper);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean activateProcessInstance(ModifyProcessDTO modifyProcessDTO) {
        LambdaUpdateWrapper<ExtProcessStatus> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.set(ExtProcessStatus::getStatus, ProcessStatusEnum.RUN_TIME.getDesc());
        if (modifyProcessDTO.getType().equals(1)) {
            lambdaUpdateWrapper.eq(ExtProcessStatus::getBusinessId, modifyProcessDTO.getBusinessId());
            processRuntimeService.activateProcessInstanceByBusinessId(modifyProcessDTO.getBusinessId());
        } else {
            lambdaUpdateWrapper.eq(ExtProcessStatus::getProcessInstanceId, modifyProcessDTO.getProcessInstanceId());
            processRuntimeService.activateProcessInstanceByProcInsId(modifyProcessDTO.getProcessInstanceId());
        }
        extProcessStatusService.update(lambdaUpdateWrapper);
        return true;
    }

    @Override
    public void deleteProcessInstance(String businessId, String deleteReason) {
        ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
        if (ObjectUtils.isNotEmpty(processInstance)) {
            String processInstanceId = processInstance.getProcessInstanceId();
            processRuntimeService.deleteProcessInstance(processInstanceId, deleteReason);
            extHiTaskStatusService.remove(new LambdaUpdateWrapper<ExtHiTaskStatus>().eq(ExtHiTaskStatus::getProcessInstanceId,
                    processInstanceId));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteProcessInstanceBatch(ProcessInstanceDeleteDTO processInstanceDeleteDTO) {
        if (processInstanceDeleteDTO.getType().equals(1)) {
            if (CollectionUtils.isNotEmpty(processInstanceDeleteDTO.getBusinessIds())) {
                processInstanceDeleteDTO.getBusinessIds().forEach(businessId -> deleteProcessInstance(businessId, processInstanceDeleteDTO.getDeleteReason()));
            }
        } else {
            if (CollectionUtils.isNotEmpty(processInstanceDeleteDTO.getProcessInstanceIds())) {
                processInstanceDeleteDTO.getProcessInstanceIds().forEach(processInstanceId -> deleteProcessByProcInsId(processInstanceId, processInstanceDeleteDTO.getDeleteReason()));

            }
        }
        return Boolean.TRUE;
    }

    @Override
    public boolean suspendProcessByProcessInstanceId(String processInstanceId) {
        return false;
    }

    @Override
    public void deleteProcessByProcInsId(String processInstanceId, String deleteReason) {
        ProcessInstance processInstance = processRuntimeService.getProcessInstance(processInstanceId);
        if (ObjectUtils.isNotEmpty(processInstance)) {
            processRuntimeService.deleteProcessInstance(processInstanceId, deleteReason);
        }
        extHiTaskStatusService.remove(new LambdaUpdateWrapper<ExtHiTaskStatus>().eq(ExtHiTaskStatus::getProcessInstanceId,
                processInstanceId));
        extProcessStatusService.remove(new LambdaUpdateWrapper<ExtProcessStatus>().eq(ExtProcessStatus::getProcessInstanceId,
                processInstanceId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteProcessByProcInsIds(List<String> processInstanceIds) {
        if (CollectionUtils.isNotEmpty(processInstanceIds)) {
            processInstanceIds.forEach(processInstanceId -> deleteProcessByProcInsId(processInstanceId, "删除流程"));
        }
        return true;
    }
}
