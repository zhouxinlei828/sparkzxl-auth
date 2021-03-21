package com.github.sparkzxl.workflow.domain.repository;


import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessDetail;

import java.util.List;

/**
 * description: 流程详细节点 仓储类
 *
 * @author charles.zhou
 * @date   2020-07-21 15:33:56
 */
public interface IExtProcessDetailRepository {

    /**
     * 流程详细节点列表查询
     *
     * @param pageNum  当前页
     * @param pageSize 每页显示大小
     * @param name     流程名称
     * @return List<ProcessDetail>
     */
    PageInfo<ExtProcessDetail> getProcessDetailList(int pageNum, int pageSize, String name);

    /**
     * 查询流程节点信息
     *
     * @param modelId 模型id
     * @return List<ProcessDetailDTO>
     */
    List<ExtProcessDetail> getProcessDetail(String modelId);
}
