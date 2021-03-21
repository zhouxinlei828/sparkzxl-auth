package com.github.sparkzxl.workflow.infrastructure.act;

import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;

import java.util.List;

/**
 * description: 自由跳转节点
 *
 * @author charles.zhou
 * @date   2020-07-21 16:03:19
 */
public class SetFlowNodeAndGoCmd implements Command<Void> {

    /**
     * 目标节点对象
     */
    private final FlowNode flowElement;
    /**
     * 当前任务执行id
     */
    private final String executionId;

    public SetFlowNodeAndGoCmd(FlowNode flowElement, String executionId) {
        this.flowElement = flowElement;
        this.executionId = executionId;
    }

    @Override
    public Void execute(CommandContext commandContext) {
        // 获取目标节点的来源连线
        List<SequenceFlow> flows = flowElement.getIncomingFlows();
        if (flows == null || flows.size() < 1) {
            throw new ActivitiException("回退错误，目标节点没有来源连线");
        }
        // 随便选一条目标节点的入线来执行，使当前执行计划为：从所选择的流程线流转到目标节点，实现跳转
        ExecutionEntity executionEntity = commandContext.getExecutionEntityManager().findById(executionId);
        executionEntity.setCurrentFlowElement(flows.get(0));
        commandContext.getAgenda().planTakeOutgoingSequenceFlowsOperation(executionEntity, true);
        return null;
    }
}
