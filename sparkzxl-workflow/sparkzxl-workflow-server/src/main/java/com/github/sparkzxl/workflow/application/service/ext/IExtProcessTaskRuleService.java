package com.github.sparkzxl.workflow.application.service.ext;

import com.github.sparkzxl.database.base.service.SuperCacheService;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskRule;
import com.github.sparkzxl.workflow.interfaces.dto.process.ProcessActionDTO;
import com.github.sparkzxl.workflow.interfaces.dto.process.TaskRuleSaveDTO;

import java.util.List;

/**
 * description: 流程跳转控制 服务类
 *
 * @author charles.zhou
 * @date   2020-07-17 13:20:37
 */
public interface IExtProcessTaskRuleService extends SuperCacheService<ExtProcessTaskRule> {


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
     * 保存流程跳转规则
     *
     * @param taskRuleSaveDTO 流程跳转规则保存实体类
     * @return boolean
     */
    boolean saveProcessTaskRule(TaskRuleSaveDTO taskRuleSaveDTO);

    /**
     * 查询流程跳转规则
     *
     * @param processDefinitionKey  流程定义key
     * @param taskDefKey 任务定义key
     * @return List<ProcessTaskRule>
     */
    List<ExtProcessTaskRule> getProcessTaskRule(String processDefinitionKey, String taskDefKey);

    /**
     * 获取流程动作类型
     *
     * @return List<ProcessActionDTO>
     */
    List<ProcessActionDTO> getProcessAction();

}
