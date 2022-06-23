package com.github.sparkzxl.workflow.application.service.ext;

import com.github.sparkzxl.database.base.service.SuperService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtHiTaskStatus;

import java.util.List;

/**
 * description: 任务历史状态记录 服务类
 *
 * @author charles.zhou
 * @since 2020-07-23 14:40:51
 */
public interface IExtHiTaskStatusService extends SuperService<ExtHiTaskStatus> {
    /**
     * 查询任务历史
     *
     * @param processInstanceId 流程实例id
     * @return List<ProcessHistoryDTO>
     */
    List<ExtHiTaskStatus> getProcessHistory(String processInstanceId);

    /**
     * 查询最新完成任务信息
     *
     * @param processInstanceId 流程实例id
     * @return ActHiTaskStatus
     */
    ExtHiTaskStatus getExtHiTaskStatus(String processInstanceId);
}
