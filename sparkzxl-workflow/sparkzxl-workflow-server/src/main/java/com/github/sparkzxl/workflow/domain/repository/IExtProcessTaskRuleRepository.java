package com.github.sparkzxl.workflow.domain.repository;

import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskRule;

import java.util.List;

/**
 * description: 流程控制规则 仓储类
 *
 * @author charles.zhou
 * @date   2020-07-20 18:19:15
 */
public interface IExtProcessTaskRuleRepository {

    /**
     * 查询任务流程控制规则
     *
     * @param processDefinitionKey 流程定义key
     * @param sourceTaskDefKey     源任务定义key
     * @param actType              流程类型
     * @return ProcessTaskRule
     */
    ExtProcessTaskRule findActRuTaskRule(String processDefinitionKey, String sourceTaskDefKey, Integer actType);

    /**
     * 查询流程跳转规则
     *
     * @param processDefinitionKey  流程定义key
     * @param taskDefKey 任务定义key
     * @return List<ProcessTaskRule>
     */
    List<ExtProcessTaskRule> getProcessTaskRule(String processDefinitionKey, String taskDefKey);
}
