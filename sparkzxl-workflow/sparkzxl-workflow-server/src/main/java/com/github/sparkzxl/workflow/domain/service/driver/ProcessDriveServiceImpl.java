package com.github.sparkzxl.workflow.domain.service.driver;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.core.utils.DateUtils;
import com.github.sparkzxl.core.utils.ListUtils;
import com.github.sparkzxl.database.factory.CustomThreadFactory;
import com.github.sparkzxl.patterns.strategy.BusinessHandler;
import com.github.sparkzxl.patterns.strategy.BusinessHandlerChooser;
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
import java.util.concurrent.*;
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
    private final BusinessHandlerChooser businessHandlerChooser;
    private final IExtProcessUserRepository processUserRepository;

    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
            4,
            10,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(30),
            new CustomThreadFactory());

    @Override
    public DriverResult driveProcess(DriverProcessParam driverProcessParam) {
        int actType = driverProcessParam.getActType();
        BusinessHandler<DriverResult, DriveProcess> businessHandlerChooser =
                this.businessHandlerChooser.businessHandlerChooser(WorkflowConstants.BusinessTaskStrategy.BUSINESS_TASK_DRIVER,
                        String.valueOf(actType));
        DriveProcess driveProcess = ActivitiDriverConvert.INSTANCE.convertDriveProcess(driverProcessParam);
        return businessHandlerChooser.businessHandler(driveProcess);
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
                userNextTask.setCandidateGroups(item.getCandidateGroups());
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
            try {
                UserNextTask currentUserTask = CompletableFuture.supplyAsync(() -> {
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
                    List<String> userIdList = processUserRepository.findUserIdListByRoleIds(candidateGroupList);
                    UserNextTask userNextTask = new UserNextTask();
                    userNextTask.setTaskId(lastTask.getId());
                    userNextTask.setAssignee(ListUtils.listToString(assigneeList));
                    userNextTask.setOwner(lastTask.getOwner());
                    userNextTask.setPriority(String.valueOf(lastTask.getPriority()));
                    userNextTask.setDueDate(lastTask.getDueDate());
                    userNextTask.setCandidateUsers(userIdList);
                    userNextTask.setCandidateGroups(candidateGroupList);
                    userNextTask.setTaskDefKey(lastTask.getTaskDefinitionKey());
                    userNextTask.setTaskName(lastTask.getName());
                    return userNextTask;
                }, threadPoolExecutor).get();

                UserNextTask userNextTask = CompletableFuture.supplyAsync(() -> {
                    UserNextTask nextUserTask = getNextUserTask(processInstance.getProcessInstanceId(), WorkflowConstants.WorkflowAction.SUBMIT);
                    UserNextTask nextTask = new UserNextTask();
                    List<String> candidateGroups = nextUserTask.getCandidateGroups();
                    List<String> accountList = processUserRepository.findUserIdListByRoleIds(candidateGroups);
                    nextTask.setAssignee(ListUtils.listToString(accountList));
                    nextTask.setOwner(nextUserTask.getOwner());
                    nextTask.setPriority(String.valueOf(nextUserTask.getPriority()));
                    nextTask.setDueDate(nextUserTask.getDueDate());
                    nextTask.setCandidateUsers(accountList);
                    nextTask.setCandidateGroups(candidateGroups);
                    nextTask.setTaskDefKey(nextUserTask.getTaskDefKey());
                    nextTask.setTaskName(nextUserTask.getTaskName());
                    return nextTask;
                }).get();
                busTaskInfo.setCurrentUserTask(currentUserTask);
                busTaskInfo.setUserNextTask(userNextTask);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        } else {
            actionMap.put(WorkflowConstants.WorkflowAction.START, "启动");
        }
        busTaskInfo.setActTypeMap(actionMap);
        return busTaskInfo;
    }

    @Override
    public List<BusTaskInfo> busTaskInfoList(List<String> businessIds, String processDefinitionKey) {
        List<BusTaskInfo> busTaskInfoList = Lists.newArrayList();
        businessIds.forEach(x -> busTaskInfoList.add(busTaskInfo(x, processDefinitionKey)));
        return busTaskInfoList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean suspendProcess(SuspendProcessDTO suspendProcessDTO) {
        if (suspendProcessDTO.getType().equals(1)) {
            return processRuntimeService.suspendProcess(suspendProcessDTO.getBusinessId());
        } else {
            return processRuntimeService.suspendProcessInstanceById(suspendProcessDTO.getProcessInstanceId());
        }
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
