package com.github.sparkzxl.workflow.application.service.act;

import com.github.sparkzxl.workflow.dto.ProcessHistory;
import com.github.sparkzxl.workflow.dto.ProcessHistoryParam;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;

import java.util.List;

/**
 * description: 历史流程 服务类
 *
 * @author charles.zhou
 * @date   2020-07-17 15:17:28
 */
public interface IProcessHistoryService {

    /**
     * 获取历史流程实例
     *
     * @param processInstanceId 流程实例id
     * @return HistoricProcessInstance
     */
    HistoricProcessInstance getHistoricProcessInstance(String processInstanceId);

    /**
     * 根据签收人id获取历史任务列表
     *
     * @param assignee 签收人id
     * @return List<HistoricTaskInstance>
     */
    List<HistoricTaskInstance> getHistoricTasksByAssigneeId(String assignee);

    /**
     * 根据流程实例id获取历史任务列表
     *
     * @param processInstanceId 流程实例id
     * @return List<HistoricTaskInstance>
     */
    List<HistoricTaskInstance> getHistoricTasksByProcessInstanceId(String processInstanceId);

    /**
     * 根据流程实例id获取历史任务列表
     *
     * @param taskId 任务id
     * @return HistoricTaskInstance
     */
    HistoricTaskInstance getHistoricTasksByTaskId(String taskId);

    /**
     * 获取流程图
     *
     * @param processInstanceId 流程实例id
     * @return String
     */
    String getProcessImage(String processInstanceId);

    /**
     * 查询流程历史信息
     *
     * @param processHistoryParam 流程历史查询入参
     * @return List<ProcessHistory>
     */
    List<ProcessHistory> processHistoryList(ProcessHistoryParam processHistoryParam);
}
