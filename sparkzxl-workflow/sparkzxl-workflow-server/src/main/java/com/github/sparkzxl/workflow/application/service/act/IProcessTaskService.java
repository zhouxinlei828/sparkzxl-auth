package com.github.sparkzxl.workflow.application.service.act;

import org.activiti.engine.task.Attachment;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * description: 运行中的Task相关 服务类
 *
 * @author charles.zhou
 * @date   2020-07-17 15:45:37
 */
public interface IProcessTaskService {

    /**
     * 认领任务
     *
     * @param taskId 任务id
     * @param userId 用户id
     */
    void claimTask(String taskId, String userId);

    /**
     * 完成任务
     *
     * @param taskId    任务id
     * @param variables 流程变量
     */
    void completeTask(String taskId, Map<String, Object> variables);

    /**
     * 查询指定用户任务
     *
     * @param assignee 用户id
     * @return List<Task>
     */
    List<Task> getUserTasks(String assignee);

    /**
     * 指派用户任务
     *
     * @param taskId 任务id
     * @param userId 用户id
     */
    void assigneeTask(String taskId, String userId);

    /**
     * 添加评论
     *
     * @param taskId            任务id
     * @param processInstanceId 流程实例id
     * @param comment           评论内容
     */
    void addComment(String taskId, String processInstanceId, String comment);


    /**
     * 获取历史评论信息
     *
     * @param processInstanceId 流程实例id
     * @return List<Comment>
     */
    List<Comment> getComments(String processInstanceId);


    /**
     * 获取历史评论信息
     *
     * @param taskIds 历史任务实例id
     * @param type    意见记录类型: event（事件） comment（意见）
     * @return List<Comment>
     */
    List<Comment> getTaskComments(List<String> taskIds, String type);

    /**
     * 获取历史评论信息
     *
     * @param taskId 历史任务实例id
     * @param type    意见记录类型: event（事件） comment（意见）
     * @return List<Comment>
     */
    List<Comment> getTaskComments(String taskId, String type);

    /**
     * 根据任务id获取任务实例
     *
     * @param taskId 任务id
     * @return Task
     */
    Task getTaskByTaskId(String taskId);

    /**
     * 根据流程实例id获取任务实例
     *
     * @param processInstanceId 流程实例id
     * @return List<Task>
     */
    List<Task> getTaskByProInstId(String processInstanceId);

    /**
     * 根据流程实例id获取最新任务实例
     *
     * @param processInstanceId 流程实例id
     * @return Task
     */
    Task getLatestTaskByProInstId(String processInstanceId);

    /**
     * 获取任务候选人信息
     * @param taskId 任务id
     * @return List<IdentityLink>
     */
    List<IdentityLink> getIdentityLinksForTask(String taskId);

    /**
     * 读取直接分配给当前人的任务
     *
     * @param taskAssignee 用户id
     * @return List<Task>
     */
    List<Task> getTasksByUserId(String taskAssignee);

    /**
     * 读取直接分配给当前人的任务
     *
     * @param taskAssignee 用户id
     * @param businessKey  业务主键
     * @return Task
     */
    Task getTasksByAssigneeAndBusKey(String taskAssignee, String businessKey);

    /**
     * 获取用户任务数量
     *
     * @param taskAssignee 用户id
     * @return long
     */
    long getTaskCount(String taskAssignee);

    /**
     * 设置变量
     *
     * @param taskId       任务id
     * @param variableName 变量名称
     * @param value        变量值
     */
    void setVariable(String taskId, String variableName, Object value);

    /**
     * 根据流程定义key和任务处理人查找相关任务
     *
     * @param assignee             用户id
     * @param processDefinitionKey 流程定义key
     * @return
     */
    List<Task> getTaskCandidateOrAssignedByKey(String assignee, String processDefinitionKey);

    /**
     * Purpose：创建文件类型的附件
     *
     * @param attachmentType        文件类型
     * @param taskId                任务id
     * @param processInstanceId     流程id
     * @param attachmentName        文件名称
     * @param attachmentDescription 文件描述
     * @param content               文件内容
     * @return Attachment
     */
    Attachment createAttachment(String attachmentType, String taskId, String processInstanceId,
                                String attachmentName, String attachmentDescription, InputStream content);

    /**
     * Purpose：修改后保存文件
     *
     * @param attachment 附件
     */
    void saveAttachment(Attachment attachment);

    /**
     * 删除附件
     *
     * @param attachmentId 附件id
     */
    void deleteAttachment(String attachmentId);

    /**
     * 根据任务id获取相应附件信息
     *
     * @param taskId 任务id
     * @return List<Attachment>
     */
    List<Attachment> getTaskAttachments(String taskId);

    /**
     * 根据附件id获取附件信息
     *
     * @param attachmentId 附件id
     * @return Attachment
     */
    Attachment getAttachment(String attachmentId);

    /**
     * 根据附件id获取附件内容
     *
     * @param attachmentId 附件id
     * @return InputStream
     */
    InputStream getAttachmentContent(String attachmentId);

    /**
     * 获取流程变量
     *
     * @param taskId       任务id
     * @param variableName 变量名
     * @return
     */
    Object getVariable(String taskId, String variableName);

    /**
     * 根据流程定义id获取相关附件信息列表
     *
     * @param processInstanceId 流程实例id
     * @return List<Attachment>
     */
    List<Attachment> getAttachmentByProcessInstanceId(String processInstanceId);

    /**
     * 删除当前任务相关附件
     *
     * @param taskId 任务id
     */
    void deleteTaskAttachment(String taskId);

    /**
     * 设置任务处理人
     * @param taskId
     * @param userId
     */
    void setAssignee(String taskId, String userId);
}
