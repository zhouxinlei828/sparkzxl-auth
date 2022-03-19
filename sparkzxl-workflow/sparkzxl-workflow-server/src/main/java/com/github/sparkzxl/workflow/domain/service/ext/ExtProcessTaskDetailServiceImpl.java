package com.github.sparkzxl.workflow.domain.service.ext;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.database.base.service.impl.SuperServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessTaskDetailService;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessTaskDetailDTO;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessTaskDetailPageDTO;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessTaskDetailRepository;
import com.github.sparkzxl.workflow.infrastructure.convert.ProcessTaskDetailConvert;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskDetail;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessTaskDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 流程详细节点 服务实现类
 *
 * @author charles.zhou
 * @date 2020-07-21 14:22:17
 */
@Service
@RequiredArgsConstructor
public class ExtProcessTaskDetailServiceImpl extends SuperServiceImpl<ExtProcessTaskDetailMapper, ExtProcessTaskDetail> implements IExtProcessTaskDetailService {

    private final IExtProcessTaskDetailRepository processTaskDetailRepository;

    @Override
    public List<ProcessTaskDetailDTO> getProcessTaskDetail(String modelId) {
        List<ExtProcessTaskDetail> processTaskDetails = processTaskDetailRepository.getProcessTaskDetail(modelId);
        return ProcessTaskDetailConvert.INSTANCE.convertProcessTaskDetailDTOs(processTaskDetails);
    }

    @Override
    public Page<ExtProcessTaskDetail> getProcessTaskDetailList(ProcessTaskDetailPageDTO processTaskDetailPageDTO) {
        return processTaskDetailRepository.getProcessTaskDetailList(processTaskDetailPageDTO.getPageNum(),
                processTaskDetailPageDTO.getPageSize(), processTaskDetailPageDTO.getProcessName());
    }
}
