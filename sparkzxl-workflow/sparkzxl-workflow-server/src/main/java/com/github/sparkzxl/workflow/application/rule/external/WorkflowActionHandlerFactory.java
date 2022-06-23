package com.github.sparkzxl.workflow.application.rule.external;

import com.github.sparkzxl.core.util.ArgumentAssert;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * description: 工作流流程类型加载工厂
 *
 * @author zhouxinlei
 * @since 2022-03-05 14:50:16
 */
@Component
public class WorkflowActionHandlerFactory {

    private final Map<Integer, IWorkflowActionHandler> workflowActionHandlerMap = Maps.newHashMap();

    public WorkflowActionHandlerFactory(final List<IWorkflowActionHandler> workflowActionHandlers) {
        if (CollectionUtils.isNotEmpty(workflowActionHandlers)) {
            workflowActionHandlers.forEach(workflowActionHandler -> {
                workflowActionHandlerMap.put(workflowActionHandler.getActionType(), workflowActionHandler);
            });
        }
    }

    public IWorkflowActionHandler getActionHandler(Integer actionType) {
        IWorkflowActionHandler workflowActionHandler = workflowActionHandlerMap.get(actionType);
        ArgumentAssert.notNull(workflowActionHandler, "未知流程动作类型");
        return workflowActionHandler;
    }
}
