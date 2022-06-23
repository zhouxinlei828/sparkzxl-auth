package com.github.sparkzxl.workflow.infrastructure.act;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntityManager;

import java.util.List;

/**
 * description:
 *
 * @author zhouxinlei
 * @since 2021-07-18 10:59
 */
public class ExecutionVariableDeleteCmd implements Command<String> {

    /**
     * 当前任务执行id
     */
    private final String executionId;

    public ExecutionVariableDeleteCmd(String executionId) {
        this.executionId = executionId;
    }

    @Override
    public String execute(CommandContext commandContext) {
        VariableInstanceEntityManager vm = commandContext.getVariableInstanceEntityManager();
        List<VariableInstanceEntity> vs = vm.findVariableInstancesByExecutionId(this.executionId);
        for (VariableInstanceEntity v : vs) {
            vm.delete(v);
        }
        return executionId;
    }
}
