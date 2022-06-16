package com.github.sparkzxl.workflow.application.service.ext;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.database.base.service.SuperService;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessTaskDetailDTO;
import com.github.sparkzxl.workflow.domain.model.dto.process.ProcessTaskDetailPageDTO;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskDetail;

import java.util.List;

/**
 * description: 流程详细节点 服务类
 *
 * @author charles.zhou
 * @since 2020-07-21 14:22:03
 */
public interface IExtProcessTaskDetailService extends SuperService<ExtProcessTaskDetail> {

    /**
     * 查询流程节点信息
     *
     * @param modelId 模型id
     * @return List<ProcessTaskDetailDTO>
     */
    List<ProcessTaskDetailDTO> getProcessTaskDetail(String modelId);

    /**
     * 分页查询流程列表
     *
     * @param processTaskDetailPageDTO 分页查询参数
     * @return Page<ProcessTaskDetail>
     */
    Page<ExtProcessTaskDetail> getProcessTaskDetailList(ProcessTaskDetailPageDTO processTaskDetailPageDTO);
}
