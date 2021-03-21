package com.github.sparkzxl.workflow.domain.repository;

import com.github.pagehelper.PageInfo;
import com.github.sparkzxl.workflow.infrastructure.entity.ActReModel;

/**
 * description: 模型 仓储类
 *
 * @author charles.zhou
 * @date   2020-07-25 11:16:57
 */
public interface IActReModelRepository {
    /**
     * 查询模型列表
     *
     * @param key  模型key
     * @param name 模型名称
     * @return PageInfo<ActReModel>
     */
    PageInfo<ActReModel> actReModelList(String key, String name);
}
