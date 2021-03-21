package com.github.sparkzxl.workflow.domain.service.driver;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.sparkzxl.core.utils.DateUtils;
import com.github.sparkzxl.core.utils.ListUtils;
import com.github.sparkzxl.workflow.application.service.act.IProcessRepositoryService;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.application.service.act.IProcessTaskService;
import com.github.sparkzxl.workflow.application.service.driver.IProcessDriveService;
import com.github.sparkzxl.workflow.application.service.ext.IExtHiTaskStatusService;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessStatusService;
import com.github.sparkzxl.workflow.domain.model.DriveProcess;
import com.github.sparkzxl.workflow.dto.*;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowConstants;
import com.github.sparkzxl.workflow.infrastructure.convert.ActivitiDriverConvert;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.strategy.AbstractProcessSolver;
import com.github.sparkzxl.workflow.infrastructure.strategy.ProcessSolverChooser;
import com.github.sparkzxl.workflow.infrastructure.utils.ActivitiUtils;
import com.github.sparkzxl.workflow.interfaces.dto.process.ProcessNextTaskDTO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * description: 流程驱动 服务 实现类
 *
 * @author charles.zhou
 * @date   2020-07-17 16:27:58
 */
@Service
@Slf4j
@Transactional(transactionManager = "transactionManager", rollbackFor = Exception.class)
public class ProcessDriveServiceImpl implements IProcessDriveService {

    private ProcessSolverChooser processSolverChooser;
    private IExtHiTaskStatusService extHiTaskStatusService;
    private IExtProcessStatusService extProcessStatusService;
    private IProcessRepositoryService processRepositoryService;
    private IProcessRuntimeService processRuntimeService;
    private IProcessTaskService processTaskService;

    @Autowired
    public void setActivitiSolverChooser(ProcessSolverChooser processSolverChooser) {
        this.processSolverChooser = processSolverChooser;
    }

    @Autowired
    public void setExtHiTaskStatusService(IExtHiTaskStatusService extHiTaskStatusService) {
        this.extHiTaskStatusService = extHiTaskStatusService;
    }

    @Autowired
    public void setExtProcessStatusService(IExtProcessStatusService extProcessStatusService) {
        this.extProcessStatusService = extProcessStatusService;
    }

    @Autowired
    public void setProcessRepositoryService(IProcessRepositoryService processRepositoryService) {
        this.processRepositoryService = processRepositoryService;
    }

    @Autowired
    public void setProcessRuntimeService(IProcessRuntimeService processRuntimeService) {
        this.processRuntimeService = processRuntimeService;
    }

    @Autowired
    public void setProcessTaskService(IProcessTaskService processTaskService) {
        this.processTaskService = processTaskService;
    }

    @Override
    public DriverResult driveProcess(DriverProcessParam driverProcessParam) {
        int actType = driverProcessParam.getActType();
        AbstractProcessSolver activitiSolver = processSolverChooser.chooser(actType);
        DriveProcess driveProcess = ActivitiDriverConvert.INSTANCE.convertDriveProcess(driverProcessParam);
        return activitiSolver.slove(driverProcessParam.getBusinessId(), driveProcess);
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
                userNextTask.setDueDate(item.getDueDate());
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
            actionMap.put(WorkflowConstants.WorkflowAction.ROLLBACK, "驳回");
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
            UserNextTask userNextTask = new UserNextTask();
            userNextTask.setAssignee(ListUtils.listToString(assigneeList));
            userNextTask.setOwner(lastTask.getOwner());
            userNextTask.setPriority(String.valueOf(lastTask.getPriority()));
            userNextTask.setDueDate(DateUtils.format(lastTask.getDueDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            userNextTask.setCandidateUsers(assigneeList);
            userNextTask.setCandidateGroups(candidateGroupList);
            userNextTask.setTaskDefKey(lastTask.getTaskDefinitionKey());
            userNextTask.setTaskName(lastTask.getName());
            busTaskInfo.setUserNextTask(userNextTask);
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
    public boolean suspendProcess(SuspendProcessDTO suspendProcessDTO) {
        if (suspendProcessDTO.getType().equals(1)) {
            return processRuntimeService.suspendProcess(suspendProcessDTO.getBusinessId());
        } else {
            return processRuntimeService.suspendProcessInstanceById(suspendProcessDTO.getProcessInstanceId());
        }
    }

    @Override
    public boolean deleteProcessInstance(String businessId, String deleteReason) {
        ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
        if (ObjectUtils.isNotEmpty(processInstance)) {
            String processInstanceId = processInstance.getProcessInstanceId();
            processRuntimeService.deleteProcessInstance(processInstanceId, deleteReason);
            extHiTaskStatusService.remove(new LambdaUpdateWrapper<ExtHiTaskStatus>().eq(ExtHiTaskStatus::getProcessInstanceId,
                    processInstanceId));
        }
        return true;
    }

    @Override
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
        return false;
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
            extHiTaskStatusService.remove(new LambdaUpdateWrapper<ExtHiTaskStatus>().eq(ExtHiTaskStatus::getProcessInstanceId,
                    processInstanceId));
            extProcessStatusService.remove(new LambdaUpdateWrapper<ExtProcessStatus>().eq(ExtProcessStatus::getProcessInstanceId,
                    processInstanceId));
        }
    }

    @Override
    public boolean deleteProcessByProcInsIds(List<String> processInstanceIds) {
        if (CollectionUtils.isNotEmpty(processInstanceIds)) {
            processInstanceIds.forEach(processInstanceId -> deleteProcessByProcInsId(processInstanceId, "删除流程"));
        }
        return true;
    }
}
