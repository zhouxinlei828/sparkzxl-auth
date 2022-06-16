package com.github.sparkzxl.workflow.infrastructure.convert;

import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessTaskDetailDTO;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * description: ProcessTaskRule 对象Convert
 *
 * @author charles.zhou
 * @since 2020-06-05 21:28:06
 */
@Mapper
public interface ProcessTaskDetailConvert {

    ProcessTaskDetailConvert INSTANCE = Mappers.getMapper(ProcessTaskDetailConvert.class);

    /**
     * ProcessTaskDetail 转换为 ProcessTaskDetailDTO
     *
     * @param ProcessTaskDetail 流程详细
     * @return ProcessTaskDetailDTO
     */
    ProcessTaskDetailDTO convertProcessTaskDetailDTO(ExtProcessTaskDetail ProcessTaskDetail);

    /**
     * processTaskDetailList 转换为 List<ProcessTaskDetailDTO>
     *
     * @param processTaskDetailList 任务节点列表
     * @return ProcessTaskDetailDTO
     */
    List<ProcessTaskDetailDTO> convertProcessTaskDetailDTOs(List<ExtProcessTaskDetail> processTaskDetailList);

}
