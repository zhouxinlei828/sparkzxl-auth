package com.github.sparkzxl.workflow.domain.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.sparkzxl.workflow.infrastructure.entity.ActReModel;

/**
 * description: 模型 仓储类
 *
 * @author charles.zhou
 * @since 2020-07-25 11:16:57
 */
public interface IActReModelRepository {
    /**
     * 查询模型列表
     *
     * @param page 分页
     * @param key  模型key
     * @param name 模型名称
     * @return Page<ActReModel>
     */
    Page<ActReModel> actReModelList(Page<ActReModel> page, String key, String name);
}
