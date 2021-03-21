package com.github.sparkzxl.workflow.infrastructure.mapper;

import com.github.sparkzxl.database.base.mapper.SuperMapper;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskRule;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description: 流程跳转规则Mapper 接口
 *
 * @author charles.zhou
 * @date   2020-07-17 13:16:16
 */
@Repository
public interface ExtProcessTaskRuleMapper extends SuperMapper<ExtProcessTaskRule> {

    /**
     * 查询任务流程控制规则
     *
     * @param processDefinitionKey 流程定义key
     * @param sourceTaskDefKey     源任务定义key
     * @param actType              流程类型
     * @return ProcessTaskRule
     */
    @Select("SELECT ptu.id, ptu.task_def_key, ptu.act_type"
            + " FROM ext_process_task_rule ptu INNER JOIN ext_process_detail pd ON ptu.process_detail_id = pd.id"
            + " WHERE pd.process_definition_key = #{processDefinitionKey} AND pd.task_def_key = #{sourceTaskDefKey}"
            + " AND ptu.act_type = #{actType} LIMIT 1")
    ExtProcessTaskRule findActRuTaskRule(@Param("processDefinitionKey") String processDefinitionKey,
                                         @Param("sourceTaskDefKey") String sourceTaskDefKey,
                                         @Param("actType") Integer actType);

    /**
     * 查询流程跳转规则
     *
     * @param processDefinitionKey  流程定义key
     * @param taskDefKey 任务定义key
     * @return List<ProcessTaskRule>
     */
    @Select("SELECT pd.process_definition_key, pd.process_name, pd.task_def_key sourceTaskDefKey,pd.task_name sourceTaskName, ptr.id,"
            + " ptr.process_detail_id,ptr.task_def_key targetTaskDefKey, ptr.task_name targetTaskName,ptr.act_type"
            + " FROM ext_process_detail pd INNER JOIN ext_process_task_rule ptr ON pd.id = ptr.process_detail_id"
            + " WHERE pd.process_definition_key = #{processDefinitionKey} AND pd.task_def_key = #{taskDefKey} ")
    List<ExtProcessTaskRule> getProcessTaskRule(@Param("processDefinitionKey") String processDefinitionKey, @Param("taskDefKey") String taskDefKey);
}
