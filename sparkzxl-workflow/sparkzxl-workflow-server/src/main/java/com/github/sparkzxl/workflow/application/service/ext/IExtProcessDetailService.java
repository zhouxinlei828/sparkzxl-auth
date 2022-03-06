package com.github.sparkzxl.workflow.application.service.ext;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.database.base.service.SuperService;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessDetailDTO;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessDetailPageDTO;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessDetail;

import java.util.List;

/**
 * description: 流程详细节点 服务类
 *
 * @author charles.zhou
 * @date 2020-07-21 14:22:03
 */
public interface IExtProcessDetailService extends SuperService<ExtProcessDetail> {

    /**
     * 查询流程节点信息
     *
     * @param modelId 模型id
     * @return List<ProcessDetailDTO>
     */
    List<ProcessDetailDTO> getProcessDetail(String modelId);

    /**
     * 分页查询流程列表
     *
     * @param processDetailPageDTO 分页查询参数
     * @return PageInfo<ProcessDetail>
     */
    PageInfo<ExtProcessDetail> getProcessDetailList(ProcessDetailPageDTO processDetailPageDTO);
}
