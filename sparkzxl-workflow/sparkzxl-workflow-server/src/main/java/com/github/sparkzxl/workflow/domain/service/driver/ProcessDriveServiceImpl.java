package com.github.sparkzxl.workflow.domain.service.driver;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.core.util.DateUtils;
import com.github.sparkzxl.core.util.ListUtils;
import com.github.sparkzxl.workflow.application.rule.external.WorkflowActionHandlerFactory;
import com.github.sparkzxl.workflow.application.service.act.IProcessRepositoryService;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.application.service.act.IProcessTaskService;
import com.github.sparkzxl.workflow.application.service.driver.IBusTaskService;
import com.github.sparkzxl.workflow.application.service.driver.IProcessDriveService;
import com.github.sparkzxl.workflow.application.service.ext.IExtHiTaskStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.domain.model.bo.ExecuteProcess;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessNextTaskDTO;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessUserRepository;
import com.github.sparkzxl.workflow.dto.*;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowActionConstants;
import com.github.sparkzxl.workflow.infrastructure.convert.ActivitiDriverConvert;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.enums.ProcessStatusEnum;
import com.github.sparkzxl.workflow.infrastructure.utils.ActivitiUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
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
    private final WorkflowActionHandlerFactory workflowActionHandlerFactory;
    private final IExtProcessUserRepository processUserRepository;
    private final IBusTaskService busTaskService;

    @Override
    public DriverResult driveProcess(DriverProcessParam driverProcessParam) {
        ExecuteProcess executeProcess = ActivitiDriverConvert.INSTANCE.convertDriveProcess(driverProcessParam);
        return this.workflowActionHandlerFactory.getActionHandler(driverProcessParam.getActType()).execute(executeProcess);
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
        variables.put("actType", actType == null ? WorkflowActionConstants.SUBMIT : actType);
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
        return busTaskService.busTaskInfo(businessId, processDefinitionKey);
    }

    @Override
    public List<BusTaskInfo> busTaskInfoList(String processDefinitionKey, List<String> businessIds) {
        return busTaskService.busTaskInfoList(processDefinitionKey, businessIds);
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
                processInstanceDeleteDTO.getProcessInstanceIds()
                        .forEach(processInstanceId -> deleteProcessByProcInsId(processInstanceId, processInstanceDeleteDTO.getDeleteReason()));

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
