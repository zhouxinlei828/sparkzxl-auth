package com.github.sparkzxl.workflow.domain.repository;

import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;

import java.util.List;

/**
 * description: 历史流程记录 仓储类
 *
 * @author charles.zhou
 * @date   2020-07-23 17:12:59
 */
public interface IExtHiTaskStatusRepository {
    /**
     * 查询历史流程记录
     *
     * @param processInstanceId 流程实例id
     * @return List<ActHiTaskStatus>
     */
    List<ExtHiTaskStatus> getHiTaskStatus(String processInstanceId);

    /**
     * 查询最新完成任务信息
     *
     * @param processInstanceId 流程实例id
     * @return ActHiTaskStatus
     */
    ExtHiTaskStatus getExtHiTaskStatus(String processInstanceId);
}
