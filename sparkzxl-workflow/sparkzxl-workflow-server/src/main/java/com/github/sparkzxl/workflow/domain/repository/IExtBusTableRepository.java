package com.github.sparkzxl.workflow.domain.repository;

import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTable;

import java.util.List;

/**
 * description: 业务表结构 仓储类
 *
 * @author charles.zhou
 * @date 2021-03-26 13:24:48
 */
public interface IExtBusTableRepository {
    /**
     * 保存业务表结构
     *
     * @param extBusTable 业务表结构
     * @return boolean
     */
    boolean saveBusTable(ExtBusTable extBusTable);

    /**
     * 更新业务表结构
     *
     * @param extBusTable 业务表结构
     * @return boolean
     */
    boolean updateBusTable(ExtBusTable extBusTable);

    /**
     * 删除业务表结构
     *
     * @param ids 主键列表
     * @return List<String>
     */
    List<String> deleteBusTable(List<Long> ids);
}
