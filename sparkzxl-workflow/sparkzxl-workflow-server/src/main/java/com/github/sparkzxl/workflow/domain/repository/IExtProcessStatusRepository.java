package com.github.sparkzxl.workflow.domain.repository;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.workflow.domain.model.InstanceOverviewCount;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessStatus;
import com.github.sparkzxl.workflow.infrastructure.entity.ProcessInstance;

import java.util.List;

/**
 * description: 流程状态 仓储类
 *
 * @author charles.zhou
 * @date   2020-07-23 13:58:34
 */
public interface IExtProcessStatusRepository {

    /**
     * 根据业务主键查询流程状态
     *
     * @param businessId 业务主键
     * @return ProcessTaskStatus
     */
    List<ExtProcessStatus> getExtProcessStatusList(String businessId);

    /**
     * 查询流程实例列表
     *
     * @param pageNum  当前页
     * @param pageSize 分页大小
     * @param name     流程名称
     * @return PageInfo<ProcessInstance>
     */
    PageInfo<ProcessInstance> getProcessInstanceList(int pageNum, int pageSize, String name);

    /**
     * 获取流程状态
     *
     * @param businessId        业务主键
     * @param processInstanceId 流程实例id
     * @return ExtProcessStatus
     */
    ExtProcessStatus getExtProcessStatus(String businessId, String processInstanceId);


    /**
     * 流程统计总览
     * @return InstanceOverviewCount
     */
    InstanceOverviewCount instanceOverview();

}
