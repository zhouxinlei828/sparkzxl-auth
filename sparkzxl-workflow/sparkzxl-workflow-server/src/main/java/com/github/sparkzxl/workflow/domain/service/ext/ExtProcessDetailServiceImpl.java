package com.github.sparkzxl.workflow.domain.service.ext;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.workflow.application.service.ext.IExtProcessDetailService;
import com.github.sparkzxl.workflow.domain.repository.IExtProcessDetailRepository;
import com.github.sparkzxl.workflow.infrastructure.convert.ProcessDetailConvert;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessDetail;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtProcessDetailMapper;
import com.github.sparkzxl.workflow.interfaces.dto.process.ProcessDetailDTO;
import com.github.sparkzxl.workflow.interfaces.dto.process.ProcessDetailPageDTO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: 流程详细节点 服务实现类
 *
 * @author charles.zhou
 * @date   2020-07-21 14:22:17
 */
@Service
public class ExtProcessDetailServiceImpl extends SuperCacheServiceImpl<ExtProcessDetailMapper, ExtProcessDetail> implements IExtProcessDetailService {

    private final IExtProcessDetailRepository processDetailRepository;

    public ExtProcessDetailServiceImpl(IExtProcessDetailRepository processDetailRepository) {
        this.processDetailRepository = processDetailRepository;
    }

    @Override
    public List<ProcessDetailDTO> getProcessDetail(String modelId) {
        List<ExtProcessDetail> processDetails = processDetailRepository.getProcessDetail(modelId);
        List<ProcessDetailDTO> processDetailDTOList = Lists.newArrayList();
        processDetails.forEach(processDetail -> processDetailDTOList.add(ProcessDetailConvert.INSTANCE.convertProcessDetailDTO(processDetail)));
        return processDetailDTOList;
    }

    @Override
    public PageInfo<ExtProcessDetail> getProcessDetailList(ProcessDetailPageDTO processDetailPageDTO) {
        return processDetailRepository.getProcessDetailList(processDetailPageDTO.getPageNum(),
                processDetailPageDTO.getPageSize(), processDetailPageDTO.getProcessName());
    }

    @Override
    protected String getRegion() {
        return null;
    }
}
