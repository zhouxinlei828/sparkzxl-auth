package com.github.sparkzxl.workflow.infrastructure.convert;

import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskRule;
import com.github.sparkzxl.workflow.interfaces.dto.process.TaskRuleSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * description: ProcessTaskRule 对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface ProcessTaskRuleConvert {

    ProcessTaskRuleConvert INSTANCE = Mappers.getMapper(ProcessTaskRuleConvert.class);

    /**
     * TaskRuleSaveDTO转化为ProcessTaskRule
     *
     * @param taskRuleSaveDTO TaskRule保存对象
     * @return ProcessTaskRule
     */
    ExtProcessTaskRule convertTaskRuleSaveDTO(TaskRuleSaveDTO taskRuleSaveDTO);

}
