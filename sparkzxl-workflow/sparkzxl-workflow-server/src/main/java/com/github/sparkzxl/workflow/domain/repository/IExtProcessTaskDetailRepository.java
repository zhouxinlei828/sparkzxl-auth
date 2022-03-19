package com.github.sparkzxl.workflow.domain.repository;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtProcessTaskDetail;

import java.util.List;

/**
 * description: 流程任务节点 仓储类
 *
 * @author charles.zhou
 * @date 2020-07-21 15:33:56
 */
public interface IExtProcessTaskDetailRepository {

    /**
     * 流程任务节点列表查询
     *
     * @param pageNum  当前页
     * @param pageSize 每页显示大小
     * @param name     流程名称
     * @return List<ProcessTaskDetail>
     */
    Page<ExtProcessTaskDetail> getProcessTaskDetailList(int pageNum, int pageSize, String name);

    /**
     * 查询流程任务节点信息
     *
     * @param modelId 模型id
     * @return List<ProcessTaskDetailDTO>
     */
    List<ExtProcessTaskDetail> getProcessTaskDetail(String modelId);
}
