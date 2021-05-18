package com.github.sparkzxl.workflow.infrastructure.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sparkzxl.workflow.domain.repository.IExtBusTableRepository;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTable;
import com.github.sparkzxl.workflow.infrastructure.entity.ExtBusTableColumn;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableColumnMapper;
import com.github.sparkzxl.workflow.infrastructure.mapper.ExtBusTableMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description: 业务表结构 仓储实现类
 *
 * @author charles.zhou
 * @date 2021-03-26 13:32:27
 */
@Repository
public class ExtBusTableRepository implements IExtBusTableRepository {

    @Autowired
    private ExtBusTableMapper busTableMapper;

    @Autowired
    private ExtBusTableColumnMapper tableColumnMapper;

    @Override
    public boolean saveBusTable(ExtBusTable extBusTable) {
        busTableMapper.insert(extBusTable);
        List<ExtBusTableColumn> columnList = extBusTable.getColumnList();
        if (CollectionUtils.isNotEmpty(columnList)) {
            columnList.forEach(column -> column.setTableId(extBusTable.getId()));
            tableColumnMapper.insertBatchSomeColumn(columnList);
        }
        return true;
    }

    @Override
    public boolean updateBusTable(ExtBusTable extBusTable) {
        busTableMapper.updateById(extBusTable);
        List<ExtBusTableColumn> columnList = extBusTable.getColumnList();
        tableColumnMapper.delete(new LambdaQueryWrapper<ExtBusTableColumn>().eq(ExtBusTableColumn::getTableId, extBusTable.getId()));
        if (CollectionUtils.isNotEmpty(columnList)) {
            columnList.forEach(column -> column.setTableId(extBusTable.getId()));
            tableColumnMapper.insertBatchSomeColumn(columnList);
        }
        return true;
    }

    @Override
    public List<String> deleteBusTable(List<Long> ids) {
        List<ExtBusTable> extBusTables = busTableMapper.selectBatchIds(ids);
        List<String> tableNames = extBusTables.stream().map(ExtBusTable::getTableName).collect(Collectors.toList());
        tableColumnMapper.delete(new LambdaQueryWrapper<ExtBusTableColumn>().in(ExtBusTableColumn::getTableId, ids));
        busTableMapper.deleteBatchIds(ids);
        return tableNames;
    }
}
