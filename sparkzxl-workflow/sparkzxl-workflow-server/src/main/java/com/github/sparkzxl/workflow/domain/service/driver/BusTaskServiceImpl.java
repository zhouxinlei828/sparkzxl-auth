package com.github.sparkzxl.workflow.domain.service.driver;

import com.github.sparkzxl.core.util.ListUtils;
import com.github.sparkzxl.workflow.application.service.act.IProcessRuntimeService;
import com.github.sparkzxl.workflow.application.service.act.IProcessTaskService;
import com.github.sparkzxl.workflow.application.service.driver.IBusTaskService;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessUserRepository;
import com.github.sparkzxl.workflow.dto.BusTaskInfo;
import com.github.sparkzxl.workflow.dto.UserNextTask;
import com.github.sparkzxl.workflow.dto.WorkflowUserInfo;
import com.github.sparkzxl.workflow.infrastructure.constant.WorkflowActionConstants;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: 业务任务 服务实现类
 *
 * @author zhouxinlei
 * @since 2022-03-06 16:30:56
 */
@Service
@RequiredArgsConstructor
public class BusTaskServiceImpl implements IBusTaskService {

    private final IProcessRuntimeService processRuntimeService;
    private final IProcessTaskService processTaskService;
    private final IExtProcessUserRepository processUserRepository;

    @Override
    public BusTaskInfo busTaskInfo(String businessId, String processDefinitionKey) {
        BusTaskInfo busTaskInfo = new BusTaskInfo();
        busTaskInfo.setProcessDefinitionKey(processDefinitionKey);
        busTaskInfo.setBusinessId(businessId);
        ProcessInstance processInstance = processRuntimeService.getProcessInstanceByBusinessId(businessId);
        Map<Object, Object> actionMap = Maps.newHashMap();
        if (ObjectUtils.isNotEmpty(processInstance)) {
            actionMap.put(WorkflowActionConstants.SUBMIT, "提交");
            actionMap.put(WorkflowActionConstants.AGREE, "同意");
            actionMap.put(WorkflowActionConstants.JUMP, "跳转");
            actionMap.put(WorkflowActionConstants.REJECTED, "驳回");
            actionMap.put(WorkflowActionConstants.ROLLBACK, "回退");
            actionMap.put(WorkflowActionConstants.END, "结束");
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
            actionMap.put(WorkflowActionConstants.START, "启动");
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
}
