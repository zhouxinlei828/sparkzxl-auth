package com.github.sparkzxl.workflow.application.rule.external;

import com.github.sparkzxl.workflow.domain.model.bo.ExecuteProcess;
import com.github.sparkzxl.workflow.dto.DriverResult;

/**
 * description: 工作流流程动作处理器 服务类
 *
 * @author zhouxinlei
 * @since 2022-03-05 14:04:22
 */
public interface IWorkflowActionHandler {

    /**
     * 执行工作流
     *
     * @param executeProcess 执行data
     * @return DriverResult
     */
    DriverResult execute(ExecuteProcess executeProcess);

    /**
     * 动作类型
     *
     * @return String
     */
    int getActionType();

}
