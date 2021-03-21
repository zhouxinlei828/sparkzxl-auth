package com.github.sparkzxl.workflow.application.service.act;

import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;
import java.util.Map;

/**
 * description: 运行中的流程 服务类
 *
 * @author charles.zhou
 * @date   2020-07-17 15:26:42
 */
public interface IProcessRuntimeService {

    /**
     * 根据流程定义key启动流程实例
     *
     * @param definitionKey 流程定义key
     * @return ProcessInstance
     */
    ProcessInstance startProcessInstanceByKey(String definitionKey);

    /**
     * 启动流程实例
     *
     * @param bpmnId     流程图id
     * @param businessId 业务主键
     * @param variables  流程变量
     * @return ProcessInstance
     */
    ProcessInstance startProcessInstanceByKey(String bpmnId, String businessId, Map<String, Object> variables);

    /**
     * 通过流程定义id启动流程
     *
     * @param processDefinitionId 流程定义id
     * @return ProcessInstance
     */
    ProcessInstance startProcessInstanceByProDefId(String processDefinitionId);

    /**
     * 通过流程实例id获取流程实例
     *
     * @param processInstanceId 流程实例id
     * @return ProcessInstance
     */
    ProcessInstance getProcessInstance(String processInstanceId);

    /**
     * 通过业务主键id获取流程实例
     *
     * @param businessId 业务主键id
     * @return ProcessInstance
     */
    ProcessInstance getProcessInstanceByBusinessId(String businessId);

    /**
     * 获取活动节点信息
     *
     * @param executionId 运行时活动id
     * @return List<String>
     */
    List<String> getActiveActivityIds(String executionId);

    /**
     * 获取执行实例信息
     *
     * @param executionId 运行时活动id
     * @return ExecutionEntity
     */
    ExecutionEntity getExecutionEntityByExecutionId(String executionId);

    /**
     * 通过任务id获取流程实例
     *
     * @param taskId 任务id
     * @return ProcessInstance
     */
    ProcessInstance getProcessInstanceByTaskId(String taskId);

    /**
     * 获取运行时的流程变量的值
     *
     * @param executionId  运行时活动id
     * @param variableName 变量名
     * @return Object
     */
    Object getVariable(String executionId, String variableName);

    /**
     * 根据流程实例id获取相关变量
     *
     * @param executionId 运行时活动id
     * @return Map<String, Object>
     */
    Map<String, Object> getVariables(String executionId);

    /**
     * 根据流程实例ID获取执行实例
     * 注意：可能是多个执行实例ID，比如并行任务的情况
     *
     * @param processInstanceId 流程实例ID
     * @return List<Execution>
     */
    List<Execution> getExecutionByProcInsId(String processInstanceId);

    /**
     * 根据流程定义的Key获取所有正在运行的执行实例
     *
     * @param processDefinitionKey 流程定义key
     * @return List<Execution>
     */
    List<Execution> getExecutionEntityByProDefKey(String processDefinitionKey);

    /**
     * 判断流程是否结束
     *
     * @param processInstanceId 流程实例id
     * @return boolean
     */
    boolean processIsEnd(String processInstanceId);

    /**
     * 挂起流程
     *
     * @param businessId 业务主键
     * @return boolean
     */
    boolean suspendProcess(String businessId);

    /**
     * 根据流程实例id挂起流程
     * @param processInstanceId 流程实例id
     * @return
     */
    boolean suspendProcessInstanceById(String processInstanceId);
    /**
     * 删除流程实例
     *
     * @param processInstanceId 流程实例id
     * @param deleteReason      删除原因
     */
    void deleteProcessInstance(String processInstanceId, String deleteReason);
}
