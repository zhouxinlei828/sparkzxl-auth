package com.github.sparkzxl.workflow.domain.service.act;

import com.github.sparkzxl.workflow.application.service.act.IProcessTaskService;
import com.google.common.collect.Lists;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Attachment;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * description: 运行中的Task相关 服务实现类
 *
 * @author charles.zhou
 * @date   2020-07-17 16:23:03
 */
@Service
public class ProcessTaskServiceImpl implements IProcessTaskService {

    @Autowired
    private TaskService taskService;

    @Override
    public void claimTask(String taskId, String userId) {
        taskService.claim(taskId, userId);
    }

    @Override
    public void completeTask(String taskId, Map<String, Object> variables) {
        if (ObjectUtils.isNotEmpty(variables)) {
            taskService.complete(taskId, variables);
        } else {
            taskService.complete(taskId);
        }
    }

    @Override
    public List<Task> getUserTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).orderByTaskCreateTime().asc().list();
    }

    @Override
    public void assigneeTask(String taskId, String userId) {
        taskService.setAssignee(taskId, userId);
    }

    @Override
    public void addComment(String taskId, String processInstanceId, String comment) {
        taskService.addComment(taskId, processInstanceId, comment);
    }

    @Override
    public List<Comment> getComments(String processInstanceId) {
        return taskService.getProcessInstanceComments(processInstanceId);
    }

    @Override
    public List<Comment> getTaskComments(List<String> taskIds, String type) {
        List<Comment> commentList = Lists.newArrayList();
        taskIds.forEach(item -> commentList.addAll(getTaskComments(item, type)));
        return commentList;
    }

    @Override
    public List<Comment> getTaskComments(String taskId, String type) {
        return taskService.getTaskComments(taskId, type);
    }

    @Override
    public Task getTaskByTaskId(String taskId) {
        return taskService.createTaskQuery().taskId(taskId).singleResult();
    }

    @Override
    public List<Task> getTaskByProInstId(String processInstanceId) {
        return taskService.createTaskQuery().processInstanceId(processInstanceId).orderByTaskCreateTime().desc().list();
    }

    @Override
    public Task getLatestTaskByProInstId(String processInstanceId) {
        return taskService.createTaskQuery().processInstanceId(processInstanceId).orderByTaskCreateTime().desc().singleResult();
    }

    @Override
    public List<IdentityLink> getIdentityLinksForTask(String taskId) {
        return taskService.getIdentityLinksForTask(taskId);
    }

    @Override
    public List<Task> getTasksByUserId(String taskAssignee) {
        return taskService.createTaskQuery().taskAssignee(taskAssignee).orderByTaskCreateTime().desc().list();
    }

    @Override
    public Task getTasksByAssigneeAndBusKey(String taskAssignee, String businessKey) {
        return taskService.createTaskQuery().taskAssignee(taskAssignee).processInstanceBusinessKey(businessKey).singleResult();
    }

    @Override
    public long getTaskCount(String taskAssignee) {
        return taskService.createTaskQuery().taskAssignee(taskAssignee).count();
    }

    @Override
    public void setVariable(String taskId, String variableName, Object value) {
        taskService.setVariable(taskId, variableName, value);
    }

    @Override
    public List<Task> getTaskCandidateOrAssignedByKey(String assignee, String processDefinitionKey) {
        return taskService.createTaskQuery().taskCandidateOrAssigned(assignee)
                .processDefinitionKey(processDefinitionKey).list();
    }

    @Override
    public Attachment createAttachment(String attachmentType, String taskId, String processInstanceId,
                                       String attachmentName, String attachmentDescription, InputStream content) {
        return taskService.createAttachment(attachmentType, taskId, processInstanceId, attachmentName,
                attachmentDescription, content);
    }

    @Override
    public void saveAttachment(Attachment attachment) {
        taskService.saveAttachment(attachment);
    }

    @Override
    public void deleteAttachment(String attachmentId) {
        taskService.deleteAttachment(attachmentId);
    }

    @Override
    public List<Attachment> getTaskAttachments(String taskId) {
        return taskService.getTaskAttachments(taskId);
    }

    @Override
    public Attachment getAttachment(String attachmentId) {
        return taskService.getAttachment(attachmentId);
    }

    @Override
    public InputStream getAttachmentContent(String attachmentId) {
        return taskService.getAttachmentContent(attachmentId);
    }

    @Override
    public Object getVariable(String taskId, String variableName) {
        return taskService.getVariable(taskId, variableName);
    }

    @Override
    public List<Attachment> getAttachmentByProcessInstanceId(String processInstanceId) {
        return taskService.getProcessInstanceAttachments(processInstanceId);
    }

    @Override
    public void deleteTaskAttachment(String taskId) {
        List<Attachment> attachments = taskService.getTaskAttachments(taskId);
        if (attachments != null) {
            for (Attachment attachment : attachments) {
                taskService.deleteAttachment(attachment.getId());
            }
        }
    }

    @Override
    public void setAssignee(String taskId, String userId) {
        taskService.setAssignee(taskId, userId);
    }
}
