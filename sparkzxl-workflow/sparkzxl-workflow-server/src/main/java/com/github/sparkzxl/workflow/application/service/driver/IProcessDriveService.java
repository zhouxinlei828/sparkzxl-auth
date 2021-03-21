package com.github.sparkzxl.workflow.application.service.driver;

import com.github.sparkzxl.workflow.dto.*;
import com.github.sparkzxl.workflow.interfaces.dto.process.ProcessNextTaskDTO;

import java.util.List;

/**
 * description: 流程驱动 服务类
 *
 * @author charles.zhou
 * @date   2020-07-17 16:26:54
 */
public interface IProcessDriveService {

    /**
     * activiti流程驱动接口
     *
     * @param driverProcessParam 流程驱动入参
     * @return DriverResult
     */
    DriverResult driveProcess(DriverProcessParam driverProcessParam);

    /**
     * 获取下一步任务详情
     *
     * @param processNextTaskDTO 查询下一步入参
     * @return List<UserNextTask>
     */
    List<UserNextTask> getNextUserTask(ProcessNextTaskDTO processNextTaskDTO);

    /**
     * 查询业务任务数据
     *
     * @param businessId           业务主键
     * @param processDefinitionKey 流程定义key
     * @return BusTaskInfo
     */
    BusTaskInfo busTaskInfo(String businessId, String processDefinitionKey);

    /**
     * 查询业务任务批量数据
     *
     * @param businessIds          业务主键
     * @param processDefinitionKey 流程定义key
     * @return List<BusTaskInfo>
     */
    List<BusTaskInfo> busTaskInfoList(List<String> businessIds, String processDefinitionKey);

    /**
     * 挂起流程
     *
     * @param suspendProcessDTO 挂起流程入参
     * @return boolean
     */
    boolean suspendProcess(SuspendProcessDTO suspendProcessDTO);

    /**
     * 删除流程实例
     *
     * @param businessId   业务主键
     * @param deleteReason 删除原因
     * @return boolean
     */
    boolean deleteProcessInstance(String businessId, String deleteReason);

    /**
     * 删除流程实例
     *
     * @param processInstanceDeleteDTO 删除流程实例入参
     * @return boolean
     */
    boolean deleteProcessInstanceBatch(ProcessInstanceDeleteDTO processInstanceDeleteDTO);

    /**
     * 根据流程实例id删除业务流程
     *
     * @param processInstanceId 流程实例id
     * @param deleteReason      删除原因
     */
    void deleteProcessByProcInsId(String processInstanceId, String deleteReason);

    /**
     * 根据流程实例id集合删除业务流程
     *
     * @param processInstanceIds 流程实例id集合
     * @return boolean
     */
    boolean deleteProcessByProcInsIds(List<String> processInstanceIds);

    /**
     * 根据流程实例id挂起流程
     *
     * @param processInstanceId 流程实例id
     * @return boolean
     */
    boolean suspendProcessByProcessInstanceId(String processInstanceId);
}
